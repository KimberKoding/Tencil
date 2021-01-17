package com.example.tencil;

public class LoginRequest {
    private String email;
    private String password;
    private String authmode;

    public String getAuthmode() {
        return authmode;
    }

    public void setAuthmode(String authmode) {
        this.authmode = authmode;
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
}
