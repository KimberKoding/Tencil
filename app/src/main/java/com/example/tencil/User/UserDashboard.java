package com.example.tencil.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.AllCategories;
import com.example.tencil.FeaturedBusiness;
import com.example.tencil.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.tencil.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.tencil.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.tencil.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    ImageView menuIcon;
    LinearLayout contentView;
    static final float END_SCALE = 0.7f;
    LinearLayout content;
    RecyclerView featuredRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;


    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        setContentView ( R.layout.userdashboard );

        //Hooks
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );
        featuredRecycler = findViewById ( R.id.featured_recycler );
        categoriesRecycler = findViewById ( R.id.categories_recycler );
        featuredRecycler ();
        categoriesRecycler ();


        //Menu Hooks
        drawerLayout = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.navigation_view );
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );


        navigationDrawer ();
    }

    private void categoriesRecycler() {


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<> ();
        categoriesHelperClasses.add ( new CategoriesHelperClass ( R.drawable.pwsb, "Social Media" ) );
        categoriesHelperClasses.add ( new CategoriesHelperClass ( R.drawable.piggy, "Finance Companies" ) );
        categoriesHelperClasses.add ( new CategoriesHelperClass ( R.drawable.categories_restaurant_icon, "Tech Companies" ) );
        categoriesHelperClasses.add ( new CategoriesHelperClass ( R.drawable.analysisw, "FinTech Companies" ) );
        categoriesHelperClasses.add ( new CategoriesHelperClass ( R.drawable.home, "Local" ) );


        categoriesRecycler.setHasFixedSize ( true );
        adapter = new CategoriesAdapter ( categoriesHelperClasses );
        categoriesRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false ) );
        categoriesRecycler.setAdapter ( adapter );

    }


    //Setting Featured Recylcer design view
    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize ( true );
        featuredRecycler.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false ) );

        ArrayList<FeaturedHelperClass> featuredBusinesses = new ArrayList<> ();
        featuredBusinesses.add ( new FeaturedHelperClass ( R.drawable.pwsb, "Provide", "rtrgrrgesdsdsd assasasa asa asa" ) );
        featuredBusinesses.add ( new FeaturedHelperClass ( R.drawable.tencilw, "Tencil", "rtrgrrgesdsdsd assasasa asa asa" ) );
        featuredBusinesses.add ( new FeaturedHelperClass ( R.drawable.pwsb, "test3", "rgttgtefe assasasa asa asa" ) );

        adapter = new FeaturedAdapter ( (featuredBusinesses) );
        featuredRecycler.setAdapter ( adapter );
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, FeaturedBusiness.class ) );
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
        } else
            super.onBackPressed ();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;

    }

    public void cardClicked1(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, AllCategories.class ) );
    }

    public void cardClicked2(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, AllCategories.class ) );
    }

    public void cardClicked3(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, AllCategories.class ) );
    }

    public void cardClicked4(View v) {
        UserDashboard.this.startActivity ( new Intent ( UserDashboard.this, AllCategories.class ) );
    }


}
