package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionsix extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questionsix );
        Button btn6 = findViewById ( R.id.btn6 );

        btn6.setOnClickListener ( this );
    }


    @Override
    public void onClick(View v) {
        questionsix.this.startActivity ( new Intent ( questionsix.this, questionseven.class ) );
    }
}
