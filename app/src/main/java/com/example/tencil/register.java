package com.example.tencil;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.annotations.SerializedName;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    public static class AES {

        private static SecretKeySpec secretKey;
        private static byte[] key;

        public static void setKey(String myKey) {
            MessageDigest sha = null;
            try {
                key = myKey.getBytes ( StandardCharsets.UTF_8 );
                sha = MessageDigest.getInstance ( "SHA-1" );
                key = sha.digest ( key );
                key = Arrays.copyOf ( key, 16 );
                secretKey = new SecretKeySpec ( key, "AES" );
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace ();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public static String encrypt(String strToEncrypt, String secret) {
            try {
                setKey ( secret );
                Cipher cipher = Cipher.getInstance ( "AES/ECB/PKCS5Padding" );
                cipher.init ( Cipher.ENCRYPT_MODE, secretKey );
                return Base64.getEncoder ().encodeToString ( cipher.doFinal ( strToEncrypt.getBytes ( StandardCharsets.UTF_8 ) ) );
            } catch (Exception e) {
                System.out.println ( "Error while encrypting: " + e.toString () );
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public static String decrypt(String strToDecrypt, String secret) {
            try {
                setKey ( secret );
                Cipher cipher = Cipher.getInstance ( "AES/ECB/PKCS5PADDING" );
                cipher.init ( Cipher.DECRYPT_MODE, secretKey );
                return new String ( cipher.doFinal ( Base64.getDecoder ().decode ( strToDecrypt ) ) );
            } catch (Exception e) {
                System.out.println ( "Error while decrypting: " + e.toString () );
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public static void main(String[] args) {
            final String secretKey = "ssshhhhhhhhhhh!!!!";

            String originalString = "howtodoinjava.com";
            String encryptedString = AES.encrypt ( originalString, secretKey );
            String decryptedString = AES.decrypt ( encryptedString, secretKey );

            System.out.println ( originalString );
            System.out.println ( encryptedString );
            System.out.println ( decryptedString );
        }
    }


    EditText email, password, repassword;
    private Button btn_register;
    private ProgressBar loading;
    @SerializedName("data")
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


        btn_register.setOnClickListener ( new View.OnClickListener () {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                RegisterRequest registerRequest = new RegisterRequest ();
                registerRequest.setEmail ( email.getText ().toString () );
                registerRequest.setPassword ( password.getText ().toString () );
                registerRequest.setData ( "data" );
                registerUser ( registerRequest );
                loading.setVisibility ( View.VISIBLE );


            }
        } );

    }

    public void registerUser(RegisterRequest registerRequest) {
        Call<RegisterResponse> registerResponseCall = APiClient.getUserService ().registerUsers ( registerRequest );
        registerResponseCall.enqueue ( new Callback<RegisterResponse> () {

            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
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
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText ( register.this, "Throwable " + t.getLocalizedMessage (), Toast.LENGTH_LONG ).show ();

            }
        } );
    }


    public void loginHere(View view) {
        startActivity ( new Intent ( getApplicationContext (), login.class ) );
        finish ();
    }


}