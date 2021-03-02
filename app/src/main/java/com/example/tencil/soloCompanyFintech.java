package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.User.UserDashboard;

import java.util.ArrayList;
import java.util.List;

public class soloCompanyFintech extends AppCompatActivity {
    List<Businesses> businessesList;
    RecyclerView soloRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.company_solo_page );
        businessesList = new ArrayList<> ();



    }


    private void PutDataHere(List<Businesses> businessesList) {
        BusinessesAdapter businessesAdapter = new BusinessesAdapter ( this, businessesList );
        soloRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false ) );
        soloRecycler.setAdapter ( businessesAdapter );

    }

    public void backDashsolo(View v) {
        soloCompanyFintech.this.startActivity ( new Intent ( soloCompanyFintech.this, UserDashboard.class ) );


    }


    public void website(View view) {
    }
}
