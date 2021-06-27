package uk.co.tencil.User.Login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoginRequest {
    private String email;
    private String password;
    private String authmode;

    @Nullable
    public String getAuthmode() {
        return authmode;
    }

    public void setAuthmode(String authmode) {
        this.authmode = authmode;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
