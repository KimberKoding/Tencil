package uk.co.tencil.Legal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;
import uk.co.tencil.User.UserDashboard;

public class privacy_policy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_privacy_policy );
    }

    public void privacypolicybutton(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://tencil.co.uk/privacy-policy" ) );
        startActivity ( browserIntent );
        Toast.makeText ( this, "Taking you to privacy policy", Toast.LENGTH_SHORT ).show ();

    }


    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( getApplicationContext (), UserDashboard.class ) );
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        finish ();
    }


}