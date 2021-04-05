package uk.co.tencil.User;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.tencil.Businesses;
import uk.co.tencil.BusinessesAdapter;
import uk.co.tencil.BusinessesResponse;
import uk.co.tencil.Categories;
import uk.co.tencil.CategoriesAdapter;
import uk.co.tencil.CategoryCardActivity;
import uk.co.tencil.GetAllBusinessesByCid;
import uk.co.tencil.JSONResponse;
import uk.co.tencil.R;
import uk.co.tencil.SessionManager;
import uk.co.tencil.UserService;
import uk.co.tencil.financeCompany;
import uk.co.tencil.fintechCompany;
import uk.co.tencil.login;
import uk.co.tencil.socialMedia;
import uk.co.tencil.techCompany;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CategoriesAdapter.RecyclerViewClickInterface {

    // WE WILL BUILD A PROFESSIONAL APP ;)

    private static final String JSON_URL = "https://providencewebservices.co.uk/api-test/v1/tools/cats.php?c=ALL";
    private static final String JSON_URL2 = "https://providencewebservices.co.uk/api-test/v1/tools/businesses.php?method=get&ft=true";
    private static final String TAG = "CLICKED";
    //Variables + Widgets
    String shareBody = "This is a Great App, TENCIL APP COMING SOON";
    Button btnShare;
    ImageView menuIcon;
    LinearLayout contentView;
    static float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, categoriesRecycler;
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Context mContext;
    List<Categories> categoriesList;
    List<Businesses> businessesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );


        setContentView ( R.layout.userdashboard );

        //Hooks
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );
        featuredRecycler = findViewById ( R.id.featured_recycler );
        categoriesRecycler = findViewById ( R.id.categories_recycler );
        categoriesList = new ArrayList<> ();
        businessesList = new ArrayList<> ();

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
                System.out.println ( response + "Businesses BITCH" );
                BusinessesResponse businessesResponse = response.body ();
                businessesList = new ArrayList<> ( Arrays.asList ( businessesResponse.getBusinesses () ) );
                PutDataIntoView ( businessesList );
            }

            @Override
            public void onFailure(Call<BusinessesResponse> call, Throwable t) {
                System.out.println ( t + "FUUCK" );

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

    private void PutDataIntoView(List<Businesses> businessesList) {
        BusinessesAdapter businessesAdapter = new BusinessesAdapter ( this, businessesList );
        featuredRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false ) );
        featuredRecycler.setAdapter ( businessesAdapter );
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
        } else if (id == R.id.nav_categories) {
            startActivity ( new Intent ( UserDashboard.this, UserDashboard.class ) );
        } else if (id == R.id.nav_logout) {
            startActivity ( new Intent ( UserDashboard.this, login.class ) );

        } else if (id == R.id.nav_share) {
            Intent intent2 = new Intent ( Intent.ACTION_SEND );
            intent2.putExtra ( Intent.EXTRA_TEXT, "TENCIL APP COMING SOON " + " http://www.tencil.co.uk/" + getPackageName () );
            intent2.setType ( "text/plain" );
            startActivity ( intent2 );


        }


        return true;

    }

    public void cardClicked1(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, socialMedia.class ) );
    }

    public void cardClicked2(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, financeCompany.class ) );
    }

    public void cardClicked3(View v) {

        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, techCompany.class ) );
    }


    public void cardClicked4(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, fintechCompany.class ) );

    }

    public void viewAllClicked(View view) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, GetAllBusinessesByCid.class ) );
    }


    @Override
    public void onItemClick(int position) {
        Log.d ( TAG, "onItemClick: " + position );
        System.out.println ( "SUCCESS" );
        Intent intent = new Intent ( this, CategoryCardActivity.class );
        intent.putExtra ( "category", categoriesList.get ( position ) );
        intent.putExtra ( "cat_id", categoriesList.get ( position ) );
        startActivity ( intent );


    }

}
