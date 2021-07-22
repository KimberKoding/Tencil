package uk.co.tencil.CompanyView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;
import uk.co.tencil.User.UserDashboard;

public class solo_company extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company );
    }

    public void backDashsolo(@Nullable View v) {
        solo_company.this.startActivity ( new Intent
                (solo_company.this, UserDashboard.class ) );


    }


}
