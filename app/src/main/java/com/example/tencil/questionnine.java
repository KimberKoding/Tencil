package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionnine extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionnine );
        Button btn9 = findViewById ( R.id.btn9 );

        btn9.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionnine.this.startActivity ( new Intent ( questionnine.this, questionten.class ) );
    }
}
