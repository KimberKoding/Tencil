package uk.co.tencil;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import uk.co.tencil.User.UserDashboard;


public class Solocompany extends AppCompatActivity {
    private static final String TAG = "SOLO company";
    ImageView business_logo;
    List<Businesses> businessesList;
    Button website, social, careers, contact;
    TextView business_name;
    TextView bdesc;
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
        business_name.setText ( getIntent ().getStringExtra ( "bus_name" ) );
        bdesc.setText ( getIntent ().getStringExtra ( "bdesc" ) );
        Glide.with ( this )
                .load ( getIntent ().getStringExtra ( "Image_URL" ) )
                .into ( business_logo );
        contact.setOnClickListener ( this::contact );


    }

    public void contact(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "contact" ) ) );
        startActivity ( browserIntent );


    }

    public void socialmedia(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "website_social" ) ) );
        startActivity ( browserIntent );
        Toast.makeText ( mContext, "Going to Social Media", Toast.LENGTH_SHORT ).show ();
    }

    public void backtoUser(View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        this.startActivity ( intent );
    }

    public void careers(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( getIntent ().getStringExtra ( "careers" ) ) );
        startActivity ( browserIntent );
        Toast.makeText ( mContext, "Going to Website", Toast.LENGTH_SHORT ).show ();
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





