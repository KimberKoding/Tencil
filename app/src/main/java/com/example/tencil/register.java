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

import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {
    private static final String secretKey = "a61caa1f9aa6005111c14faa323411b0";
    private Button btn_register;
    private ProgressBar loading;
    private String data;
    private static final String dataSend = "a6lNFeTgMKth2xYKnlIC0o8cO8lubqcE";
    private static final String salt = "ssshhhhhhhhhhh!!!!";
    ////  Imports of components
    EditText email, password, repassword;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encrypt(String strToEncrypt) {
        try {
            byte[] iv = new byte[16];
            SecureRandom.getInstanceStrong ().nextBytes ( iv );
            IvParameterSpec ivspec = new IvParameterSpec ( iv );

            SecretKeyFactory factory = SecretKeyFactory.getInstance ( "PBKDF2WithHmacSHA256" );
            KeySpec spec = new PBEKeySpec ( secretKey.toCharArray (), salt.getBytes (), 65536, 256 );
            SecretKey tmp = factory.generateSecret ( spec );
            SecretKeySpec secretKey = new SecretKeySpec ( tmp.getEncoded (), "AES" );

            Cipher cipher = Cipher.getInstance ( "AES/CTR/PKCS5Padding" );
            cipher.init ( Cipher.ENCRYPT_MODE, secretKey, ivspec );
            String s = new String ( iv, StandardCharsets.UTF_8 );

            return Base64.getEncoder ().encodeToString ( cipher.doFinal ( strToEncrypt.getBytes ( StandardCharsets.UTF_8 ) ) ) + "INITVECTOR" + Base64.getEncoder ().encodeToString ( iv );
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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
            data = encrypt ( dataSend );
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