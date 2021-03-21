package com.example.tencil;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FeaturedSolocompany extends AppCompatActivity {
    List<Businesses> businessesList;
    TextView business_name;
    TextView bdesc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.featuredsolopage );
        businessesList = new ArrayList<> ();
        business_name = findViewById ( R.id.feat_name );
        bdesc = findViewById ( R.id.feat_bdesc );
        business_name.setText ( getIntent ().getStringExtra ( "feat_name" ) );
        bdesc.setText ( getIntent ().getStringExtra ( "feat_bdesc" ) );
        System.out.println ( "SUCCESS" );
        Toast.makeText ( this, "Success", Toast.LENGTH_SHORT ).show ();


    }

}



