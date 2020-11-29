package com.example.tencil;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView ( R.layout.activity_dashboard );

        //Hooks
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );

        //Menu Hooks
        drawerLayout = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.navigation_view );

        navigationDrawer ();

    }

    //Navigation Drawer Functions
    private void navigationDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront ();
        navigationView.setNavigationItemSelectedListener ( this );
        navigationView.setCheckedItem ( R.id.nav_home );

        menuIcon.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible ( GravityCompat.START ))
                    drawerLayout.closeDrawer ( GravityCompat.START );
                else drawerLayout.openDrawer ( GravityCompat.START );
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

}