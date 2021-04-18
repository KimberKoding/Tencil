package uk.co.tencil;

import com.google.gson.annotations.SerializedName;

public class ResetResponse {
    @SerializedName("uid")
    private String email;
    @SerializedName("pwd")
    private String password;
    @SerializedName("code")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


