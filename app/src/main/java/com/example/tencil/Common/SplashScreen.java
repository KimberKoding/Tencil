package com.example.tencil.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.MakeSelection;
import com.example.tencil.R;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIMER = 5000;

    //Variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Animations
    Animation sideAnim, bottomAnim;

    //Shared Prefernces
    SharedPreferences onBoardingScreen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.splash_screen );

        //Hooks
        backgroundImage = findViewById ( R.id.background_image );
        poweredByLine = findViewById ( R.id.powered_by_line );

        //Animations
        sideAnim = AnimationUtils.loadAnimation ( this, R.anim.side_anim );
        bottomAnim = AnimationUtils.loadAnimation ( this, R.anim.bottom_anim );

        //set Animations
        backgroundImage.setAnimation ( sideAnim );
        backgroundImage.setAnimation ( bottomAnim );

        new Handler ( Looper.getMainLooper () ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences ( "onBoardingScreen", MODE_PRIVATE );
                boolean isFirstTime = onBoardingScreen.getBoolean ( "firstTime", true );

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit ();
                    editor.putBoolean ( "firstTime", false );
                    editor.commit ();
                    Intent intent = new Intent ( getApplicationContext (), MakeSelection.class );
                    startActivity ( intent );
                    finish ();

                } else {
                    Intent intent = new Intent ( getApplicationContext (), MakeSelection.class );
                    startActivity ( intent );
                    finish ();
                }


            }
        }, SPLASH_TIMER );


    }


}