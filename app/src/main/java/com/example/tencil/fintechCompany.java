package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.tencil.R.layout.activity_fintech_company;

public class fintechCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( activity_fintech_company );
    }

    public void ryanNav(View v) {
        fintechCompany.this.startActivity ( new Intent ( fintechCompany.this, soloCompanyFintech.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        fintechCompany.this.startActivity ( new Intent ( fintechCompany.this, soloCompanyFintech.class ) );
    }

    public void seemore2(View view) {
        fintechCompany.this.startActivity ( new Intent ( fintechCompany.this, soloCompanyFintech.class ) );
    }

}

