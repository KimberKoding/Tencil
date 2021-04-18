package uk.co.tencil;

import com.google.gson.annotations.SerializedName;

public class PasswordResponse {
    @SerializedName("uid")
    private String email;

    public PasswordResponse() {
        //Default constructor
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
