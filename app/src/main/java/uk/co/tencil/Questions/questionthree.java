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

public class questionthree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionthree );
        List<String> gender =
                Arrays.asList ( "Male", "Female", "Transgender", "Non-Binary", "Prefer not to say" );
        Spinner spinner2 = findViewById ( R.id.spinner3 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, gender );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner2.setAdapter ( adapter );
        Button btn3 = findViewById ( R.id.btn3 );
        btn3.setOnClickListener ( v -> {
            String gender1 = spinner2.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email = receiveIntent.getStringExtra ( "email" );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            long questiononeanswer = receiveIntent.getLongExtra ( "q1pos", 0 );
            long questiontwoanswer = receiveIntent.getLongExtra ( "q2pos", 0 );
            long questionthreeanswer = spinner2.getSelectedItemId ();

            Intent topage4 = new Intent ( questionthree.this, questionfour.class );
            topage4.putExtra ( "location1", questionone );
            topage4.putExtra ( "age1", questiontwo );
            topage4.putExtra ( "q1pos", questiononeanswer );
            topage4.putExtra ( "q2pos", questiontwoanswer );
            topage4.putExtra ( "q3pos", questionthreeanswer );
            topage4.putExtra ( "userapikey", apikey1 );
            topage4.putExtra ( "email", email );

            Toast.makeText ( getApplicationContext (), "You selected " + gender1, Toast.LENGTH_SHORT ).show ();
            System.out.println ( "QUESTINS SO FAR " + questionone + "" + questiontwo + "" + gender1 );
            startActivity ( topage4 );

        } );


    }

}
