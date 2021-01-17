package com.example.tencil;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tencil.User.UserDashboard;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class login extends AppCompatActivity {
    Button btnLogin;
    EditText email, password;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        email = findViewById ( R.id.email );
        password = findViewById ( R.id.password );
        btnLogin = findViewById ( R.id.btn_login );

        btnLogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty ( email.getText ().toString () ) || TextUtils.isEmpty ( password.getText ().toString () )) {
                    Toast.makeText ( login.this, "Email / Password Required", Toast.LENGTH_LONG ).show ();
                } else {
                    //proceed to login
                    LoginResponse res = new LoginResponse();
                    res.setEmail(email.getText().toString());
                    res.setPassword(password.getText().toString());
                    login (res);
                }

            }
        } );
    }


    public void login(LoginResponse credentials) {
        LoginRequest loginRequest = new LoginRequest ();
        loginRequest.setEmail ( email.getText ().toString () );
        loginRequest.setPassword ( password.getText ().toString () );

        Call<LoginResponse> loginResponseCall = APiClient.getUserService ().userLogin (credentials);
        loginResponseCall.enqueue ( new Callback<LoginResponse> () {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful ()) {
                    LoginResponse loginResponse = response.body ();
                    String user = loginResponse.getEmail();
                    Boolean passMatch = loginResponse.getPassMatch();

                    if(passMatch) {

                        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(login.this, UserDashboard.class));
                            }
                        }, 700);
                    } else {
                        Toast.makeText ( login.this, "Credentials are incorrect", Toast.LENGTH_LONG ).show ();
                    }

                } else {
                    Toast.makeText ( login.this, "Login Failed", Toast.LENGTH_LONG ).show ();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText ( login.this, "Throwable " + t.getLocalizedMessage (), Toast.LENGTH_LONG ).show ();

            }
        } );


    }


    public void register(View view) {
        startActivity ( new Intent ( getApplicationContext (), register.class ) );
        finish ();

    }
}





