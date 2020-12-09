package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

public class questionthirteen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionthirteen );
        Button btn13 = findViewById ( R.id.btn13 );

        btn13.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionthirteen.this.startActivity ( new Intent ( questionthirteen.this, UserDashboard.class ) );
    }
}
