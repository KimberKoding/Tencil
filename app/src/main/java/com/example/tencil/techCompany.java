package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

import static com.example.tencil.R.layout.activity_tech_company;

public class techCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( activity_tech_company );
    }

    public void ryanNav(View v) {
        techCompany.this.startActivity ( new Intent ( techCompany.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        techCompany.this.startActivity ( new Intent ( techCompany.this, UserDashboard.class ) );
    }

    public void seemore2(View view) {
        techCompany.this.startActivity ( new Intent ( techCompany.this, UserDashboard.class ) );
    }

}

