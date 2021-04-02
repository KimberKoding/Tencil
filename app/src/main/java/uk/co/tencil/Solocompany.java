package uk.co.tencil;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
        business_name.setText ( getIntent ().getStringExtra ( "bus_name" ) );
        bdesc.setText ( getIntent ().getStringExtra ( "bdesc" ) );
        Glide.with ( this )
                .load ( getIntent ().getStringExtra ( "Image_URL" ) )
                .into ( business_logo );
    }

    public void websitefull(View view) {
    }


    public void contact(View view) {
        Intent intent = new Intent ();
        intent.setAction ( Intent.ACTION_VIEW );
        intent.addCategory ( Intent.CATEGORY_BROWSABLE );
        intent.setData ( Uri.parse ( "https://www.tencil.co.uk/partnership/" ) );
        startActivity ( intent );
        Toast.makeText ( this, "Going to website", Toast.LENGTH_SHORT ).show ();
    }

    public void socialmedia(View view) {
    }


    public void backtoUser(View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        this.startActivity ( intent );
    }
}





