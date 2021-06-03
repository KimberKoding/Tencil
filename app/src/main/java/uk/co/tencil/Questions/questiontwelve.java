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

import uk.co.tencil.Categories.Categories;
import uk.co.tencil.R;

public class questiontwelve extends AppCompatActivity {

    List<Categories> categoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questiontwelve );
        List<String> school =
                Arrays.asList (
                        "University",
                        "Apprenticeship",
                        "Full-Time Work",
                        "Part-Time Work",
                        "Travelling"

                );

        Spinner spinner14 = findViewById ( R.id.spinner9 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, school );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner14.setAdapter ( adapter );
        Button btn12 = findViewById ( R.id.btn12 );
        btn12.setOnClickListener ( v -> {
            String school1 = spinner14.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            Bundle bundle = receiveIntent.getExtras ();
            Intent topage12 = new Intent ( questiontwelve.this, questionthirteen.class );
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
            String questioneleven = receiveIntent.getStringExtra ( "statement1" );
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
            String questionelevenanswer = receiveIntent.getStringExtra ( "q11pos" );
            String questiontwelveanswer = String.valueOf ( spinner14.getSelectedItemId () );
            Intent questiontwelve = receiveIntent.putExtra ( "school1", school1 );
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
            topage12.putExtra ( "statement1", questioneleven );
            topage12.putExtra ( "school1", questiontwelve );
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
            topage12.putExtra ( "q11pos", questionelevenanswer );
            topage12.putExtra ( "q12pos", questiontwelveanswer );
            startActivity ( topage12 );

            Toast.makeText ( getApplicationContext (), "You selected " + school1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + questionsix
                            + " " + " " + questionseven + questioneight + questionnine + questionten + questioneleven + school1 );
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
            System.out.println ( "Question 11 answer :" + " " + questionelevenanswer );
            System.out.println ( "Question 12 answer :" + " " + questiontwelveanswer );

        } );

    }


}


