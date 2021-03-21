package com.example.tencil;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Solocompany extends AppCompatActivity {
    List<Businesses> businessesList;
    TextView business_name;
    TextView bdesc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.company_solo_page );
        businessesList = new ArrayList<> ();
        business_name = findViewById ( R.id.bus_name );
        bdesc = findViewById ( R.id.bdesc );
        business_name.setText ( getIntent ().getStringExtra ( "bus_name" ) );
        bdesc.setText ( getIntent ().getStringExtra ( "bdesc" ) );
        System.out.println ( "SUCCESS" );
        Toast.makeText ( this, "Success", Toast.LENGTH_SHORT ).show ();


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
}





