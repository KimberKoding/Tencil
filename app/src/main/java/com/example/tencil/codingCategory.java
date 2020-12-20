package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;


public class codingCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_coding_category );
    }

    public void ryanNav(View v) {
        codingCategory.this.startActivity ( new Intent ( codingCategory.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        codingCategory.this.startActivity ( new Intent ( codingCategory.this, solo_company.class ) );


    }


}

