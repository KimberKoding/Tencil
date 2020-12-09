package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionone extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionone );
        Button btn1 = findViewById ( R.id.btn1 );

        btn1.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionone.this.startActivity ( new Intent ( questionone.this, questiontwo.class ) );
    }
}
