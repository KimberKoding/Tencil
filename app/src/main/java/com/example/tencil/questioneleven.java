package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questioneleven extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questioneleven );
        Button btn11 = findViewById ( R.id.btn11 );

        btn11.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questioneleven.this.startActivity ( new Intent ( questioneleven.this, questiontwelve.class ) );
    }
}
