package com.example.tencil;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
    @SerializedName("uid")
    private String email;
    @SerializedName("pwd")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
