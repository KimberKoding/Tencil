package uk.co.tencil;

import com.google.gson.annotations.SerializedName;

public class ActivateResponse {
    @SerializedName("uid")
    private String email;
    @SerializedName("code")
    private String activation;

    public ActivateResponse() {
        //Default constructor
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }
}
