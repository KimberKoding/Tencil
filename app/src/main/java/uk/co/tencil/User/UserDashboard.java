package uk.co.tencil.User;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.newrelic.agent.android.NewRelic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.tencil.API.UserService;
import uk.co.tencil.Businesses.Businesses;
import uk.co.tencil.Businesses.BusinessesAdapter;
import uk.co.tencil.Businesses.BusinessesResponse;
import uk.co.tencil.Businesses.JSONResponse;
import uk.co.tencil.Categories.Categories;
import uk.co.tencil.Categories.CategoriesAdapter;
import uk.co.tencil.Legal.privacy_policy;
import uk.co.tencil.Questions.questionone;
import uk.co.tencil.R;
import uk.co.tencil.User.Login.SessionManager;
import uk.co.tencil.User.Login.login;
import uk.co.tencil.WeRecommend.WerecommendAdapter;
import uk.co.tencil.WeRecommend.WerecommendResponse;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // WE WILL BUILD A PROFESSIONAL APP ;)

    static int cid;


    public int getCid() {
        System.out.println ( "getCid() method was called! CID is: " + cid );
        cid = (1);
        return cid;
    }


    //Variables + Widgets
    String shareBody = "This is a Great App, TENCIL APP COMING SOON";
    Button btnShare;
    ImageView menuIcon;
    TextView welcomeuserdash;
    LinearLayout contentView;
    static float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, categoriesRecycler, werecommendRecycler;
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Context mContext;
    List<Categories> categoriesList;
    List<Businesses> businessesList;
    List<Businesses> werecommendList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.userdashboard );
        NewRelic.withApplicationToken (
                "eu01xxd3e41d94d24d89321ca1a55320c48e9681c3-NRMA"
        ).start ( this.getApplicationContext () );
        //Hooks
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );
        featuredRecycler = findViewById ( R.id.featured_recycler );
        categoriesRecycler = findViewById ( R.id.categories_recycler );
        werecommendRecycler = findViewById ( R.id.werecommendrecycler );
        werecommendList = new ArrayList<> ();
        categoriesList = new ArrayList<> ();
        businessesList = new ArrayList<> ();
        welcomeuserdash = findViewById ( R.id.welcomeuserdash );
        SessionManager sessionManager = new SessionManager ( this );
        HashMap<String, String> userDetails = sessionManager.getUsersDetailFromSession ();

        String email = userDetails.get ( SessionManager.KEY_EMAIL );
        String password = userDetails.get ( SessionManager.KEY_PASSWORD );
        System.out.println ( email + password + "Printed to console" );

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

        Call<BusinessesResponse> call1 = userService.getBusinesses ();
        call1.enqueue ( new Callback<BusinessesResponse> () {
            @Override
            public void onResponse(Call<BusinessesResponse> call, Response<BusinessesResponse> response) {
                BusinessesResponse businessesResponse = response.body ();
                businessesList = new ArrayList<> ( Arrays.asList ( businessesResponse.getBusinesses () ) );
                PutDataIntoView ( businessesList );

            }

            @Override
            public void onFailure(Call<BusinessesResponse> call, Throwable t) {
                System.out.println ( t + "FUUCK" );

            }
        } );

        Call<WerecommendResponse> call2 = userService.werecommend ( getCid () );
        call2.enqueue ( new Callback<WerecommendResponse> () {
            @Override
            public void onResponse(Call<WerecommendResponse> call,
                                   Response<WerecommendResponse> response) {
                System.out.println ( response + "We Recommend Feature Loaded" );
                WerecommendResponse werecommendResponse = response.body ();
                werecommendList = new ArrayList<>
                        ( Arrays.asList ( werecommendResponse.werecommend () ) );
                PutDataIntoWeRecommend ( werecommendList );


            }

            @Override
            public void onFailure(Call<WerecommendResponse> call, Throwable t) {

            }
        } );


        //Menu Hooks
        drawerLayout = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.navigation_view );
        menuIcon = findViewById ( R.id.menu_icon );

        //RecyclerView Hooks
        contentView = findViewById ( R.id.content );
        navigationDrawer ();


    }


    private void PutDataIntoWeRecommend(List<Businesses> werecommendList) {
        WerecommendAdapter werecommendAdapter = new WerecommendAdapter ( this,
                werecommendList );
        werecommendRecycler.setLayoutManager ( new LinearLayoutManager ( this,
                LinearLayoutManager.HORIZONTAL, false ) );
        werecommendRecycler.setAdapter ( werecommendAdapter );


    }

    private void PutDataIntoView(List<Businesses> businessesList) {
        BusinessesAdapter businessesAdapter = new BusinessesAdapter ( this, businessesList );
        featuredRecycler.setLayoutManager ( new LinearLayoutManager ( this,
                LinearLayoutManager.HORIZONTAL, false ) );
        featuredRecycler.setAdapter ( businessesAdapter );
    }

    private void PutDataIntoRecyclerView(List<Categories> categoriesList) {
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter ( this, categoriesList, businessesList );
        categoriesRecycler.setLayoutManager ( new LinearLayoutManager ( this,
                LinearLayoutManager.HORIZONTAL, false ) );
        categoriesRecycler.setAdapter ( categoriesAdapter );


    }


    // Navigation Drawer functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront ();
        navigationView.setNavigationItemSelectedListener ( this );
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId ();
        if (id == R.id.nav_home) {
            startActivity ( new Intent ( UserDashboard.this, UserDashboard.class ) );
        } else if (id == R.id.nav_logout) {
            startActivity ( new Intent ( UserDashboard.this, login.class ) );

        } else if (id == R.id.nav_profile) {
            Intent receiveIntent = getIntent ();
            Bundle bundle = receiveIntent.getExtras ();
            System.out.println ( "Intents" + receiveIntent.getExtras () );
            Intent toUserProfile = new Intent ( UserDashboard.this, user_profile.class );
            toUserProfile.putExtra ( "logininfo", bundle );

            startActivity ( toUserProfile );


        } else if (id == R.id.nav_share) {
            Intent intent2 = new Intent ( Intent.ACTION_SEND );
            intent2.putExtra ( Intent.EXTRA_TEXT, "Download the Tencil App Today!" + "https://play.google.com/store/apps/details?id=uk.co.tencil.app" + getPackageName () );
            intent2.setType ( "text/plain" );
            startActivity ( intent2 );


        } else if (id == R.id.legal) {
            startActivity ( new Intent ( this, privacy_policy.class ) );
            finish ();
        } else if (id == R.id.nav_qs) {
            Intent recieveIntent = getIntent ();
            Bundle bundle = recieveIntent.getExtras ();
            Intent toqs = new Intent ( UserDashboard.this, questionone.class );
            toqs.putExtra ( "logininfo", bundle );
            startActivity ( toqs );
        } else if (id == R.id.nav_technical) {
            Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://manage.statuspage.io/pages/sgndqzkndcf7/incidents" ) );
            startActivity ( browserIntent );
        }


        return true;

    }



}
