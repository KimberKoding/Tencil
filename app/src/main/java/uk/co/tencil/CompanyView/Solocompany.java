package uk.co.tencil.CompanyView;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import uk.co.tencil.Businesses.Businesses;
import uk.co.tencil.R;
import uk.co.tencil.User.UserDashboard;


public class Solocompany extends AppCompatActivity {
    private static final String TAG = "SOLO company";
    ImageView business_logo;
    List<Businesses> businessesList;
    Button website, social, careers, contact;
    TextView business_name;
    TextView bdesc;
    VideoView videoView;
    CardView news;
    ImageView imageView;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.company_solo_page );
        businessesList = new ArrayList<> ();
        business_name = findViewById ( R.id.bus_name );
        business_logo = findViewById ( R.id.profile_image );
        bdesc = findViewById ( R.id.bdesc );
        website = findViewById ( R.id.website );
        social = findViewById ( R.id.socialmedia );
        careers = findViewById ( R.id.careers );
        contact = findViewById ( R.id.contact );
        videoView = findViewById ( R.id.videoview );
        news = findViewById ( R.id.news_card );
        imageView = findViewById ( R.id.imageView );

        business_name.setText ( getIntent ().getStringExtra ( "bus_name" ) );
        business_name.setFocusable ( true );
        bdesc.setText ( getIntent ().getStringExtra ( "bdesc" ) );
        Glide.with ( this )
                .load ( getIntent ().getStringExtra ( "Image_URL" ) )
                .into ( business_logo );
        contact.setOnClickListener ( this::contact );

        if (videoView == null) {
            Toast.makeText ( mContext, "This business does not have any videos", Toast.LENGTH_SHORT ).show ();
        } else {
            videoView.setVideoPath ( getIntent ().getStringExtra ( "videos" ) );
            videoView.setFocusableInTouchMode ( false );
            videoView.start ();
            MediaController mediaController = new MediaController ( this );
            videoView.setMediaController ( mediaController );
            mediaController.setAnchorView ( videoView );
        }

        news.setOnClickListener ( v -> {
            Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "news" ) ) );
            startActivity ( browserIntent );
        } );
        Glide.with ( this )
                .load ( getIntent ().getStringExtra ( "Image_URL" ) )
                .into ( imageView );
        contact.setOnClickListener ( this::contact );
        social.setOnClickListener ( this::socialmedia );
        careers.setOnClickListener ( this::careers );

    }


    public void contact(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "contact" ) ) );
        startActivity ( browserIntent );


    }

    public void socialmedia(View view) {
        Intent intent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "website_social" ) ) );
        startActivity ( intent );
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

    public void contacttencil(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://providencewebservices.co.uk/contact" ) );
        startActivity ( browserIntent );

    }

}






