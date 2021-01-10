package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    private static final String URL_REGIST = "https://providencewebservices.co.uk/api-test/v1/test-suite/registration.php";
    private EditText email, password, repassword;
    private Button btn_register;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );
        loading = findViewById ( R.id.loading );
        email = findViewById ( R.id.email );
        password = findViewById ( R.id.password );
        repassword = findViewById ( R.id.repassword );
        btn_register = findViewById ( R.id.btn_register );


        btn_register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Regist ();
            }
        } );

    }

    private void Regist() {
        loading.setVisibility ( View.VISIBLE );
        btn_register.setVisibility ( View.GONE );
        final String email = this.email.getText ().toString ().trim ();
        final String password = this.password.getText ().toString ().trim ();
        final String repassword = this.repassword.getText ().toString ().trim ();
        StringRequest stringRequest = new StringRequest ( Request.Method.POST, URL_REGIST,
                new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject ( response );
                            String success = jsonObject.getString ( "Success" );
                            if (success.equals ( "1" )) {
                                Toast.makeText ( register.this, "Register Success!", Toast.LENGTH_SHORT ).show ();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace ();
                            Toast.makeText ( register.this, "Register Error!" + e.toString (), Toast.LENGTH_SHORT ).show ();
                            loading.setVisibility ( View.GONE );
                            btn_register.setVisibility ( View.VISIBLE );
                        }
                    }
                },
                new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText ( register.this, "Register Error!" + error.toString (), Toast.LENGTH_SHORT ).show ();
                        loading.setVisibility ( View.GONE );
                        btn_register.setVisibility ( View.VISIBLE );
                    }
                } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<> ();
                params.put ( "email", email );
                params.put ( "password", password );
                params.put ( "repassword", repassword );

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue ( this );
        requestQueue.add ( stringRequest );
    }

    public void loginHere(View view) {
        startActivity ( new Intent ( getApplicationContext (), login.class ) );
        finish ();
    }

}