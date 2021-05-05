package uk.co.tencil.User.Resend;

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
import uk.co.tencil.Activation.Activate;
import uk.co.tencil.R;

public class resend extends AppCompatActivity {
    EditText activateyouremail;
    Button resendemail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.resend );
        activateyouremail = findViewById ( R.id.activateyouremail );
        resendemail = findViewById ( R.id.resendemail );

        resendemail.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty ( activateyouremail.getText ().toString () )) {
                    Toast.makeText ( resend.this, "Email is needed for Activation code", Toast.LENGTH_SHORT ).show ();

                } else {
                    // Proceed to Activate
                    ResendResponse resendMe = new ResendResponse ();
                    resendMe.setEmail ( activateyouremail.getText ().toString () );
                    activate ( resendMe );
                    startActivity ( new Intent ( resend.this, Activate.class ) );

                }
            }
        } );
    }

    private void activate(ResendResponse resendMe) {
        ResendRequest resendRequest = new ResendRequest ();
        resendRequest.setEmail ( activateyouremail.getText ().toString () );
        Call<ResendRequest> resendRequestCall = APiClient.getUserService ().resendemail ( resendMe );
        resendRequestCall.enqueue ( new Callback<ResendRequest> () {
            @Override
            public void onResponse(Call<ResendRequest> call, Response<ResendRequest> response) {
                if (response.isSuccessful ()) {
                    ResendRequest resendResponse = response.body ();
                    Toast.makeText ( resend.this, "Code has Been Sent", Toast.LENGTH_SHORT ).show ();
                } else {
                    Toast.makeText ( resend.this, "No Code is being sent ", Toast.LENGTH_SHORT ).show ();
                }
            }

            @Override
            public void onFailure(Call<ResendRequest> call, Throwable t) {

            }
        } );
    }

    public void activate_dash(View view) {
    }

}
