package com.example.tencil;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APiClient {
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec ( initVector.getBytes ( StandardCharsets.UTF_8 ) );
            SecretKeySpec skeySpec = new SecretKeySpec ( key.getBytes ( StandardCharsets.UTF_8 ), "AES" );

            Cipher cipher = Cipher.getInstance ( "AES/CBC/PKCS5PADDING" );
            cipher.init ( Cipher.ENCRYPT_MODE, skeySpec, iv );

        } catch (Exception ex) {
            ex.printStackTrace ();
        }
        return null;
    }


    public static void main(String[] args) {
        String originalString = "password";
        System.out.println ( "Original String to encrypt - " + originalString );
        String encryptedString = encrypt ( originalString );
        System.out.println ( "Encrypted String - " + encryptedString );
    }

    private static Retrofit getRetrofit() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor ();
        httpLoggingInterceptor.setLevel ( HttpLoggingInterceptor.Level.BODY );
        OkHttpClient okHttpClient = new OkHttpClient.Builder ().addInterceptor ( httpLoggingInterceptor ).build ();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder ();
        httpClient.addInterceptor ( new Interceptor () {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public Response intercept(Chain chain) throws IOException {
                byte[] bytes = new byte[16];
                try {
                    SecureRandom.getInstanceStrong ().nextBytes ( bytes );
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace ();
                }
                Request original = chain.request ();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder ()
                        .header ( "X-API-IV", "bytes" ); // <-- this is the important line
                Request request = requestBuilder.build ();
                return chain.proceed ( request );
            }
        } );

        Retrofit retrofit = new Retrofit.Builder ()
                .addConverterFactory ( GsonConverterFactory.create () )
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .client ( okHttpClient )
                .build ();


        return retrofit;
    }


    public static UserService getUserService() {
        UserService userService = getRetrofit ().create ( UserService.class );

        return userService;
    }


}

