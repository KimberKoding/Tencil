package uk.co.tencil.Businesses.FeaturedBusiness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
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

public class FeaturedSolocompany extends AppCompatActivity {
    List<Businesses> businessesList;
    TextView business_name;
    TextView bdesc;
    Button website, social, careers, contact;
    ImageView business_img;
    VideoView videoView;
    CardView news;
    ImageView imageView;


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
        website = findViewById ( R.id.website );
        social = findViewById ( R.id.socialmedia );
        careers = findViewById ( R.id.careers );
        contact = findViewById ( R.id.contact );
        videoView = findViewById ( R.id.videoview );
        news = findViewById ( R.id.news_card );
        imageView = findViewById ( R.id.imageView );

        careers.setOnClickListener ( this::careers );

        videoView.setVideoPath ( getIntent ().getStringExtra ( "videos" ) );
        videoView.start ();
        MediaController mediaController = new MediaController ( this );
        videoView.setMediaController ( mediaController );
        mediaController.setAnchorView ( videoView );


        news.setOnClickListener ( v -> {
            Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "news" ) ) );
            startActivity ( browserIntent );
        } );

        Glide.with ( this )
                .load ( getIntent ().getStringExtra ( "feat_image" ) )
                .into ( imageView );
        contact.setOnClickListener ( this::contact );
        System.out.println ( "This is a test for Git" );


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

    public void backtoDashsolo(View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        return;
    }
}



