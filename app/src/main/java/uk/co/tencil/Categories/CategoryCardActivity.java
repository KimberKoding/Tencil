package uk.co.tencil.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.tencil.API.UserService;
import uk.co.tencil.Businesses.Businesses;
import uk.co.tencil.Businesses.GetAllBusinessesByCidAdapter;
import uk.co.tencil.Businesses.GetAllBusinessesByCidResponse;
import uk.co.tencil.R;
import uk.co.tencil.User.UserDashboard;

public class CategoryCardActivity extends AppCompatActivity {
    TextView category;
    List<Businesses> businessesList;
    RecyclerView newRecycler;
    ImageView business_logo;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.all_categories_card );
        businessesList = new ArrayList<> ();
        business_logo = findViewById ( R.id.business_logocard );
        newRecycler = findViewById ( R.id.neww_recycler );
        category = findViewById ( R.id.selectedcategory );
        category.setText ( getIntent ().getStringExtra ( "category" ) );


        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://tencil-infra.co.uk/api/v1/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        UserService userService = retrofit.create ( UserService.class );
        Call<GetAllBusinessesByCidResponse> call = userService.getAllBusinessesByCID ( getCid() );
        call.enqueue ( new Callback<GetAllBusinessesByCidResponse> () {

            @Override
            public void onResponse(@NotNull Call<GetAllBusinessesByCidResponse> call,
                                   @NotNull Response<GetAllBusinessesByCidResponse> response) {
                System.out.println ( response );
                GetAllBusinessesByCidResponse getAllBusinessesByCidResponse = response.body ();
                assert getAllBusinessesByCidResponse != null;
                businessesList = new ArrayList<>
                        (Arrays.asList (Objects.requireNonNull
                                (getAllBusinessesByCidResponse.getAllBusinessesByCid())) );
                System.out.println ( "This is the new response!!!!" );
                PutDataHere ( businessesList );
            }

            @Override
            public void onFailure(
                    @NotNull Call<GetAllBusinessesByCidResponse> call, @NotNull Throwable t) {
                System.out.println ( "Error" );
            }

        } );
    }

    void PutDataHere(List<Businesses> businessesList) {
        GetAllBusinessesByCidAdapter getAllBusinessesByCidAdapter = new
                GetAllBusinessesByCidAdapter ( this, businessesList );
        newRecycler.setLayoutManager ( new LinearLayoutManager
                (this, LinearLayoutManager.VERTICAL, false ) );
        newRecycler.setAdapter ( getAllBusinessesByCidAdapter );

    }


    public void backClicked(@Nullable View view) {
        Intent intent = new Intent ( this, UserDashboard.class );
        startActivity ( intent );
        finish ();
    }
}