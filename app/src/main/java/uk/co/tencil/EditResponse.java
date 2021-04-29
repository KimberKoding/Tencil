package uk.co.tencil;

import com.google.gson.annotations.SerializedName;

public class EditResponse {
    @SerializedName("userApiKey")
    String userApikey;
    @SerializedName("e")
    private String email;
    @SerializedName("newname")
    private String name;
    @SerializedName("newpw")
    private String password;

    public String getUserApikey() {
        return userApikey;
    }

    public void setUserApikey(String userApikey) {
        this.userApikey = userApikey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
