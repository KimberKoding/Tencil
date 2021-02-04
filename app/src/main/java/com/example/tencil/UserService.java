package com.example.tencil;

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
    @Headers({"Content-Type: application/json", "Accept: application/json", "X-API-KEY: a6lNFeTgMKth2xYKnlIC0o8cO8lubqcE"})
    Call<RegisterResponse> registerUsers(
            @Body RegisterRequest registerRequest
    );

    @GET("ivgen.php")
    Call<RegisterRequest> ivgen(@Body RegisterRequest ivgen);

    @GET("tools/cats.php?c=ALL")
    Call<JSONResponse> getMovies();


}
