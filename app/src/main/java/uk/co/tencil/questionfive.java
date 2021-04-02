package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionfive extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionfive );
        Button btn5 = findViewById ( R.id.btn5 );

        btn5.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionfive.this.startActivity ( new Intent ( questionfive.this, questionsix.class ) );
    }
}
