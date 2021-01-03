package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;


public class FeaturedBusiness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_featured_businesses );
    }

    public void featuredNav(View v) {
        FeaturedBusiness.this.startActivity ( new Intent ( FeaturedBusiness.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );
        finish ();

    }


    public void seemore1(View view) {
        FeaturedBusiness.this.startActivity ( new Intent ( FeaturedBusiness.this, solo_company.class ) );


    }
}