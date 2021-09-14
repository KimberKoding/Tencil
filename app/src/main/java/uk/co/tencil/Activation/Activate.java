package uk.co.tencil.Activation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.tencil.API.APiClient;
import uk.co.tencil.R;
import uk.co.tencil.User.Login.login;
import uk.co.tencil.User.Register.register;

public class Activate extends AppCompatActivity {
    EditText email, activatecode;
    Button btnActivate;
    Button resend;


    public void onCreate(@SuppressLint("UnknownNullness") Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activate_users );
        email = findViewById ( R.id.activateemail );
        activatecode = findViewById ( R.id.activatecode );
        btnActivate = findViewById ( R.id.btn_activate );
        resend = findViewById ( R.id.resend );

        btnActivate.setOnClickListener (view -> onClick());
    }

    private void activate(ActivateResponse res) {
        ActivateRequest activateRequest = new ActivateRequest ();
        activateRequest.setEmail ( email.getText ().toString () );
        activateRequest.setActivationCode ( activatecode.toString () );

        Call<ActivateResponse> activateResponseCall =
                APiClient.getUserService ().activateUsers ( res );
        activateResponseCall.enqueue ( new Callback<ActivateResponse> () {
            @Override
            public void onResponse(@NotNull Call<ActivateResponse> call,
                                   @NotNull Response<ActivateResponse> response) {
                if (response.isSuccessful ()) {
                    Intent intent = new Intent ( Activate.this, register.class );
                    Toast.makeText ( Activate.this,
                            "Verified user successfully", Toast.LENGTH_SHORT ).show ();
                    startActivity ( intent );

                } else {
                    Toast.makeText ( Activate.this,
                            "Issue with verifying user", Toast.LENGTH_SHORT ).show ();
                    System.out.println ( response + "Error" );
                }
            }

            @Override
            public void onFailure(@NotNull Call<ActivateResponse> call, @NotNull Throwable t) {
                Intent intent = new Intent ( Activate.this, login.class );
                Toast.makeText ( Activate.this,
                        "Verified user successfully", Toast.LENGTH_SHORT ).show ();
                startActivity ( intent );
            }

        } );


    }


    public void activate_dash(@Nullable View view) {
        Intent intent = new Intent ( this, login.class );
        startActivity ( intent );
    }


    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent ( this, login.class );
        startActivity ( returnIntent );
        finish ();
    }

    public void resendTO(@Nullable View view) {
        Intent intent = new Intent ( this, uk.co.tencil.User.Resend.resend.class );
        startActivity ( intent );
    }

    private void onClick() {

        if (TextUtils.isEmpty(email.getText().toString()) ||
                TextUtils.isEmpty(activatecode.getText().toString())) {
            Toast.makeText(Activate.this,
                    "Email / Activation Code Required", Toast.LENGTH_LONG).show();
        } else {
            //proceed to activate
            ActivateResponse res = new ActivateResponse();
            res.setEmail(email.getText().toString());
            res.setActivation(activatecode.getText().toString());
            activate(res);
        }

    }
}
