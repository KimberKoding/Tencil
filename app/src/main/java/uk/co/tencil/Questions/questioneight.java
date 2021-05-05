package uk.co.tencil.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;

public class questioneight extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questioneight );
        Button btn8 = findViewById ( R.id.btn8 );

        btn8.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questioneight.this.startActivity ( new Intent ( questioneight.this, questionnine.class ) );
    }
}
