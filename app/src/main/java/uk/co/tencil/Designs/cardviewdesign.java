package uk.co.tencil.Designs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.tencil.API.UserService;
import uk.co.tencil.Businesses.Businesses;
import uk.co.tencil.Businesses.JSONResponse;
import uk.co.tencil.Categories.Categories;
import uk.co.tencil.Categories.CategoriesAdapter;
import uk.co.tencil.CompanyView.Solocompany;
import uk.co.tencil.R;
import uk.co.tencil.User.Login.login;
import uk.co.tencil.User.UserDashboard;

public class cardviewdesign extends AppCompatActivity {
    static float END_SCALE = 0.7f;
    List<Categories> categoriesList;
    List<Businesses> businessesList;
    RecyclerView categoriesRecycler;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;
    TextView welcomeuser;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.cardview_design );
        categoriesRecycler = findViewById ( R.id.categories_recycler );
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );
        categoriesList = new ArrayList<> ();
        welcomeuser.setText
                ( getString ( R.string.welcometotencil ) + "\n" +
                        getIntent ().getStringExtra ( "email" ) );


        //Menu Hooks
        drawerLayout = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.navigation_view );
        menuIcon = findViewById ( R.id.menu_icon );

        //RecyclerView Hooks
        contentView = findViewById ( R.id.content );
        navigationDrawer ();
        //RETROFIT

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        UserService userService = retrofit.create ( UserService.class );
        Call<JSONResponse> call = userService.getCategories ();

        call.enqueue ( new Callback<JSONResponse> () {
            @Override
            public void onResponse(@NotNull Call<JSONResponse> call,
                                   @NotNull Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body ();
                assert jsonResponse != null;
                categoriesList = new ArrayList<> ( Arrays.asList
                        ( jsonResponse.getCategories () ) );

                PutDataIntoRecyclerView ( categoriesList );


            }

            @Override
            public void onFailure(@NotNull Call<JSONResponse> call, @NotNull Throwable t) {
                System.out.println ( t );

            }
        } );

    }

    void PutDataIntoRecyclerView(List<Categories> categoriesList) {
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter ( this, categoriesList,
                businessesList );
        categoriesRecycler.setLayoutManager
                ( new LinearLayoutManager ( this,
                        LinearLayoutManager.HORIZONTAL,
                        false ) );
        categoriesRecycler.setAdapter ( categoriesAdapter );

    }


    // Navigation Drawer functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront ();
        navigationView.setCheckedItem ( R.id.nav_home );

        menuIcon.setOnClickListener ( v -> {
            if (drawerLayout.isDrawerVisible ( GravityCompat.START ))
                drawerLayout.closeDrawer ( GravityCompat.START );
            else drawerLayout.openDrawer ( GravityCompat.START );
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


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId ();
        if (id == R.id.nav_home) {
            startActivity ( new Intent ( cardviewdesign.this, UserDashboard.class ) );
        } else if (id == R.id.nav_logout) {
            startActivity ( new Intent ( cardviewdesign.this, login.class ) );

        } else if (id == R.id.nav_share) {
            Intent intent2 = new Intent ( Intent.ACTION_SEND );
            intent2.putExtra
                    ( Intent.EXTRA_TEXT, "TENCIL APP COMING SOON " + " http://www.tencil.co.uk/"
                            + getPackageName () );
            intent2.setType ( "text/plain" );
            startActivity ( intent2 );


        }


        return true;

    }

    public void card1(@NonNull View view) {
        Intent intent = new Intent ( cardviewdesign.this, Solocompany.class );
        startActivity ( intent );
    }


}

