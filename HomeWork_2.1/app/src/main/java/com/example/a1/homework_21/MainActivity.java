package com.example.a1.homework_21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a1.homework_21.enums.Month;

public class MainActivity extends AppCompatActivity {
    private Spinner day;
    private Spinner month;
    private Spinner year;
    private Month selectedMonth;
    Month[] months = Month.values();

    String[] data = {"one", "two", "three", "four", "five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        day = (Spinner) findViewById(R.id.spinnerDay);
        month = (Spinner) findViewById(R.id.spinnerMonth);
        year = (Spinner) findViewById(R.id.spinnerYear);

        ArrayAdapter<String> adapterDay = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<Month> adapterMonth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Month.values());
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        day.setAdapter(adapterDay);
        month.setAdapter(adapterMonth);

//        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                // показываем позиция нажатого элемента
//                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//            }
//        });


//        month.setOnItemClickListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                for (Month month : months) {
//                    if (month.ordinal() == position) {
//                        selectedMonth = month;
//                    }
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

        int quantityDaysInMonts = selectedMonth.getQuantityDays();
    }
}
