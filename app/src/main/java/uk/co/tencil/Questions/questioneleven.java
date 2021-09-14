package uk.co.tencil.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import uk.co.tencil.R;

@SuppressWarnings("ALL")
public class questioneleven extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questioneleven );
        List<String> statement =
                Arrays.asList (
                        "I Am Passionate About My Work",
                        "I Am Highly Organised.",
                        "I Am Ambitious And Driven",
                        "I am a People Person",
                        "Im a Natural Leader",
                        "I am Results Orientated"

                );

        Spinner spinner14 = findViewById ( R.id.spinner14 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, statement );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner14.setAdapter ( adapter );
        Button btn11 = findViewById ( R.id.btn11 );
        btn11.setOnClickListener ( v -> {

            String statement1 = spinner14.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            Intent topage12 = new Intent ( questioneleven.this, questiontwelve.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            String questionfive = receiveIntent.getStringExtra ( "subjects1" );
            String questionsix = receiveIntent.getStringExtra ( "hobbies1" );
            String questionseven = receiveIntent.getStringExtra ( "sports1" );
            String questioneight = receiveIntent.getStringExtra ( "smedia1" );
            String questionnine = receiveIntent.getStringExtra ( "genre1" );
            String questionten = receiveIntent.getStringExtra ( "console1" );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            String questiononeanswer = receiveIntent.getStringExtra ( "q1pos" );
            String questiontwoanswer = receiveIntent.getStringExtra ( "q2pos" );
            String questionthreeanswer = receiveIntent.getStringExtra ( "q3pos" );
            String questionfouranswer = receiveIntent.getStringExtra ( "q4pos" );
            String questionfiveanswer = receiveIntent.getStringExtra ( "q5pos" );
            String questionsixanswer = receiveIntent.getStringExtra ( "q6pos" );
            String questionsevenanswer = receiveIntent.getStringExtra ( "q7pos" );
            String questioneightanswer = receiveIntent.getStringExtra ( "q8pos" );
            String questionnineanswer = receiveIntent.getStringExtra ( "q9pos" );
            String questiontenanswer = receiveIntent.getStringExtra ( "q10pos" );
            String questioneleveneanswer = String.valueOf ( spinner14.getSelectedItemId () );
            Intent questioneleven = receiveIntent.putExtra ( "statement1", statement1 );
            topage12.putExtra ( "location1", questionone );
            topage12.putExtra ( "age1", questiontwo );
            topage12.putExtra ( "gender1", questionthree );
            topage12.putExtra ( "ethnic1", questionfour );
            topage12.putExtra ( "subjects1", questionfive );
            topage12.putExtra ( "hobbies1", questionsix );
            topage12.putExtra ( "sports1", questionseven );
            topage12.putExtra ( "smedia1", questioneight );
            topage12.putExtra ( "genre1", questionnine );
            topage12.putExtra ( "console1", questionten );
            topage12.putExtra ( "userapikey", apikey1 );
            topage12.putExtra ( "email", email1 );
            topage12.putExtra ( "statement1", statement1 );
            topage12.putExtra ( "q1pos", questiononeanswer );
            topage12.putExtra ( "q2pos", questiontwoanswer );
            topage12.putExtra ( "q3pos", questionthreeanswer );
            topage12.putExtra ( "q4pos", questionfouranswer );
            topage12.putExtra ( "q5pos", questionfiveanswer );
            topage12.putExtra ( "q6pos", questionsixanswer );
            topage12.putExtra ( "q7pos", questionsevenanswer );
            topage12.putExtra ( "q8pos", questioneightanswer );
            topage12.putExtra ( "q9pos", questionnineanswer );
            topage12.putExtra ( "q10pos", questiontenanswer );
            topage12.putExtra ( "q11pos", questioneleveneanswer );
            startActivity ( topage12 );

            Toast.makeText ( getApplicationContext (), "You selected " + statement1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + questionsix
                            + " " + " " + questionseven + questioneight + questionnine + questionten + statement1 );
            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "Question 5 answer :" + " " + questionfiveanswer );
            System.out.println ( "Question 6 answer :" + " " + questionsixanswer );
            System.out.println ( "Question 7 answer :" + " " + questionsevenanswer );
            System.out.println ( "Question 8 answer :" + " " + questioneightanswer );
            System.out.println ( "Question 9 answer :" + " " + questionnineanswer );
            System.out.println ( "Question 10 answer :" + " " + questiontenanswer );
            System.out.println ( "Question 11 answer :" + " " + questioneleveneanswer );

        } );

    }


}


