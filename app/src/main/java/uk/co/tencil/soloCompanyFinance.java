package uk.co.tencil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.User.UserDashboard;

public class soloCompanyFinance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company_starling );


    }


    public void backDashsolo(View v) {
        soloCompanyFinance.this.startActivity ( new Intent ( soloCompanyFinance.this,
                UserDashboard.class ) );


    }

    public void websitetest(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.starlingbank.com/" ) );
        startActivity ( browserIntent );


    }

    public void contact(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.starlingbank.com/contact/" ) );
        startActivity ( browserIntent );

    }

    public void socialmedia(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.facebook.com/StarlingBankUK" ) );
        startActivity ( browserIntent );

    }

    public void careers(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.starlingbank.com/careers/" ) );
        startActivity ( browserIntent );

    }

    public void newsheadline(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.starlingbank.com/media/" ) );
        startActivity ( browserIntent );
    }
}