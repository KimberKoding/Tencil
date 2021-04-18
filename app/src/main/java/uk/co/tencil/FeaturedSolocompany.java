package uk.co.tencil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import uk.co.tencil.User.UserDashboard;

public class FeaturedSolocompany extends AppCompatActivity {
    List<Businesses> businessesList;
    TextView business_name;
    TextView bdesc;
    ImageView business_img;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.featuredsolopage );
        businessesList = new ArrayList<> ();
        business_name = findViewById ( R.id.feat_name );
        bdesc = findViewById ( R.id.feat_bdesc );
        business_img = findViewById ( R.id.profile_image );
        business_name.setText ( getIntent ().getStringExtra ( "feat_name" ) );
        bdesc.setText ( getIntent ().getStringExtra ( "feat_bdesc" ) );
        business_img.setImageResource ( R.drawable.analysis );
        Glide.with ( this ).load ( getIntent ().getStringExtra ( "feat_image" ) ).into ( business_img );


    }

    public void contact(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "contact" ) ) );
        startActivity ( browserIntent );


    }

    public void socialmedia(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "website_social" ) ) );
        startActivity ( browserIntent );
    }

    public void backtoUser(View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        this.startActivity ( intent );
    }

    public void careers(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "careers" ) ) );
        startActivity ( browserIntent );

    }

    public void websitetest(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "website" ) ) );
        startActivity ( browserIntent );

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        return;
    }

    public void backtoDashsolo(View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        return;
    }
}



