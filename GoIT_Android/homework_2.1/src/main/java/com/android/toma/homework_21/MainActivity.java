package com.android.toma.homework_21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText day;
    private Spinner month;
    private EditText year;
    private Month selectedMonth;
    Month[] months = Month.values();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        day = (EditText) findViewById(R.id.editDay);
        month = (Spinner) findViewById(R.id.spinnerMonth);
        year = (EditText) findViewById(R.id.editYear);

        ArrayAdapter<Month> adapterMonth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Month.values());
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        month.setAdapter(adapterMonth);
    }
}
