package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

public class socialMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_social_media );
    }

    public void seemore1(View view) {
        socialMedia.this.startActivity ( new Intent ( socialMedia.this, soloCompanysmedia1.class ) );
    }

    public void ryanNav(View v) {
        socialMedia.this.startActivity ( new Intent ( socialMedia.this, UserDashboard.class ) );


    }

}