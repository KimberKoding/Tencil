package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.User.UserDashboard;



public class soloCompanysmedia1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company_socialmedia1 );
    }

    public void backDashsolo(View v) {
        soloCompanysmedia1.this.startActivity ( new Intent ( soloCompanysmedia1.this, UserDashboard.class ) );


    }
}