package com.android.toma.homework_23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editA;
    private EditText editB;
    private EditText editC;
    private EditText editX;
    private RadioButton radioX;
    private RadioButton radioY;
    private Button count;
    private RadioGroup radioGroup;
    private TextView result;
    private TextView result1;

    private double resY;
    private List resX;

    Parabola parabola = new Parabola();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = (EditText) findViewById(R.id.editA);
        editB = (EditText) findViewById(R.id.editB);
        editC = (EditText) findViewById(R.id.editC);
        editX = (EditText) findViewById(R.id.editX);
        radioX = (RadioButton) findViewById(R.id.x);
        radioY = (RadioButton) findViewById(R.id.y);
        count = (Button) findViewById(R.id.count);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        result = (TextView) findViewById(R.id.finalData);
        result1 = (TextView) findViewById(R.id.finalData2);

        editA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editA.getText().toString().equals("0")){
                    Toast.makeText(MainActivity.this, R.string.warning, Toast.LENGTH_SHORT).show();
                    editA.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editA.length() > 0) {
                    double valueA = Double.parseDouble(editA.getText().toString());
                    parabola.setA(valueA);
                }else {
                    result.setText("");
                    result1.setText("");
                    parabola.setA(0);
                }
            }
        });

        editB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editB.length() > 0) {
                    double valueB = Double.parseDouble(editB.getText().toString());
                    parabola.setB(valueB);
                }else {
                    result.setText("");
                    result1.setText("");
                    parabola.setB(0);
                }
            }
        });

        editC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editC.length() > 0) {
                    double valueC = Double.parseDouble(editC.getText().toString());
                    parabola.setC(valueC);
                }else {
                    result.setText("");
                    result1.setText("");
                    parabola.setC(0);
                }
            }
        });

        editX.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editX.length() > 0) {
                    double value = Double.parseDouble(editX.getText().toString());
                    if (radioGroup.getCheckedRadioButtonId() == R.id.x){
                        parabola.setX(value);
                    }else{
                        parabola.setY(value);
                    }
                }else {
                    result.setText("");
                    result1.setText("");
                    parabola.setX(0);
                    parabola.setY(0);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                switch (checkedID){
                    case R.id.x:
                        count.setText(R.string.countY);
                        break;
                    case R.id.y:
                        count.setText(R.string.countX);
                        break;
                }
            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup.getCheckedRadioButtonId() == R.id.x){
                    resY = parabola.countY();
                    result.setText(String.valueOf(resY));
                    result1.setText("");
                }else{
                    try{
                        resX = parabola.countXRoots();
                        result.setText(String.valueOf(resX.get(0)));
                        result1.setText(String.valueOf(resX.get(1)));

                    }catch (IllegalArgumentException e){
                        result.setText(e.getMessage());
                    }
                }

            }
        });
    }
}
