package uk.co.tencil;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("uid")
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
