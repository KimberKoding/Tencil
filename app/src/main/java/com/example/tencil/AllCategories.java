package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;


public class AllCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_all_categories );
    }

    public void ryanNav(View v) {
        AllCategories.this.startActivity ( new Intent ( AllCategories.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        AllCategories.this.startActivity ( new Intent ( AllCategories.this, solo_company.class ) );


    }


}

