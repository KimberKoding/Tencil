package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class CategoryCardActivity extends AppCompatActivity {
    TextView category;
    List<Businesses> businessesList;
    RecyclerView newRecycler;
    static int cid;

    public int getCid() {
        System.out.println("getCid() method was called! CID is: " + cid);
        return cid;
    }

    public void setCid(int cid) {
        CategoryCardActivity.cid = cid;
        System.out.println("setCid() method was called! CID is now: " + CategoryCardActivity.cid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.all_categories_card );
        businessesList = new ArrayList<> ();
        newRecycler = findViewById ( R.id.new_recycler );
        category = findViewById ( R.id.selectedcategory );
        category.setText ( getIntent ().getStringExtra ( "category" ) );

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        UserService userService = retrofit.create ( UserService.class );
        Call<GetAllBusinessesByCidResponse> call = userService.getAllBusinessesByCID ( getCid() );
        call.enqueue ( new Callback<GetAllBusinessesByCidResponse> () {

            @Override
            public void onResponse(Call<com.example.tencil.GetAllBusinessesByCidResponse> call,
                                   Response<com.example.tencil.GetAllBusinessesByCidResponse> response) {
                System.out.println ( response );
                GetAllBusinessesByCidResponse getAllBusinessesByCidResponse = response.body ();
                businessesList = new ArrayList<> ( Arrays.asList (
                        getAllBusinessesByCidResponse.getAllBusinessesByCid () ) );
                PutDataIntoHere ( businessesList );

            }

            @Override
            public void onFailure(Call<com.example.tencil.GetAllBusinessesByCidResponse> call,
                                  Throwable t) {
                System.out.println ( t );
            }
        } );
    }

    void PutDataIntoHere(List<Businesses> businessesList) {
        GetAllBusinessesByCidAdapter getAllBusinessesByCidAdapter = new GetAllBusinessesByCidAdapter
                ( this, businessesList );
        newRecycler.setHasFixedSize ( true );
        newRecycler.setLayoutManager ( new LinearLayoutManager ( CategoryCardActivity.this, LinearLayoutManager.VERTICAL,
                false ) );
        newRecycler.setAdapter ( getAllBusinessesByCidAdapter );
    }


    public void seesolo(View view) {
        Intent intent = new Intent ( this, Solocompany.class );
        System.out.println ( "Success" );
        startActivity ( intent );
    }
}