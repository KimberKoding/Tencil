package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questiontwelve extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questiontwelve );
        Button btn12 = findViewById ( R.id.btn12 );

        btn12.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questiontwelve.this.startActivity ( new Intent ( questiontwelve.this, questionthirteen.class ) );
    }
}
