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

public class questionfour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionfour );
        List<String> ethnic =
                Arrays.asList ( "White", "Gypsy", "Asian", "Black", "Mixed Race", "Other", "Prefer Not To Say" );
        Spinner spinner4 = findViewById ( R.id.spinner4 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, ethnic );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner4.setAdapter ( adapter );
        Button btn4 = findViewById ( R.id.btn4 );
        btn4.setOnClickListener ( v -> {
            String ethnic1 = spinner4.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            Intent topage5 = new Intent ( questionfour.this, questionfive.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            Intent questionfour = receiveIntent.putExtra ( "ethnic1", ethnic1 );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            long questiononeanswer = receiveIntent.getLongExtra ( "q1pos", 0 );
            long questiontwoanswer = receiveIntent.getLongExtra ( "q2pos", 0 );
            long questionthreeanswer = receiveIntent.getLongExtra ( "q3pos", 0 );
            long questionfouranswer = spinner4.getSelectedItemId ();

            topage5.putExtra ( "location1", questionone );
            topage5.putExtra ( "age1", questiontwo );
            topage5.putExtra ( "gender1", questionthree );
            topage5.putExtra ( "userapikey", apikey1 );
            topage5.putExtra ( "email", email1 );
            topage5.putExtra ( "ethnic1", ethnic1 );
            topage5.putExtra ( "q1pos", questiononeanswer );
            topage5.putExtra ( "q2pos", questiontwoanswer );
            topage5.putExtra ( "q3pos", questionthreeanswer );
            topage5.putExtra ( "q4pos", questionfouranswer );
            Toast.makeText ( getApplicationContext (), "You selected " + ethnic1, Toast.LENGTH_SHORT ).show ();
            System.out.println ( questionone + "" + questiontwo + "" + "" + questionthree + "" + ethnic1 );
            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "UID :" + " " + apikey1 );
            System.out.println ( "Email :" + " " + email1 );
            startActivity ( topage5 );


        } );
    }


}
