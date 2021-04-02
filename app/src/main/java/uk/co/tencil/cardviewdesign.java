package uk.co.tencil;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cardviewdesign extends AppCompatActivity {
    static float END_SCALE = 0.7f;
    List<Categories> categoriesList;
    RecyclerView categoriesRecycler;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.cardview_design );
        categoriesRecycler = findViewById ( R.id.categories_recycler );
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );
        categoriesList = new ArrayList<> ();

        //RETROFIT

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        UserService userService = retrofit.create ( UserService.class );
        Call<JSONResponse> call = userService.getCategories ();

        call.enqueue ( new Callback<JSONResponse> () {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body ();
                categoriesList = new ArrayList<> ( Arrays.asList ( jsonResponse.getCategories () ) );

                PutDataIntoRecyclerView ( categoriesList );


            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                System.out.println ( t );

            }
        } );

    }

    private void PutDataIntoRecyclerView(List<Categories> categoriesList) {
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter ( this, categoriesList );
        categoriesRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false ) );
        categoriesRecycler.setAdapter ( categoriesAdapter );

    }

    // Navigation Drawer functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront ();
        navigationView.setNavigationItemSelectedListener ( (NavigationView.OnNavigationItemSelectedListener) this );
        navigationView.setCheckedItem ( R.id.nav_home );

        menuIcon.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible ( GravityCompat.START ))
                    drawerLayout.closeDrawer ( GravityCompat.START );
                else drawerLayout.openDrawer ( GravityCompat.START );
            }
        } );
        animateNavigationDrawer ();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor ( getResources ().getColor ( R.color.colorPrimary ) );
        drawerLayout.addDrawerListener ( new DrawerLayout.SimpleDrawerListener () {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX ( offsetScale );
                contentView.setScaleY ( offsetScale );

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth () * slideOffset;
                final float xOffsetDiff = contentView.getWidth () * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX ( xTranslation );
            }
        } );
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible ( GravityCompat.START )) {
            drawerLayout.closeDrawer ( GravityCompat.START );
        }

    }

}

