package uk.co.tencil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.User.UserDashboard;

public class solocompany_monzo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.solocompany_monzo );


    }


    public void backDashsolo(View v) {
        solocompany_monzo.this.startActivity ( new Intent ( solocompany_monzo.this,
                UserDashboard.class ) );


    }

    public void websitetest(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.monzo.com/" ) );
        startActivity ( browserIntent );

    }

    public void socialmedia(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.facebook.com/monzobank" ) );
        startActivity ( browserIntent );

    }

    public void careers(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://monzo.com/careers/" ) );
        startActivity ( browserIntent );

    }

    public void contact(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://monzo.com/contact/" ) );
        startActivity ( browserIntent );

    }

    public void newsheadline(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.google.com/search?q=monzo+news&rlz=1C1CHBF_en-GB&oq=monzo+news&aqs=chrome..69i57j0l4j0i22i30l5.3785j0j7&sourceid=chrome&ie=UTF-8" ) );

        startActivity ( browserIntent );
    }
}
