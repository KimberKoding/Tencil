package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

public class login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        Button btn_login = findViewById ( R.id.btn_login );
        btn_login.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        login.this.startActivity ( new Intent ( login.this, UserDashboard.class ) );
    }

    public void register(View view) {
        startActivity ( new Intent ( getApplicationContext (), register.class ) );
        finish ();
    }
}
