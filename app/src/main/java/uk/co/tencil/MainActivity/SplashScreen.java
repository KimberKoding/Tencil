package uk.co.tencil.MainActivity;

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

import uk.co.tencil.R;
import uk.co.tencil.User.Login.login;

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

        System.out.println ( "WE HAVE ANIMS" );

        new Handler ( Looper.getMainLooper () ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences ( "onBoardingScreen", MODE_PRIVATE );
                Intent intent = new Intent ( getApplicationContext (), login.class );
                startActivity ( intent );
                finish ();

            }

        }, SPLASH_TIMER );


    }


}