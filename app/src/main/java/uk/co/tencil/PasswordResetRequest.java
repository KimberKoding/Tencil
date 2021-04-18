package uk.co.tencil;

public class PasswordResetRequest {
    private String email;
    private String activationCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


