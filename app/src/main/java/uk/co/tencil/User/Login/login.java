package uk.co.tencil.User.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.tencil.API.APiClient;
import uk.co.tencil.Activation.Activate;
import uk.co.tencil.R;
import uk.co.tencil.User.ForogttenPassword.ForgetPassword;
import uk.co.tencil.User.Register.register;
import uk.co.tencil.User.UserDashboard;

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
                    String user = loginResponse.getEmail ();
                    Boolean passMatch = loginResponse.getPassMatch ();
                    String fname = loginResponse.getFname ();
                    Boolean userActive = loginResponse.getUserActive ();
                    String userApiKey = loginResponse.getUserApiKey ();
                    System.out.println ( response );


                    if (passMatch && userActive) {

                        //Create a Session
                        SessionManager sessionManager = new SessionManager ( login.this );
                        sessionManager.createLoginSession ( email, password );


                        Toast.makeText ( login.this, "Login Successful", Toast.LENGTH_LONG ).show ();
                        new Handler ().postDelayed ( new Runnable () {
                            @Override
                            public void run() {
                                Intent intent = new Intent ( login.this, UserDashboard.class );
                                intent.putExtra ( "fname", loginResponse.getFname () );
                                intent.putExtra ( "email", loginResponse.getEmail () );
                                intent.putExtra ( "userapikey", loginResponse.getUserApiKey () );
                                startActivity ( intent );
                            }


                        }, 400 );
                    } else {
                        Toast.makeText ( login.this, "Credentials are incorrect or Account is not active or you have not made an account", Toast.LENGTH_LONG ).show ();
                    }

                } else {
                    Toast.makeText ( login.this, "Credentials are incorrect or Account is not active or you have not made an account", Toast.LENGTH_LONG ).show ();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println ( "ERROR :" + "" + "" + t );
            }
        } );


    }


    public void register(View view) {
        startActivity ( new Intent ( this, register.class ) );
        finish ();

    }

    public void activate(View view) {
        startActivity ( new Intent ( getApplicationContext (), Activate.class ) );
        finish ();
    }

    @Override
    public void onBackPressed() {
        System.out.println ( "back button pressed" );
    }

    public void forgottenpassword(View view) {
        Intent intent = new Intent ( this, ForgetPassword.class );
        startActivity ( intent );
    }
}





