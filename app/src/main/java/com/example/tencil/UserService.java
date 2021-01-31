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
    @Headers({"Content-Type: application/json", "Accept: application/json", "X-API-KEY: ee4183831d9c0fd8794c9161a25c36b6"})
    Call<RegisterResponse> registerUsers(
            @Body RegisterRequest registerRequest
    );

    @GET("ivgen.php")
    Call<RegisterRequest> ivgen(@Body RegisterRequest ivgen);

    @GET("catsGet.php?c=ALL")
    Call<List<CategoriesResponse>> getAllCategories();
}
