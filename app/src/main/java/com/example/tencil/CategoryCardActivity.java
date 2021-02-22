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

public class CategoryCardActivity extends AppCompatActivity {
    TextView category;
    List<Businesses> businessesList;
    RecyclerView newRecycler;


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
        Call<GetAllBusinessesByCidResponse> call = userService.getAllBusinessesByCID ( 1 );
        call.enqueue ( new Callback<GetAllBusinessesByCidResponse> () {
            @Override
            public void onResponse(Call<com.example.tencil.GetAllBusinessesByCidResponse> call, Response<com.example.tencil.GetAllBusinessesByCidResponse> response) {
                System.out.println ( response );
                GetAllBusinessesByCidResponse getAllBusinessesByCidResponse = response.body ();
                businessesList = new ArrayList<> ( Arrays.asList ( getAllBusinessesByCidResponse.getAllBusinessesByCid () ) );
                System.out.println ();
                PutDataIntoHere ( businessesList );

            }

            @Override
            public void onFailure(Call<com.example.tencil.GetAllBusinessesByCidResponse> call, Throwable t) {
                System.out.println ( t );
            }


        } );


    }

    private void PutDataIntoHere(List<Businesses> businessesList) {

        GetAllBusinessesByCidAdapter getAllBusinessesByCidAdapter = new GetAllBusinessesByCidAdapter ( this, businessesList );
        newRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false ) );
        newRecycler.setAdapter ( getAllBusinessesByCidAdapter );

    }

}
