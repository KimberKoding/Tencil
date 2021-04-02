package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.User.UserDashboard;

public class soloCompanyFinance2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_solo_company_finance2 );
    }

    public void backDashsolo(View v) {
        soloCompanyFinance2.this.startActivity ( new Intent ( soloCompanyFinance2.this, UserDashboard.class ) );


    }
}