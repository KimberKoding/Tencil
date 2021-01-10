package com.example.tencil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

public class soloCompanyFintech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company_fintech );
    }

    public void backDashsolo(View v) {
        soloCompanyFintech.this.startActivity ( new Intent ( soloCompanyFintech.this, UserDashboard.class ) );


    }

    public void website(View view) {
        Intent myWebLink = new Intent ( android.content.Intent.ACTION_VIEW );
        myWebLink.setData ( Uri.parse ( "https://www.moneyfarm.com/uk/" ) );
        startActivity ( myWebLink );
    }
}
