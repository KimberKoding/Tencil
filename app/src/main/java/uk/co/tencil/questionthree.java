package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionthree extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionthree );
        Button btn3 = findViewById ( R.id.btn3 );

        btn3.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionthree.this.startActivity ( new Intent ( questionthree.this, questionfour.class ) );
    }
}
