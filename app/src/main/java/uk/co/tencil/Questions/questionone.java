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

public class questionone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionone );
        Intent receiveIntent = getIntent ();
        Bundle logininfo = receiveIntent.getBundleExtra ( "logininfo" );
        List<String> location =
                Arrays.asList ( "Wales", "England", "Scotland", "Northern Ireland", "Other" );

        Spinner spinner0 = findViewById ( R.id.spinner0 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, location );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner0.setAdapter ( adapter );

        Button btn1 = findViewById ( R.id.btn1 );
        btn1.setOnClickListener ( v -> {
            String location1 = spinner0.getSelectedItem ().toString ();
            System.out.println ( "This is the position of the answer " + spinner0.getSelectedItemPosition () );
            String q1pos = String.valueOf ( spinner0.getSelectedItemId () );
            String apikey = logininfo.getString ( "userapikey" );
            String email = logininfo.getString ( "email" );
            Toast.makeText ( getApplicationContext (), "You selected " + location1, Toast.LENGTH_SHORT ).show ();
            Intent toQuestiontwo = new Intent ( questionone.this, questiontwo.class );
            toQuestiontwo.putExtra ( "location1", location1 );
            toQuestiontwo.putExtra ( "userapikey", apikey );
            toQuestiontwo.putExtra ( "email", email );
            toQuestiontwo.putExtra ( "q1pos", q1pos );
            System.out.println ( toQuestiontwo.getStringExtra ( "location1" ) );
            System.out.println ( toQuestiontwo.putExtra ( "q1pos", q1pos ) );
            System.out.println ( apikey );
            startActivity ( toQuestiontwo );

        } );
    }


}
