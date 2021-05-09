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

public class questionfive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionfive );
        List<String> subjects =
                Arrays.asList ( "Humanities", "Sciences", "Social Sciences", "Languages", "Mathematics" );
        Spinner spinner5 = findViewById ( R.id.spinner5 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, subjects );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner5.setAdapter ( adapter );
        Button btn5 = findViewById ( R.id.btn5 );
        btn5.setOnClickListener ( v -> {
            String subjects1 = spinner5.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            Intent topage6 = new Intent ( questionfive.this, questionsix.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            Intent questionfive = receiveIntent.putExtra ( "subjects1", subjects1 );
            long questiononeanswer = receiveIntent.getLongExtra ( "q1pos", 0 );
            long questiontwoanswer = receiveIntent.getLongExtra ( "q2pos", 0 );
            long questionthreeanswer = receiveIntent.getLongExtra ( "q3pos", 0 );
            long questionfouranswer = receiveIntent.getLongExtra ( "q4pos", 0 );
            long questionfiveanswer = spinner5.getSelectedItemId ();
            topage6.putExtra ( "location1", questionone );
            topage6.putExtra ( "age1", questiontwo );
            topage6.putExtra ( "gender1", questionthree );
            topage6.putExtra ( "ethnic1", questionfour );
            topage6.putExtra ( "userapikey", apikey1 );
            topage6.putExtra ( "email", email1 );
            topage6.putExtra ( "subjects1", subjects1 );
            topage6.putExtra ( "q1pos", questiononeanswer );
            topage6.putExtra ( "q2pos", questiontwoanswer );
            topage6.putExtra ( "q3pos", questionthreeanswer );
            topage6.putExtra ( "q4pos", questionfouranswer );
            topage6.putExtra ( "q5pos", questionfiveanswer );
            startActivity ( topage6 );

            Toast.makeText ( getApplicationContext (), "You selected " + subjects1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + subjects1 + questionfive );
            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "Question 5 answer :" + " " + questionfiveanswer );


        } );

    }
}
