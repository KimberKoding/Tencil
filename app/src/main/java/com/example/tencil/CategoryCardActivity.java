package com.example.tencil;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryCardActivity extends AppCompatActivity {
    private static final String TAG = "CategoryCardActivity";
    TextView category, categoryChosen, cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.all_categories_card );

        category = findViewById ( R.id.selectedcategory );
        cid = findViewById ( R.id.business_cid );

        category.setText ( getIntent ().getStringExtra ( "category" ) );
        cid.setText ( getIntent ().getStringExtra ( "cid" ) );

    }

    private void getIncomingIntent() {
        Log.d ( TAG, "getIncomingIntent: checking for incoming intents." );
        if (getIntent ().hasExtra ( "category_name" ) && getIntent ().hasExtra ( "category_id" ) && getIntent ().hasExtra ( "selected_category" )) {
            Log.d ( TAG, "getIncomingIntent: found intent extras!!" );
            String category = getIntent ().getStringExtra ( "category_name" );
            String cid = getIntent ().getStringExtra ( "category_id" );
            String categoryChosen = getIntent ().getStringExtra ( "selected_category" );
        }
    }


}
