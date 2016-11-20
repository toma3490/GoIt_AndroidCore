package com.android.toma.homework_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class Main extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView6;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    int counter = 0;
    float result = 0;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView2);
        textView2 = (TextView) findViewById(R.id.textView4);
        textView6 = (TextView) findViewById(R.id.textView6);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                counter++;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (counter > 12){
                    result = Float.parseFloat(editText1.getText().toString()) * 2;
                    textView1.setText("" + result);
                }
                if (counter == 23){
                    textView2.setText("I love GoIT so much");
                }
            }
        });

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText3.getText().equals("")){
                    textView6.setText("");
                }
                else{
                    number = Integer.parseInt(editText3.getText().toString());
                    textView6.setText("" + fib(number));
                }
            }
        });
    }

    public void mult(View view) {
        result = Float.parseFloat(editText1.getText().toString()) * 3;
        textView1.setText("" + result);
    }

//    private void checkArg(int number){
//        if (number
//        }
//    }

    private static long fib(int number){
        if (number <= 1) return number;
        else return fib(number - 1) + fib(number - 2);
    }
}
