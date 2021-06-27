package uk.co.tencil.User.ForogttenPassword;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.tencil.API.APiClient;
import uk.co.tencil.R;
import uk.co.tencil.User.Passwordreset.PasswordResetRequest;
import uk.co.tencil.User.Passwordreset.PasswordResponse;
import uk.co.tencil.User.Passwordreset.passwordReset;

public class ForgetPassword extends AppCompatActivity {
    Button forget_password_next_btn;
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_forget_password );
        forget_password_next_btn = findViewById ( R.id.forget_password_next_btn );
        email = findViewById ( R.id.emailinput );

        forget_password_next_btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty ( email.getText ().toString () )) {
                    Toast.makeText ( ForgetPassword.this, "Email Required", Toast.LENGTH_SHORT ).show ();
                } else {
                    PasswordResponse resetPass = new PasswordResponse ();
                    resetPass.setEmail ( email.getText ().toString () );
                    resetPassword ( resetPass );
                }
            }
        } );


    }

    private void resetPassword(PasswordResponse resetPass) {
        PasswordResetRequest passwordResetRequest = new PasswordResetRequest ();
        passwordResetRequest.setEmail ( email.getText ().toString () );

        Call<PasswordResponse> passwordResponseCall = APiClient.getUserService ().resetpassword ( resetPass );
        passwordResponseCall.enqueue ( new Callback<PasswordResponse> () {
            @Override
            public void onResponse(Call<PasswordResponse> call, Response<PasswordResponse> response) {
                if (response.isSuccessful ()) {
                    Toast.makeText ( ForgetPassword.this, "Response Sent", Toast.LENGTH_SHORT ).show ();
                    Intent intent = new Intent ( ForgetPassword.this, passwordReset.class );
                    startActivity ( intent );

                    System.out.println ( response );


                } else {
                    System.out.println ( response + " Error" );
                    Toast.makeText ( ForgetPassword.this,
                            "Password reset request was not sent. Please Try Again",
                            Toast.LENGTH_SHORT ).show ();
                }
            }

            @Override
            public void onFailure(Call<PasswordResponse> call, Throwable t) {
                System.out.println ( t + " Error" );
                Toast.makeText ( ForgetPassword.this, "Check Emails For an Activation Code", Toast.LENGTH_SHORT ).show ();
                Intent intent = new Intent ( ForgetPassword.this, passwordReset.class );
                startActivity ( intent );
            }
        } );
    }

    public void callBackScreenFromForgetPassword(View view) {
    }
}
