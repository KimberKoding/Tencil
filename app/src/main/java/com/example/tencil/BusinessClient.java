package com.example.tencil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BusinessClient {
    private static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder ()
                .addConverterFactory ( GsonConverterFactory.create () )
                .baseUrl ( "https://providencewebservices.co.uk/api-test/v1/" )
                .build ();


        return retrofit;
    }

    public static BusinessService businessService() {
        BusinessService businessService = getRetrofit ().create ( BusinessService.class );

        return businessService;
    }
}
