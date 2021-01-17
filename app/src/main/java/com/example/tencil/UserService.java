package com.example.tencil;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("login.php?method=json")
    Call<LoginResponse> userLogin();

    @POST("registration.php?method=json")
    Call<RegisterResponse> registerUsers(
            @Body RegisterRequest registerRequest
    );

}
