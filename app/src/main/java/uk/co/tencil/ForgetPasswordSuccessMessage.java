package uk.co.tencil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPasswordSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_forget_password_success_message );
    }

    public void backToLogin(View view) {
        Intent intent = new Intent ( this, login.class );
        startActivity ( intent );
        return;
    }
}