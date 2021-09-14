package uk.co.tencil.Activation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ActivateRequest {
    private String email;
    private String activationCode;

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setActivationCode(@NonNull String activationCode) {
        this.activationCode = activationCode;
    }

    @Nullable
    public String getActivationCode() {
        return activationCode;
    }
}
