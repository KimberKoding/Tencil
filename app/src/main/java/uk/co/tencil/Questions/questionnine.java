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

public class questionnine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionnine );
        List<String> genre =
                Arrays.asList (
                        "Hip Hop",
                        "Pop Music",
                        "House Music",
                        "Techno",
                        "Jazz",
                        "Rock",
                        "Heavy Metal",
                        "Other"

                );

        Spinner spinner11 = findViewById ( R.id.spinner12 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, genre );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner11.setAdapter ( adapter );
        Button btn9 = findViewById ( R.id.btn9 );
        btn9.setOnClickListener ( v -> {
            String genre1 = spinner11.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            Bundle bundle = receiveIntent.getExtras ();
            Intent topage8 = new Intent ( questionnine.this, questionten.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            String questionfive = receiveIntent.getStringExtra ( "subjects1" );
            String questionsix = receiveIntent.getStringExtra ( "hobbies1" );
            String questionseven = receiveIntent.getStringExtra ( "sports1" );
            String questioneight = receiveIntent.getStringExtra ( "smedia1" );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            long questiononeanswer = receiveIntent.getLongExtra ( "q1pos", 0 );
            long questiontwoanswer = receiveIntent.getLongExtra ( "q2pos", 0 );
            long questionthreeanswer = receiveIntent.getLongExtra ( "q3pos", 0 );
            long questionfouranswer = receiveIntent.getLongExtra ( "q4pos", 0 );
            long questionfiveanswer = receiveIntent.getLongExtra ( "q5pos", 0 );
            long questionsixanswer = receiveIntent.getLongExtra ( "q6pos", 0 );
            long questionsevenanswer = receiveIntent.getLongExtra ( "q7pos", 0 );
            long questioneightanswer = receiveIntent.getLongExtra ( "q8pos", 0 );
            long questionnineanswer = spinner11.getSelectedItemId ();

            Intent questionnine = receiveIntent.putExtra ( "genre1", genre1 );
            topage8.putExtra ( "location1", questionone );
            topage8.putExtra ( "age1", questiontwo );
            topage8.putExtra ( "gender1", questionthree );
            topage8.putExtra ( "ethnic1", questionfour );
            topage8.putExtra ( "subjects1", questionfive );
            topage8.putExtra ( "hobbies1", questionsix );
            topage8.putExtra ( "sports1", questionseven );
            topage8.putExtra ( "smedia1", questioneight );
            topage8.putExtra ( "userapikey", apikey1 );
            topage8.putExtra ( "email", email1 );
            topage8.putExtra ( "genre1", genre1 );
            topage8.putExtra ( "q1pos", questiononeanswer );
            topage8.putExtra ( "q2pos", questiontwoanswer );
            topage8.putExtra ( "q3pos", questionthreeanswer );
            topage8.putExtra ( "q4pos", questionfouranswer );
            topage8.putExtra ( "q5pos", questionfiveanswer );
            topage8.putExtra ( "q6pos", questionsixanswer );
            topage8.putExtra ( "q7pos", questionsevenanswer );
            topage8.putExtra ( "q8pos", questioneightanswer );
            topage8.putExtra ( "q9pos", questionnineanswer );
            startActivity ( topage8 );

            Toast.makeText ( getApplicationContext (), "You selected " + genre1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( "QUESTION 9 : " + questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + questionsix
                            + " " + " " + questionseven + questioneight + genre1 );

            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "Question 5 answer :" + " " + questionfiveanswer );
            System.out.println ( "Question 6 answer :" + " " + questionsixanswer );
            System.out.println ( "Question 7 answer :" + " " + questionsevenanswer );
            System.out.println ( "Question 8 answer :" + " " + questioneightanswer );
            System.out.println ( "Question 9 answer :" + " " + questionnineanswer );
            System.out.println ( "Email :" + " " + email1 );

        } );

    }


}


