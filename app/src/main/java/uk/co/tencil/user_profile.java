package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        String result = "";

        for (String key : logininfo.keySet ()) {
            result += logininfo.get ( key ) + "\n";
        }
        System.out.println ( logininfo.get ( "fname" ) );
        nameuser.setText ( logininfo.getString ( "fname" ) );
        emailuser.setText ( logininfo.getString ( "email" ) );
        name.setText ( logininfo.getString ( "fname" ) );
        email.setText ( logininfo.getString ( "email" ) );


        buttonupdate.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
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
        editdetails.setUserApikey ( logininfo.getString ( "userapikey" ) );
        System.out.println ( logininfo.getString ( "userapikey" ) );


        Call<EditResponse> editResponseCall = APiClient.getUserService ().editdetails ( editdetails );
        editResponseCall.enqueue ( new Callback<EditResponse> () {
            @Override
            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {
                if (response.isSuccessful ()) {
                    EditResponse editResponse1 = response.body ();
                    String email = editResponse1.getEmail ();
                    String name = editResponse1.getName ();
                    String password = editResponse1.getPassword ();
                    String userApiKey = editResponse1.getUserApikey ();

                    Toast.makeText ( user_profile.this, "Thank you for changing your details", Toast.LENGTH_SHORT ).show ();
                } else {
                    System.out.println ( response + " Error" );
                    Toast.makeText ( user_profile.this, "Error, see logs!", Toast.LENGTH_SHORT ).show ();
                }
            }

            @Override
            public void onFailure(Call<EditResponse> call, Throwable t) {
                System.out.println ( t + " Error" );
            }
        } );


    }


}

