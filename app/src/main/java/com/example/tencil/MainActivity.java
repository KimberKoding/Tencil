package com.example.tencil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView greetingLabel;
    private EditText textInputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingLabel = findViewById(R.id.greeting);
        textInputField = findViewById(R.id.textInput);
    }

    public void changeGreeting(View view) {
        String greeting = textInputField.getText().toString();
        //Set the text
        greetingLabel.setText(greeting);
    }
}