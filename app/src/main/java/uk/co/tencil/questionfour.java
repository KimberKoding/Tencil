package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionfour extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionfour );
        Button btn4 = findViewById ( R.id.btn4 );

        btn4.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionfour.this.startActivity ( new Intent ( questionfour.this, questionfive.class ) );
    }
}
