package com.example.tencil;

import com.google.gson.annotations.SerializedName;

public class ActivateResponse {
    @SerializedName("uid")
    private String email;
    @SerializedName("code")
    private String activaitoncode;

    public ActivateResponse() {
        //Default constructor
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivaitoncode() {
        return activaitoncode;
    }

    public void setActivaitoncode(String activaitoncode) {
        this.activaitoncode = activaitoncode;
    }
}
