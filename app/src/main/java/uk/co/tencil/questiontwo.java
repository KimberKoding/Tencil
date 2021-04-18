package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questiontwo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questiontwo );
        Button btn1 = findViewById ( R.id.btn2 );

        btn1.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questiontwo.this.startActivity ( new Intent ( questiontwo.this, questionthree.class ) );
    }
}
