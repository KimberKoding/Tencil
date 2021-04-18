package uk.co.tencil.User;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;

public class solocompany_moneyfarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.solocompany_moneyfarm );


    }


    public void backDashsolo(View v) {
        solocompany_moneyfarm.this.startActivity ( new Intent ( solocompany_moneyfarm.this,
                UserDashboard.class ) );


    }

    public void websitetest(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.moneyfarm.com/" ) );
        startActivity ( browserIntent );

    }

    public void socialmedia(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.facebook.com/moneyfarm" ) );
        startActivity ( browserIntent );

    }

    public void careers(View view) {
        Toast.makeText ( this, "This business does not have a careers section", Toast.LENGTH_SHORT ).show ();

    }

    public void contact(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.moneyfarm.com/uk/help/#contacts" ) );
        startActivity ( browserIntent );

    }

    public void newsheadline(View view) {

        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://blog.moneyfarm.com/en/" ) );
        startActivity ( browserIntent );

    }

}
