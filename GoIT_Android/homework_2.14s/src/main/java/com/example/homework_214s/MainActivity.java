package com.example.homework_214s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Spinner length = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> lengthAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.length));
        lengthAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        length.setAdapter(lengthAdapter);
    }
}
