package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.User.UserDashboard;

import static com.example.tencil.R.layout.activity_finance_company;

public class financeCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( activity_finance_company );
    }

    public void ryanNav(View v) {
        financeCompany.this.startActivity ( new Intent ( financeCompany.this, UserDashboard.class ) );
        System.out.println ( "Going to NEW ACTIVITY" );


    }


    public void seemore1(View view) {
        financeCompany.this.startActivity ( new Intent ( financeCompany.this, soloCompanyFinance.class ) );
    }

    public void seemore2(View view) {
        financeCompany.this.startActivity ( new Intent ( financeCompany.this, soloCompanyFinance2.class ) );
    }

}

