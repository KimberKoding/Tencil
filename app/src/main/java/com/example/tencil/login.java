package com.example.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tencil.User.UserDashboard;

import org.json.JSONObject;

public class login<objectRequest> extends AppCompatActivity implements View.OnClickListener {
    String URL = "https://providencewebservices.co.uk/api-test/v1/login.php?enc_mode=plain&servicing=true";

    RequestQueue requestQueue = Volley.newRequestQueue ( this );

    JsonObjectRequest objectRequest = new JsonObjectRequest (
            Request.Method.GET,
            URL,
            null,
            new Response.Listener<JSONObject> () {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e ( "Rest Response", response.toString () );
                }
            },
            new Response.ErrorListener () {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e ( "Rest Response", error.toString () );
                    requestQueue.add ( objectRequest );


                }

            }

    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        Button btn_login = findViewById ( R.id.btn_login );
        btn_login.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        login.this.startActivity ( new Intent ( login.this, UserDashboard.class ) );
    }

    public void register(View view) {
        startActivity ( new Intent ( getApplicationContext (), register.class ) );
        finish ();
    }
}

