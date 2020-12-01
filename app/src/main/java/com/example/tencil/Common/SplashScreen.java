package com.example.tencil.Common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.R;
import com.example.tencil.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIMER = 5000;

    //Variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Animations
    Animation sideAnim, bottomAnim;

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
                Intent intent = new Intent ( getApplicationContext (), UserDashboard.class );
                startActivity ( intent );
            }
        }, SPLASH_TIMER );


    }


}