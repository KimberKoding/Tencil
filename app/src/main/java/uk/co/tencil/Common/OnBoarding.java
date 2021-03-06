package uk.co.tencil.Common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import uk.co.tencil.HelperClasses.SliderAdapter;
import uk.co.tencil.R;
import uk.co.tencil.login;


public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsetStarted;
    Animation animation;
    int currentpos;
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener () {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots ( position );

            currentpos = position;

            if (position == 0) {
                letsetStarted.setVisibility ( View.INVISIBLE );
            } else if (position == 1) {
                letsetStarted.setVisibility ( View.INVISIBLE );
            } else if (position == 2) {
                letsetStarted.setVisibility ( View.INVISIBLE );
            } else {
                animation = AnimationUtils.loadAnimation ( OnBoarding.this, R.anim.bottom_anim );
                letsetStarted.setAnimation ( animation );
                letsetStarted.setVisibility ( View.VISIBLE );
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_on_boarding );
        letsetStarted = findViewById ( R.id.get_started_btn );
        //HOOKS
        viewPager = findViewById ( R.id.slider );
        dotsLayout = findViewById ( R.id.dots );


        //CALL ADAPTER
        sliderAdapter = new SliderAdapter ( this );
        viewPager.setAdapter ( sliderAdapter );
        addDots ( 0 );
        viewPager.addOnPageChangeListener ( changeListener );


    }

    public void skip(View view) {
        startActivity ( new Intent ( getApplicationContext (), login.class ) );
        finish ();
    }

    public void getStarted(View view) {
        startActivity ( new Intent ( getApplicationContext (), login.class ) );
        finish ();
    }


    public void next(View view) {
        viewPager.setCurrentItem ( currentpos + 1 );
    }


    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews ();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView ( this );
            dots[i].setText ( Html.fromHtml ( "&#8226" ) );
            dots[i].setTextSize ( 35 );

            dotsLayout.addView ( dots[i] );
        }

        if (dots.length > 0) {
            dots[position].setTextColor ( getResources ().getColor ( R.color.colorPrimary ) );
        }

    }
}

