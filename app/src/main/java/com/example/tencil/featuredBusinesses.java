package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

public class featuredBusinesses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_featured_businesses );
    }

    public void ryanNav(View v) {
        featuredBusinesses.this.startActivity ( new Intent ( featuredBusinesses.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        featuredBusinesses.this.startActivity ( new Intent ( featuredBusinesses.this, solo_company.class ) );


    }
}