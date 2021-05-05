package uk.co.tencil.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;

public class questionten extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionten );
        Button btn10 = findViewById ( R.id.btn10 );

        btn10.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionten.this.startActivity ( new Intent ( questionten.this, questioneleven.class ) );
    }
}
