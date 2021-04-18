package uk.co.tencil;

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

public class passwordReset extends AppCompatActivity {
    Button reset_password_next_btn;
    EditText email, password, code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.passwordreset );
        reset_password_next_btn = findViewById ( R.id.reset_password_next_btn );
        email = findViewById ( R.id.email );
        password = findViewById ( R.id.password );
        code = findViewById ( R.id.activaitoncode );

        reset_password_next_btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty ( email.getText ().toString () ) || TextUtils.isEmpty
                        ( password.getText ().toString () ) || TextUtils.isEmpty ( code.getText ().toString () )) {
                    Toast.makeText ( passwordReset.this,
                            "Email, Password & Activation code is Required",
                            Toast.LENGTH_SHORT ).show ();
                } else {
                    ResetResponse passreset = new ResetResponse ();
                    passreset.setEmail ( email.getText ().toString () );
                    passreset.setPassword ( password.getText ().toString () );
                    passreset.setCode ( code.getText ().toString () );
                    passwordreset ( passreset );
                }
            }
        } );
    }

    private void passwordreset(ResetResponse passreset) {
        ResetRequest resetRequest = new ResetRequest ();
        resetRequest.setEmail ( email.getText ().toString () );
        resetRequest.setPassword ( password.getText ().toString () );
        resetRequest.setCode ( code.getText ().toString () );

        Call<ResetResponse> resetResponseCall = APiClient.getUserService ().passwordreset ( passreset );
        resetResponseCall.enqueue ( new Callback<ResetResponse> () {
            @Override
            public void onResponse(Call<ResetResponse> call, Response<ResetResponse> response) {
                if (response.isSuccessful ()) {
                    Toast.makeText ( passwordReset.this, "Response Sent",
                            Toast.LENGTH_SHORT ).show ();
                    Intent intent = new Intent ( passwordReset.this, ForgetPasswordSuccessMessage.class );
                    startActivity ( intent );

                    System.out.println ( response );

                } else {
                    System.out.println ( response + " Error" );
                    Toast.makeText ( passwordReset.this, "Oops", Toast.LENGTH_SHORT ).show ();
                }
            }

            @Override
            public void onFailure(Call<ResetResponse> call, Throwable t) {
                Toast.makeText ( passwordReset.this, "Response Sent",
                        Toast.LENGTH_SHORT ).show ();
                Intent intent = new Intent ( passwordReset.this,
                        ForgetPasswordSuccessMessage.class );
                startActivity ( intent );

                System.out.println ( t );
            }
        } );
    }


    public void callBackScreenFromForgetPassword(View view) {
    }

    public void passwordnext(View view) {

    }
}
