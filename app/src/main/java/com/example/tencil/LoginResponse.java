package com.example.tencil;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("uid")
    private String email;
    @SerializedName("pwd")
    private String password;
    private String auth;

    //response variables
    @SerializedName("passwordMatches")
    private Boolean passMatch;

    public LoginResponse(){
        //empty default constructor
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

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

    public Boolean getPassMatch() {
        return passMatch;
    }

    public void setPassMatch(Boolean passMatch) {
        this.passMatch = passMatch;
    }
}
