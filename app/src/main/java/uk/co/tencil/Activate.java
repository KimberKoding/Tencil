package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activate extends AppCompatActivity {
    EditText email, activatecode;
    Button btnActivate;
    Button resend;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activate_users );
        email = findViewById ( R.id.activateemail );
        activatecode = findViewById ( R.id.activatecode );
        btnActivate = findViewById ( R.id.btn_activate );
        resend = findViewById ( R.id.resend );

        btnActivate.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty ( email.getText ().toString () ) || TextUtils.isEmpty ( activatecode.getText ().toString () )) {
                    Toast.makeText ( Activate.this, "Email / Activation Code Required", Toast.LENGTH_LONG ).show ();
                } else {
                    //proceed to activate
                    ActivateResponse res = new ActivateResponse ();
                    res.setEmail ( email.getText ().toString () );
                    res.setActivation ( activatecode.getText ().toString () );
                    activate ( res );
                }

            }
        } );
    }

    private void activate(ActivateResponse res) {
        ActivateRequest activateRequest = new ActivateRequest ();
        activateRequest.setEmail ( email.getText ().toString () );
        activateRequest.setActivationCode ( activatecode.toString () );

        Call<ActivateResponse> activateResponseCall = APiClient.getUserService ().activateUsers ( res );
        activateResponseCall.enqueue ( new Callback<ActivateResponse> () {
            @Override
            public void onResponse(Call<ActivateResponse> call, Response<ActivateResponse> response) {
                if (response.isSuccessful ()) {
                    ActivateResponse activateResponse = response.body ();
                    Intent intent = new Intent ( Activate.this, register.class );
                    Toast.makeText ( Activate.this, "Verified user successfully", Toast.LENGTH_SHORT ).show ();
                    startActivity ( intent );

                } else {
                    Toast.makeText ( Activate.this, "Glitch in the Matrix", Toast.LENGTH_SHORT ).show ();
                    System.out.println ( response + "Error" );
                }
            }

            @Override
            public void onFailure(Call<ActivateResponse> call, Throwable t) {
                Intent intent = new Intent ( Activate.this, login.class );
                Toast.makeText ( Activate.this, "Verified user successfully", Toast.LENGTH_SHORT ).show ();
                startActivity ( intent );
            }
        } );


    }


    public void activate_dash(View view) {
        Intent intent = new Intent ( this, login.class );
        startActivity ( intent );
    }


    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent ( this, login.class );
        startActivity ( returnIntent );
        finish ();
    }

    public void resendTO(View view) {
        Intent intent = new Intent ( this, resend.class );
        startActivity ( intent );
    }
}
