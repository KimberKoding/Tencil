package uk.co.tencil.User;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.tencil.API.APiClient;
import uk.co.tencil.R;
import uk.co.tencil.User.EditUser.EditResponse;

public class user_profile extends AppCompatActivity {
    Button buttonupdate;
    EditText name, email, password;
    TextView nameuser, emailuser;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.user_profile );
        buttonupdate = findViewById ( R.id.buttonupdate );
        name = findViewById ( R.id.name );
        email = findViewById ( R.id.email );
        password = findViewById ( R.id.password );
        nameuser = findViewById ( R.id.nameuser );
        emailuser = findViewById ( R.id.emailuser );
        Intent receiveIntent = getIntent ();
        Bundle logininfo = receiveIntent.getBundleExtra ( "logininfo" );
        if (logininfo == null) {

        }
        System.out.println ( logininfo.get ( "fname" ) );
        nameuser.setText ( logininfo.getString ( "fname" ) );
        emailuser.setText ( logininfo.getString ( "email" ) );
        name.setText ( logininfo.getString ( "fname" ) );
        email.setText ( logininfo.getString ( "email" ) );


        buttonupdate.setOnClickListener ( v -> {
            if (TextUtils.isEmpty ( name.getText ().toString () ) ||
                    TextUtils.isEmpty ( password.getText ().toString () )) {
                Toast.makeText ( user_profile.this,
                        "Name & Password must not be empty.", Toast.LENGTH_SHORT ).show ();

            } else {

                EditResponse editdetails = new EditResponse ();
                editdetails.setEmail ( email.getText ().toString () );
                editdetails.setName ( name.getText ().toString () );
                editdetails.setPassword ( password.getText ().toString () );
                editdetails ( editdetails );
            }


        } );


    }

    private void editdetails(EditResponse editdetails) {
        Intent receiveIntent = getIntent ();
        Bundle logininfo = receiveIntent.getBundleExtra ( "logininfo" );
        EditResponse editResponse = new EditResponse ();
        editdetails.setEmail ( email.getText ().toString () );
        editdetails.setName ( name.getText ().toString () );
        editdetails.setPassword ( password.getText ().toString () );
        editResponse.setUserApikey ( logininfo.getString ( "userapikey" ) );
        System.out.println ( logininfo.getString ( "userapikey" ) );


        Call<EditResponse> editResponseCall = APiClient.getUserService ().editdetails
                ( logininfo.getString ( "userapikey" ), editdetails );
        editResponseCall.enqueue ( new Callback<EditResponse> () {
            @Override
            public void onResponse(@NotNull Call<EditResponse> call,
                                   @NotNull Response<EditResponse> response) {
                if (response.isSuccessful ()) {
                    EditResponse editResponse1 = response.body ();
                    assert editResponse1 != null;


                    Toast.makeText ( user_profile.this,
                            "Thank you for changing your details", Toast.LENGTH_SHORT ).show ();
                } else {
                    System.out.println ( response + " Error" );
                    Toast.makeText
                            ( user_profile.this,
                                    "Error, see logs!", Toast.LENGTH_SHORT ).show ();
                }
            }

            @Override
            public void onFailure(@NotNull Call<EditResponse> call, @NotNull Throwable t) {
                System.out.println ( t + " Error" );
                Toast.makeText (
                        user_profile.this,
                        "Thank you for changing your details, Please exit the page",
                        Toast.LENGTH_SHORT ).show ();
            }
        } );


    }


}

