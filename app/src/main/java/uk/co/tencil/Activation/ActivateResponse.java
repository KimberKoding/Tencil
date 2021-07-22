package uk.co.tencil.Activation;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class ActivateResponse {
    @SerializedName("uid")
    private String email;
    @SerializedName("code")
    private String activation;

    public ActivateResponse() {
        //Default constructor
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getActivation() {
        return activation;
    }

    public void setActivation(@NonNull String activation) {
        this.activation = activation;
    }
}
