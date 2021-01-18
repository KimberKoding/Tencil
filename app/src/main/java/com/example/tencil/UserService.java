package com.example.tencil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserService {

    @POST("login.php?method=json")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<LoginResponse> userLogin(
            @Body LoginResponse loginResponse
    );

    @POST("registration.php?method=json")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<RegisterResponse> registerUsers(
            @Body RegisterRequest registerRequest
    );

    @POST("registration.php?method=json")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<RegisterResponse> authData(
            @Body RegisterRequest data
    );

    @GET("index.php")
    Call<List<CategoriesResponse>> getAllCategories();
}
