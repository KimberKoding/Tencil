package uk.co.tencil;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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


    @GET("tools/cats.php?c=ALL")
    Call<JSONResponse> getCategories();

    @GET("tools/businesses.php?method=get&ft=true")
    Call<BusinessesResponse> getBusinesses();

    @GET("tools/businesses.php?method=get")
    Call<GetAllBusinessesByCidResponse> getAllBusinessesByCID(@Query("cid") int cid);

    @GET("tools/businesses.php?method=get")
    Call<SolocompanyResponse> getSolo(@Query("bname") int bname);

    @POST("tools/activate.php")
    Call<ActivateResponse> activateUsers(
            @Body ActivateResponse res);

    @POST("tools/activate.php?func=resend")
    Call<ResendRequest> resendemail(
            @Body ResendResponse resendMe);

}

