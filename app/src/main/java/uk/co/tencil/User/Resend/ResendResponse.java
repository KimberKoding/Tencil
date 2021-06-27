package uk.co.tencil.User.Resend;

import com.google.gson.annotations.SerializedName;

public class ResendResponse {
    @SerializedName("uid")
    private String email;

    public ResendResponse() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
