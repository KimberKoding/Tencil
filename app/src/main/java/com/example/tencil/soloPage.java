package com.example.tencil;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class soloPage extends AppCompatActivity {
    static int bname;
    TextView businessname;
    TextView businessnamesolo;
    List<Solocompany> businesses;
    RecyclerView soloRecycler;

    public int getBname() {
        System.out.println ( "getCid() method was called! CID is: " + bname );
        return bname;
    }

    public void setBname(int bname) {
        soloPage.bname = bname;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.company_solo_page );

        //HOOKS
        businesses = new ArrayList<> ();
        businessname = findViewById ( R.id.soloname );
        businessnamesolo = findViewById ( R.id.solo_namesolo );
        businessname.setText ( "Test" );
        businessnamesolo.setText ( "Test" );
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        UserService userService = retrofit.create ( UserService.class );
        Call<SolocompanyResponse> call = userService.getSolo ( getBname () );
        call.enqueue ( new Callback<SolocompanyResponse> () {
            @Override
            public void onResponse(Call<SolocompanyResponse> call, Response<SolocompanyResponse>
                    response) {
                System.out.println ( response );
                SolocompanyResponse solocompanyResponse = response.body ();
                businesses = new ArrayList<> ( Arrays.asList ( solocompanyResponse.getsolo () ) );
                PutDataHere ( businesses );
            }

            @Override
            public void onFailure(Call<SolocompanyResponse> call, Throwable t) {
                System.out.println ( t );
            }
        } );


    }

    private void PutDataHere(List<Solocompany> businesses) {
        SoloAdapter soloAdapter = new SoloAdapter ( this, businesses );
        soloRecycler.setHasFixedSize ( true );
        soloRecycler.setLayoutManager ( new LinearLayoutManager ( soloPage.this,
                LinearLayoutManager.VERTICAL, false ) );
        soloRecycler.setAdapter ( soloAdapter );


    }
}
