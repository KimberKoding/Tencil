package com.example.tencil;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
    @SerializedName("data")
    public String data;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
