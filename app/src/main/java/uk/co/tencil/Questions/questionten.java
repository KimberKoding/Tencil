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

public class questionten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionten );
        List<String> console =
                Arrays.asList (
                        "Playstation",
                        "Xbox",
                        "PC",
                        "Nintendo",
                        "Other",
                        "None"

                );

        Spinner spinner11 = findViewById ( R.id.spinner13 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, console );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner11.setAdapter ( adapter );
        Button btn10 = findViewById ( R.id.btn10 );
        btn10.setOnClickListener ( v -> {

            String console1 = spinner11.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            Intent topage11 = new Intent ( questionten.this, questioneleven.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            String questionfive = receiveIntent.getStringExtra ( "subjects1" );
            String questionsix = receiveIntent.getStringExtra ( "hobbies1" );
            String questionseven = receiveIntent.getStringExtra ( "sports1" );
            String questioneight = receiveIntent.getStringExtra ( "smedia1" );
            String questionnine = receiveIntent.getStringExtra ( "genre1" );
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
            long questionnineanswer = receiveIntent.getLongExtra ( "q9pos", 0 );
            long questiontenanswer = spinner11.getSelectedItemId ();
            Intent questionten = receiveIntent.putExtra ( "console1", console1 );
            topage11.putExtra ( "location1", questionone );
            topage11.putExtra ( "age1", questiontwo );
            topage11.putExtra ( "gender1", questionthree );
            topage11.putExtra ( "ethnic1", questionfour );
            topage11.putExtra ( "subjects1", questionfive );
            topage11.putExtra ( "hobbies1", questionsix );
            topage11.putExtra ( "sports1", questionseven );
            topage11.putExtra ( "smedia1", questioneight );
            topage11.putExtra ( "genre1", questionnine );
            topage11.putExtra ( "userapikey", apikey1 );
            topage11.putExtra ( "email", email1 );
            topage11.putExtra ( "console1", questionten );
            topage11.putExtra ( "q1pos", questiononeanswer );
            topage11.putExtra ( "q2pos", questiontwoanswer );
            topage11.putExtra ( "q3pos", questionthreeanswer );
            topage11.putExtra ( "q4pos", questionfouranswer );
            topage11.putExtra ( "q5pos", questionfiveanswer );
            topage11.putExtra ( "q6pos", questionsixanswer );
            topage11.putExtra ( "q7pos", questionsevenanswer );
            topage11.putExtra ( "q8pos", questioneightanswer );
            topage11.putExtra ( "q9pos", questionnineanswer );
            topage11.putExtra ( "q10pos", questiontenanswer );
            startActivity ( topage11 );

            Toast.makeText ( getApplicationContext (), "You selected " + console1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + questionsix
                            + " " + " " + questionseven + questioneight + questionnine + console1 );
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

        } );

    }


}
