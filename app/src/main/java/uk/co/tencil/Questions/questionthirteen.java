package uk.co.tencil.Questions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.tencil.API.APiClient;
import uk.co.tencil.Categories.Categories;
import uk.co.tencil.R;

public class questionthirteen extends AppCompatActivity {
    Context mContext;
    List<Categories> categoriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionthirteen );
        List<String> career =
                Arrays.asList (
                        "coding",
                        "edtech",
                        "communication companies",
                        "consultancy",
                        "fintech",
                        "other",
                        "Marketing",
                        "Property",
                        "Utilities",
                        "Health & Care",
                        "Food",
                        "Law",
                        "Sport",
                        "Education",
                        "Finance",
                        "Fashion",
                        "Travel",
                        "Gaming",
                        "Music"

                );
        Spinner spinner14 = findViewById ( R.id.spinner15 );
        ArrayAdapter adapter = new ArrayAdapter ( getApplicationContext (),
                android.R.layout.simple_spinner_item, career );
        Intent receiveIntent = getIntent ();

        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner14.setAdapter ( adapter );
        Button btn12 = findViewById ( R.id.btn13 );
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
        String questiontwelve = receiveIntent.getStringExtra ( "school1" );
        String email = receiveIntent.getStringExtra ( "email" );
        String userid = receiveIntent.getStringExtra ( "email" );
        String qid = receiveIntent.getStringExtra ( "qid" );

        long questiononeanswer = receiveIntent.getLongExtra ( "q1pos", 0 );
        long questiontwoanswer = receiveIntent.getLongExtra ( "q2pos", 0 );
        long questionthreeanswer = receiveIntent.getLongExtra ( "q3pos", 0 );
        long questionfouranswer = receiveIntent.getLongExtra ( "q4pos", 0 );
        long questionfiveanswer = receiveIntent.getLongExtra ( "q5pos", 0 );
        long questionsixanswer = receiveIntent.getLongExtra ( "q6pos", 0 );
        long questionsevenanswer = receiveIntent.getLongExtra ( "q7pos", 0 );
        long questioneightanswer = receiveIntent.getLongExtra ( "q8pos", 0 );
        long questionnineanswer = receiveIntent.getLongExtra ( "q9pos", 0 );
        long questiontenanswer = receiveIntent.getLongExtra ( "q10pos", 0 );
        long questionelevenanswer = receiveIntent.getLongExtra ( "q11pos", 0 );
        long questiontwelveanswer = receiveIntent.getLongExtra ( "q12pos", 0 );
        long questionthirteenanswer = spinner14.getSelectedItemId ();

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
        System.out.println ( "Question 13 answer :" + " " + questionthirteenanswer );
        btn12.setOnClickListener ( v -> {
            String careers1 = spinner14.getSelectedItem ().toString ();

            QuestionsResponse questionsResponse = new QuestionsResponse ();
            questionsResponse.setUserid ( userid );
            questionsResponse.setQid ( qid );
            questionsResponse.setQ1 ( questiononeanswer );
            questionsResponse.setQ2 ( questiontwoanswer );
            questionsResponse.setQ3 ( questionthreeanswer );
            questionsResponse.setQ4 ( questionfouranswer );
            questionsResponse.setQ5 ( questionfiveanswer );
            questionsResponse.setQ6 ( questionsixanswer );
            questionsResponse.setQ7 ( questionsevenanswer );
            questionsResponse.setQ8 ( questioneightanswer );
            questionsResponse.setQ9 ( questionnineanswer );
            questionsResponse.setQ10 ( questiontenanswer );
            questionsResponse.setQ11 ( questionelevenanswer );
            questionsResponse.setQ12 ( questiontwelveanswer );
            questionsResponse.setQ13 ( questionthirteenanswer );
            questionsResponse ( questionsResponse );

        } );


    }

    private void questionsResponse(QuestionsResponse questionsResponse) {
        Intent receiveIntent = getIntent ();
        Call<QuestionsResponse> questionsResponseCall =
                APiClient.getUserService ().questions ( receiveIntent.getStringExtra ( "userapikey" ),
                        questionsResponse );
        questionsResponseCall.enqueue ( new Callback<QuestionsResponse> () {
            @Override
            public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                if (response.isSuccessful ()) {

                    QuestionsResponse questionsResponse1 = response.body ();
                    String userid = questionsResponse1.getUserid ();
                    String Qid = questionsResponse1.getQid ();
                    long Q1 = questionsResponse1.getQ1 ();
                    long Q2 = questionsResponse1.getQ2 ();
                    long Q3 = questionsResponse1.getQ3 ();
                    long Q4 = questionsResponse1.getQ4 ();
                    long Q5 = questionsResponse1.getQ5 ();
                    long Q6 = questionsResponse1.getQ6 ();
                    long Q7 = questionsResponse1.getQ7 ();
                    long Q8 = questionsResponse1.getQ8 ();
                    long Q9 = questionsResponse1.getQ9 ();
                    long Q10 = questionsResponse1.getQ10 ();
                    long Q11 = questionsResponse1.getQ11 ();
                    long Q12 = questionsResponse1.getQ12 ();
                    long Q13 = questionsResponse1.getQ13 ();
                    Toast.makeText ( questionthirteen.this, "The response was successful", Toast.LENGTH_SHORT ).show ();
                    System.out.println ( response );
                } else {
                    System.out.println ( response + " Error" );
                }
            }

            @Override
            public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                System.out.println ( t + " Error" );
                Toast.makeText ( mContext, "Error" + "" + "" + t, Toast.LENGTH_SHORT ).show ();

            }
        } );

    }


}
