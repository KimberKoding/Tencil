package uk.co.tencil.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import uk.co.tencil.R;

public class questiontwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questiontwo );
        List<String> age =
                Arrays.asList ( "13-14", "15-16", "16-17", "18+", "Prefer not to say" );
        Spinner spinner1 = findViewById ( R.id.spinner1 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, age );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner1.setAdapter ( adapter );
        Button btn2 = findViewById ( R.id.btn2 );

        btn2.setOnClickListener ( v -> {
            String age1 = spinner1.getSelectedItem ().toString ();
            Toast.makeText ( getApplicationContext (), "You Selected " + age1,
                    Toast.LENGTH_SHORT ).show ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email = receiveIntent.getStringExtra ( "email" );
            String questiononeanswer = receiveIntent.getStringExtra ( "q1pos" );
            String q2pos = String.valueOf ( spinner1.getSelectedItemId () );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            Intent toPage3 = new Intent ( questiontwo.this, questionthree.class );
            toPage3.putExtra ( "age1", age1 );
            toPage3.putExtra ( "userapikey", apikey1 );
            toPage3.putExtra ( "email", email );
            toPage3.putExtra ( "location1", questionone );
            toPage3.putExtra ( "q1pos", questiononeanswer );
            toPage3.putExtra ( "q2pos", q2pos );

            System.out.println ( questionone + age1 + apikey1 + " " + "Question 2 answer:" + q2pos + "Question one answer : " + questiononeanswer );

            startActivity ( toPage3 );


        } );
    }


}
