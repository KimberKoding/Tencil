package com.example.tencil;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Solocompany extends AppCompatActivity {
    List<Categories> categoriesList;
    List<Businesses> businessesList;
    TextView business_name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.company_solo_page );
        businessesList = new ArrayList<> ();
        business_name = findViewById ( R.id.bus_name );
        business_name.setText ( getIntent ().getStringExtra ( "bus_name" ) );
        System.out.println ( "SUCCESS" );
        Toast.makeText ( this, "Success", Toast.LENGTH_SHORT ).show ();


    }
}





