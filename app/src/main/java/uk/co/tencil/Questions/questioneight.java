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

public class questioneight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questioneight );
        List<String> smedia =
                Arrays.asList (
                        "Facebook",
                        "Twitter",
                        "TikTok",
                        "Instagram",
                        "Snapchat",
                        "Youtube",
                        "Linkedin",
                        "Other"

                );

        Spinner spinner11 = findViewById ( R.id.spinner11 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, smedia );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner11.setAdapter ( adapter );
        Button btn8 = findViewById ( R.id.btn8 );
        btn8.setOnClickListener ( v -> {
            String smedia1 = spinner11.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            Intent topage8 = new Intent ( questioneight.this, questionnine.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            String questionfive = receiveIntent.getStringExtra ( "subjects1" );
            String questionsix = receiveIntent.getStringExtra ( "hobbies1" );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            String questionseven = receiveIntent.getStringExtra ( "sports1" );
            Intent questioneight = receiveIntent.putExtra ( "smedia1", smedia1 );
            String questiononeanswer = receiveIntent.getStringExtra ( "q1pos" );
            String questiontwoanswer = receiveIntent.getStringExtra ( "q2pos" );
            String questionthreeanswer = receiveIntent.getStringExtra ( "q3pos" );
            String questionfouranswer = receiveIntent.getStringExtra ( "q4pos" );
            String questionfiveanswer = receiveIntent.getStringExtra ( "q5pos" );
            String questionsixanswer = receiveIntent.getStringExtra ( "q6pos" );
            String questionsevenanswer = receiveIntent.getStringExtra ( "q7pos" );
            String questioneightanswer = String.valueOf ( spinner11.getSelectedItemId () );

            topage8.putExtra ( "location1", questionone );
            topage8.putExtra ( "age1", questiontwo );
            topage8.putExtra ( "gender1", questionthree );
            topage8.putExtra ( "ethnic1", questionfour );
            topage8.putExtra ( "subjects1", questionfive );
            topage8.putExtra ( "hobbies1", questionsix );
            topage8.putExtra ( "sports1", questionseven );
            topage8.putExtra ( "userapikey", apikey1 );
            topage8.putExtra ( "email", email1 );
            topage8.putExtra ( "smedia1", smedia1 );
            topage8.putExtra ( "q1pos", questiononeanswer );
            topage8.putExtra ( "q2pos", questiontwoanswer );
            topage8.putExtra ( "q3pos", questionthreeanswer );
            topage8.putExtra ( "q4pos", questionfouranswer );
            topage8.putExtra ( "q5pos", questionfiveanswer );
            topage8.putExtra ( "q6pos", questionsixanswer );
            topage8.putExtra ( "q7pos", questionsevenanswer );
            topage8.putExtra ( "q8pos", questioneightanswer );
            startActivity ( topage8 );

            Toast.makeText ( getApplicationContext (), "You selected " + smedia1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( "QUESTION 8 : " + questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + questionsix
                            + " " + " " + questionseven + smedia1 );

            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "Question 5 answer :" + " " + questionfiveanswer );
            System.out.println ( "Question 6 answer :" + " " + questionsixanswer );
            System.out.println ( "Question 7 answer :" + " " + questionsevenanswer );
            System.out.println ( "Question 8 answer :" + " " + questioneightanswer );
        } );

    }


}
