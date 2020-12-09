package com.example.tencil.User;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tencil.R;
import com.google.android.material.navigation.NavigationView;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        setContentView ( R.layout.userdashboard );

        //Hooks
        menuIcon = findViewById ( R.id.menu_icon );
        contentView = findViewById ( R.id.content );

        //Menu Hooks
        drawerLayout = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.navigation_view );

        //Navigation Drawer
        navigationView.bringToFront ();
        navigationView.setNavigationItemSelectedListener ( this );

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;

    }
}