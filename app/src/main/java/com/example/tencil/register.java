package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {
////  Imports of components
EditText email, password, repassword;
    private Button btn_register;
    private ProgressBar loading;
    private String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );
        loading = findViewById ( R.id.loading );
        email = findViewById ( R.id.email );
        password = findViewById ( R.id.password );
        repassword = findViewById ( R.id.repassword );
        btn_register = findViewById ( R.id.btn_register );

        btn_register.setOnClickListener ( view -> {
            RegisterRequest registerRequest = new RegisterRequest ();
            registerRequest.setEmail ( email.getText ().toString () );
            registerRequest.setPassword ( password.getText ().toString () );
            registerRequest.setData ( data );
            registerUser ( registerRequest );
            loading.setVisibility ( View.VISIBLE );
        } );

    }

    public void registerUser(RegisterRequest registerRequest) {
        Call<RegisterResponse> registerResponseCall = APiClient.getUserService ().registerUsers ( registerRequest );
        registerResponseCall.enqueue ( new Callback<RegisterResponse> () {

            @Override
            public void onResponse(@NotNull Call<RegisterResponse> call, @NotNull Response<RegisterResponse> response) {
                if (response.isSuccessful ()) {
                    Toast.makeText ( register.this, "Registered User Successful", Toast.LENGTH_LONG ).show ();
                    RegisterResponse registerResponse = response.body ();
                    loading.setVisibility ( View.GONE );
                    startActivity ( new Intent ( register.this, login.class ) );
                } else {

                    Toast.makeText ( register.this, "An Error occurred, please try again", Toast.LENGTH_LONG ).show ();
                    System.out.println ( "RESPONSE:" + response );
                    loading.setVisibility ( View.GONE );
                }


            }

            @Override
            public void onFailure(@NotNull Call<RegisterResponse> call, @NotNull Throwable t) {
                Toast.makeText ( register.this, "Throwable " + t.getLocalizedMessage (), Toast.LENGTH_LONG ).show ();

            }
        } );
    }


    public void loginHere(View view) {
        startActivity ( new Intent ( getApplicationContext (), login.class ) );
        finish ();
    }


}