package com.example.tencil;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tencil.User.UserDashboard;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class login extends AppCompatActivity {
    Button btnLogin;
    EditText email, password;
    String auth;
    String URL = "https://my-json-server.typicode.com/typicode/demo/posts";

    private void sendReq() {
        try {
            final String urlAdress = "https://providencewebservices.co.uk/api-test/v1/test-suite/newEmptyPHP.php";
            java.net.URL url = new URL ( urlAdress );
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection ();
            } catch (IOException ioException) {
                ioException.printStackTrace ();
            }
            try {
                conn.setRequestMethod ( "POST" );
            } catch (ProtocolException protocolException) {
                protocolException.printStackTrace ();
            }
            conn.setRequestProperty ( "Content-Type", "application/json;charset=UTF-8" );
            conn.setRequestProperty ( "Accept", "application/json" );
            conn.setDoOutput ( true );
            conn.setDoInput ( true );

            JSONObject jsonParam = new JSONObject ();
            //jsonParam.put ( "timestamp", 1488873360 );
            jsonParam.put ( "uid", email );
            jsonParam.put ( "pwd", password );
            jsonParam.put ( "auth_mode", "basic" );


            Log.i ( "JSON", jsonParam.toString () );
            DataOutputStream os = null;
            try {
                os = new DataOutputStream ( conn.getOutputStream () );
            } catch (IOException e) {
                e.printStackTrace ();
            }
            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            try {
                os.writeBytes ( jsonParam.toString () );
            } catch (IOException e) {
                e.printStackTrace ();
            }

            try {
                Log.i ( "STATUS", String.valueOf ( conn.getResponseCode () ) );
            } catch (IOException ioException) {
                ioException.printStackTrace ();
            }
            try {
                Log.i ( "MSG", conn.getResponseMessage () );
            } catch (IOException ioException) {
                ioException.printStackTrace ();
            }

            conn.disconnect ();
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        Button submitButton = findViewById ( R.id.btn_login );

        submitButton.setOnClickListener ( new View.OnClickListener () {
            public void onClick(View v) {
                JSONObject postData = new JSONObject ();
                try {
                    postData.put ( "email", email.getText ().toString () );
                    postData.put ( "password", password.getText ().toString () );
                    postData.put ( "auth_mode", "basic" );

                    new SendDeviceDetails ().execute ( "https://providencewebservices.co.uk/api-test/v1/test-suite/newEmptyPHP.php", postData.toString () );
                } catch (JSONException e) {
                    e.printStackTrace ();
                }
            }

            class SendDeviceDetails {
                public void execute(String s, String toString) {
                }
            }
        } );
        btnLogin = findViewById ( R.id.btn_login );
        email = findViewById ( R.id.email );
        password = findViewById ( R.id.password );
        btnLogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Login ();
            }
        } );

    }

    private void Login() {
        RequestQueue requestQueue = Volley.newRequestQueue ( this );
        StringRequest stringRequest = new StringRequest ( Request.Method.POST, URL, new Response.Listener<String> () {
            Boolean ryanAuth;

            @Override
            public void onResponse(String response) {
                if (response.trim ().equals ( ryanAuth )) {
                    Toast.makeText ( getApplicationContext (), "Login Successful", Toast.LENGTH_SHORT ).show ();
                    startActivity ( new Intent ( login.this, UserDashboard.class ) );
                } else {
                    Toast.makeText ( getApplicationContext (), "Login Failed", Toast.LENGTH_SHORT ).show ();

                }
                System.out.println ( "This is the response:" + response );
                JsonObject jsonObject = new JsonParser ().parse ( response ).getAsJsonObject ();
                System.out.println ( jsonObject.get ( "id" ).getAsString () ); //ID
                ryanAuth = jsonObject.get ( "id" ).getAsBoolean ();
                System.out.println ( ryanAuth );

            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText ( getApplicationContext (), "Error" + error.toString (), Toast.LENGTH_SHORT ).show ();
            }
        } ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<> ();
                params.put ( "uid", email.getText ().toString ().trim () );
                params.put ( "pwd", password.getText ().toString ().trim () );
                params.put ( "auth_mode", "basic" );

                System.out.println ( params );
                JSONObject array = new JSONObject ( params );
                return params;
            }
        };
        requestQueue.add ( stringRequest );
    }


}


