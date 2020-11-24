package com.example.tencil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.R.layout.simple_spinner_item;

public class questions extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questions );

        Spinner spinner = findViewById ( R.id.spinner1 );
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource ( this, R.array.location, simple_spinner_item );
        adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter ( adapter );
        spinner.setOnItemSelectedListener ( (AdapterView.OnItemSelectedListener) this );
    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition (position).toString ();
        Toast.makeText (parent.getContext (), text, Toast.LENGTH_SHORT).show();
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
}