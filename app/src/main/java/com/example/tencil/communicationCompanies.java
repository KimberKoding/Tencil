package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

public class communicationCompanies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_communication_companies );
    }

    public void ryanNav(View v) {
        communicationCompanies.this.startActivity ( new Intent ( communicationCompanies.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        communicationCompanies.this.startActivity ( new Intent ( communicationCompanies.this, solo_company.class ) );


    }

}