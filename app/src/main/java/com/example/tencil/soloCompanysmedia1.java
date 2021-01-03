package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

import static com.example.tencil.R.layout.activity_solo_company_socialmedia1;

public class soloCompanysmedia1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( activity_solo_company_socialmedia1 );
    }

    public void backDashsolo(View v) {
        soloCompanysmedia1.this.startActivity ( new Intent ( soloCompanysmedia1.this, UserDashboard.class ) );


    }
}