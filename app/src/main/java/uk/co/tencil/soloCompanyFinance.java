package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.User.UserDashboard;

public class soloCompanyFinance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company_finance );
    }

    public void backDashsolo(View v) {
        soloCompanyFinance.this.startActivity ( new Intent ( soloCompanyFinance.this, UserDashboard.class ) );


    }
}