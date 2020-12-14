package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;


public class AllCategories extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_all_categories );


    }


    public void backDash(View v) {
        AllCategories.this.startActivity ( new Intent ( AllCategories.this, UserDashboard.class ) );
        ImageView backpressed = findViewById ( R.id.back_pressed );


        backpressed.setOnClickListener ( (View.OnClickListener) this );

    }
}

