package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionseven extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionseven );
        Button btn7 = findViewById ( R.id.btn7 );

        btn7.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionseven.this.startActivity ( new Intent ( questionseven.this, questioneight.class ) );
    }
}
