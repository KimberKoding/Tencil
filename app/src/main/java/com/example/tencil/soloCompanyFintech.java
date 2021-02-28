package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.User.UserDashboard;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class soloCompanyFintech extends AppCompatActivity {
    List<Businesses> businessesList;
    RecyclerView soloRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company_fintech );
        businessesList = new ArrayList<> ();
        soloRecycler = findViewById ( R.id.soloRecycler );

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        UserService userService = retrofit.create ( UserService.class );
        Call<SolocompanyResponse> call = userService.getSolo ();
        call.enqueue ( new Callback<SolocompanyResponse> () {
            @Override
            public void onResponse(Call<SolocompanyResponse> call, Response<SolocompanyResponse> response) {
                System.out.println ( response );
                SolocompanyResponse solocompanyResponse = response.body ();
                Toast.makeText ( soloCompanyFintech.this, "Response met", Toast.LENGTH_SHORT ).show ();
                PutDataHere ( businessesList );


            }

            @Override
            public void onFailure(Call<SolocompanyResponse> call, Throwable t) {
                System.out.println ( t );
                Toast.makeText ( soloCompanyFintech.this, "NOOOOO", Toast.LENGTH_SHORT ).show ();
            }
        } );

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
