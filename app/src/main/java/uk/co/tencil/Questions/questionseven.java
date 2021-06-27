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

public class questionseven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionseven );
        List<String> sports =
                Arrays.asList (
                        "Rugby",
                        "Football",
                        "Cricket",
                        "Golf",
                        "Hiking",
                        "Swimming",
                        "Ballet",
                        "Other"

                );

        Spinner spinner10 = findViewById ( R.id.spinner10 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, sports );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner10.setAdapter ( adapter );
        Button btn7 = findViewById ( R.id.btn7 );
        btn7.setOnClickListener ( v -> {
            String sports1 = spinner10.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            receiveIntent.getExtras ();
            Intent topage7 = new Intent ( questionseven.this, questioneight.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            String questionfive = receiveIntent.getStringExtra ( "subjects1" );
            String questionsix = receiveIntent.getStringExtra ( "hobbies1" );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            Intent questionseven = receiveIntent.putExtra ( "sports1", sports1 );
            String questiononeanswer = receiveIntent.getStringExtra ( "q1pos" );
            String questiontwoanswer = receiveIntent.getStringExtra ( "q2pos" );
            String questionthreeanswer = receiveIntent.getStringExtra ( "q3pos" );
            String questionfouranswer = receiveIntent.getStringExtra ( "q4pos" );
            String questionfiveanswer = receiveIntent.getStringExtra ( "q5pos" );
            String questionsixanswer = receiveIntent.getStringExtra ( "q6pos" );
            String questionsevenanswer = String.valueOf ( spinner10.getSelectedItemId () );

            topage7.putExtra ( "location1", questionone );
            topage7.putExtra ( "age1", questiontwo );
            topage7.putExtra ( "gender1", questionthree );
            topage7.putExtra ( "ethnic1", questionfour );
            topage7.putExtra ( "subjects1", questionfive );
            topage7.putExtra ( "hobbies1", questionsix );
            topage7.putExtra ( "userapikey", apikey1 );
            topage7.putExtra ( "email", email1 );
            topage7.putExtra ( "sports1", questionseven );
            topage7.putExtra ( "q1pos", questiononeanswer );
            topage7.putExtra ( "q2pos", questiontwoanswer );
            topage7.putExtra ( "q3pos", questionthreeanswer );
            topage7.putExtra ( "q4pos", questionfouranswer );
            topage7.putExtra ( "q5pos", questionfiveanswer );
            topage7.putExtra ( "q6pos", questionsixanswer );
            topage7.putExtra ( "q7pos", questionsevenanswer );
            startActivity ( topage7 );

            Toast.makeText ( getApplicationContext (), "You selected " + sports1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + questionsix + " " + " " + sports1 );

            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "Question 5 answer :" + " " + questionfiveanswer );
            System.out.println ( "Question 6 answer :" + " " + questionsixanswer );
            System.out.println ( "Question 7 answer :" + " " + questionsevenanswer );
        } );

    }


}

