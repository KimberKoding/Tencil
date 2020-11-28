package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


abstract class openDash extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dashboard );
        Button button = (Button) findViewById ( R.id.button );
        button.setOnClickListener ( v -> openIndustry () );


    }

    public void openIndustry() {
        Intent intent = new Intent ( this, industry.class );
        startActivity ( intent );
    }


}

