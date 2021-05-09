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

public class questionsix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionsix );
        List<String> hobbies =
                Arrays.asList (
                        "Sports",
                        "Social Media",
                        "Music",
                        "Gaming",
                        "Technology",
                        "Arts and Design",
                        "Other"
                );

        Spinner spinner6 = findViewById ( R.id.spinner7 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, hobbies );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner6.setAdapter ( adapter );
        Button btn6 = findViewById ( R.id.btn6 );
        btn6.setOnClickListener ( v -> {
            String hobbies1 = spinner6.getSelectedItem ().toString ();
            Intent receiveIntent = getIntent ();
            Bundle bundle = receiveIntent.getExtras ();
            Intent topage7 = new Intent ( questionsix.this, questionseven.class );
            String questionone = receiveIntent.getStringExtra ( "location1" );
            String questiontwo = receiveIntent.getStringExtra ( "age1" );
            String questionthree = receiveIntent.getStringExtra ( "gender1" );
            String questionfour = receiveIntent.getStringExtra ( "ethnic1" );
            String questionfive = receiveIntent.getStringExtra ( "subjects1" );
            String apikey1 = receiveIntent.getStringExtra ( "userapikey" );
            String email1 = receiveIntent.getStringExtra ( "email" );
            long questiononeanswer = receiveIntent.getLongExtra ( "q1pos", 0 );
            long questiontwoanswer = receiveIntent.getLongExtra ( "q2pos", 0 );
            long questionthreeanswer = receiveIntent.getLongExtra ( "q3pos", 0 );
            long questionfouranswer = receiveIntent.getLongExtra ( "q4pos", 0 );
            long questionfiveanswer = receiveIntent.getLongExtra ( "q5pos", 0 );
            long questionsixanswer = spinner6.getSelectedItemId ();
            Intent questionsix = receiveIntent.putExtra ( "hobbies1", hobbies1 );
            topage7.putExtra ( "location1", questionone );
            topage7.putExtra ( "age1", questiontwo );
            topage7.putExtra ( "gender1", questionthree );
            topage7.putExtra ( "ethnic1", questionfour );
            topage7.putExtra ( "subjects1", questionfive );
            topage7.putExtra ( "userapikey", apikey1 );
            topage7.putExtra ( "email", email1 );
            topage7.putExtra ( "hobbies1", hobbies1 );
            topage7.putExtra ( "q1pos", questiononeanswer );
            topage7.putExtra ( "q2pos", questiontwoanswer );
            topage7.putExtra ( "q3pos", questionthreeanswer );
            topage7.putExtra ( "q4pos", questionfouranswer );
            topage7.putExtra ( "q5pos", questionfiveanswer );
            topage7.putExtra ( "q6pos", questionsixanswer );

            startActivity ( topage7 );

            Toast.makeText ( getApplicationContext (), "You selected " + hobbies1, Toast.LENGTH_SHORT ).show ();
            System.out.println
                    ( questionone + " " + questiontwo + " " + questionthree + " "
                            + questionfour + " " + " " + "" + questionfive + " " + hobbies1 );
            System.out.println ( "Question 1 answer :" + " " + questiononeanswer );
            System.out.println ( "Question 2 answer :" + " " + questiontwoanswer );
            System.out.println ( "Question 3 answer :" + " " + questionthreeanswer );
            System.out.println ( "Question 4 answer :" + " " + questionfouranswer );
            System.out.println ( "Question 5 answer :" + " " + questionfiveanswer );
            System.out.println ( "Question 6 answer :" + " " + questionsixanswer );

        } );

    }


}
