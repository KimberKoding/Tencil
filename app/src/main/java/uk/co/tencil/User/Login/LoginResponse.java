package uk.co.tencil.User.Login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("uid")
    private String email;
    @SerializedName("pwd")
    private String password;
    private String auth;
    @SerializedName("fname")
    private String fname;
    @SerializedName("userApiKey")
    private String userApiKey;

    public String getFname() {
        return fname;
    }

    //response variables
    @SerializedName("passwordMatches")
    private Boolean passMatch;
    @SerializedName("userActive")
    private Boolean userActive;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUserApiKey() {
        return userApiKey;
    }

    public void setUserApiKey(String userApiKey) {
        this.userApiKey = userApiKey;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    public LoginResponse() {
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
