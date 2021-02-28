package com.example.tencil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Solocompany extends AppCompatActivity {

    RecyclerView soloRecycler;
    List<Businesses> businessesList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        setContentView ( R.layout.company_solo_page );
        //RETROFIT

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
                solocompanyResponse.getsolo ();

            }

            @Override
            public void onFailure(Call<SolocompanyResponse> call, Throwable t) {
                System.out.println ( t + "Error :(" );
            }
        } );
    }

    private void PutDataIntoThisView(List<Businesses> businessesList) {
        SoloAdapter soloAdapter = new SoloAdapter ( this, businessesList );
        soloRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false ) );
        soloRecycler.setAdapter ( soloAdapter );

    }
}
