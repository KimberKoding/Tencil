package uk.co.tencil.Businesses.FeaturedBusiness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;
import uk.co.tencil.User.UserDashboard;

public class featuresolopage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.featuredsolopage );

    }

    public void contact(@NonNull View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse
                (getIntent ().getStringExtra ( "contact" )));
        startActivity ( browserIntent );


    }

    public void socialmedia(@Nullable View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse
                (getIntent ().getStringExtra ( "website_social" ) ) );
        startActivity ( browserIntent );

    }

    public void backtoUser(@Nullable View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        this.startActivity ( intent );
    }

    public void careers(@Nullable View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse
                (getIntent ().getStringExtra ( "careers" ) ) );
        startActivity ( browserIntent );

    }

    public void websitetest(@Nullable View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse
                (getIntent ().getStringExtra ( "website" ) ) );
        startActivity ( browserIntent );

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        finish();
    }


    public void backtoDashsolo(@Nullable View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        finish();
    }
}
