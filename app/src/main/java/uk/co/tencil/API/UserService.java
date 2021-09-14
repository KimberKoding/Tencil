package uk.co.tencil.API;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import uk.co.tencil.Activation.ActivateResponse;
import uk.co.tencil.Businesses.BusinessesResponse;
import uk.co.tencil.Businesses.GetAllBusinessesByCidResponse;
import uk.co.tencil.Businesses.JSONResponse;
import uk.co.tencil.CompanyView.SolocompanyResponse;
import uk.co.tencil.Questions.QuestionsResponse;
import uk.co.tencil.User.EditUser.EditResponse;
import uk.co.tencil.User.Login.LoginResponse;
import uk.co.tencil.User.Passwordreset.PasswordResponse;
import uk.co.tencil.User.Passwordreset.ResetResponse;
import uk.co.tencil.User.Register.RegisterRequest;
import uk.co.tencil.User.Register.RegisterResponse;
import uk.co.tencil.User.Resend.ResendRequest;
import uk.co.tencil.User.Resend.ResendResponse;
import uk.co.tencil.WeRecommend.WerecommendResponse;

public interface UserService {

    @Nullable
    @POST("login.php?method=json")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    Call<LoginResponse> userLogin(
            @Body @NonNull LoginResponse loginResponse
    );

    @Nullable
    @POST("registration.php?method=json")
    @Headers({"Content-Type: application/json",
            "Accept: application/json",
            "X-API-KEY: a6lNFeTgMKth2xYKnlIC0o8cO8lubqcE"})
    Call<RegisterResponse> registerUsers(
            @Body @NonNull RegisterRequest registerRequest
    );


    @NonNull
    @GET("tools/cats.php?c=ALL")
    Call<JSONResponse> getCategories();

    @NonNull
    @GET("tools/businesses.php?method=get&ft=true")
    Call<BusinessesResponse> getBusinesses();

    @NonNull
    @GET("tools/businesses.php?method=get")
    Call<GetAllBusinessesByCidResponse> getAllBusinessesByCID(@Query("cid") int cid);

    @NonNull
    @GET("tools/businesses.php?method=get")
    Call<SolocompanyResponse> getSolo(@Query("bname") int bname);

    @NonNull
    @POST("tools/activate.php")
    Call<ActivateResponse> activateUsers(
            @Body @NonNull ActivateResponse res);

    @NonNull
    @POST("tools/activate.php?func=resend")
    Call<ResendRequest> resendemail(
            @Body @NonNull ResendResponse resendMe);

    @NonNull
    @POST("tools/pwreset.php?func=ir")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "X-API-KEY: a6lNFeTgMKth2xYKnlIC0o8cO8lubqcE"})
    Call<PasswordResponse> resetpassword(
            @Body @NonNull PasswordResponse resetPass);


    @NonNull
    @POST("tools/pwreset.php?func=res")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "X-API-KEY: a6lNFeTgMKth2xYKnlIC0o8cO8lubqcE"})
    Call<ResetResponse> passwordreset(
            @Body @NonNull ResetResponse passreset);

    @NonNull
    @POST("tools/userdetails.php?func=edit")
    @Headers({"Content-Type: application/json",
            "Accept: application/json"
    })
    Call<EditResponse> editdetails(
            @Header("X-USER-KEY") @NonNull String xUserKey,
            @Body @NonNull EditResponse editdetails

    );

    @NonNull
    @GET("tools/businesses.php?method=get")
    Call<WerecommendResponse> werecommend(@Query("cid") int cid);

    @NonNull
    @POST("tools/questions.php?func=create")
    Call<QuestionsResponse> questions(
            @Header("X-USER-KEY") @NonNull String xUserKey,
            @Body @NonNull QuestionsResponse questionsRequest

    );


}

