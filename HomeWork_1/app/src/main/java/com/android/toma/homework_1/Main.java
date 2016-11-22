package com.android.toma.homework_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class Main extends AppCompatActivity {

    private TextView textView1;
    private TextView textView3;
    private EditText editText1;
    private EditText editText2;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView3 = (TextView) findViewById(R.id.textView3);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText1.getText().toString().length() > 12){
                    increaseCounter();
                }
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = 0;
                if(editText2.length() > 0){
                    number = Integer.parseInt(editText2.getText().toString());
                }
                textView3.setText("" + fib(number));
            }
        });
    }

    public void increase(View view){
        increaseCounter();
    }

    private void increaseCounter() {
        counter++;
        if (counter >= 23){
            textView1.setText("I love GoIT so much");
            Toast.makeText(getApplicationContext(), "Press Reset", Toast.LENGTH_SHORT).show();
            return;
        }
        textView1.setText("" + counter);
    }

    private long fib(int number){
        if (number < 0 || number >= 25){
            Toast.makeText(getApplicationContext(), "Your number is incorrect!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        if (number <= 1) return number;
        else return fib(number - 1) + fib(number - 2);
    }

    public void reset (View view){
        textView1.setText(String.valueOf(counter = 0));
        editText1.setText("");
    }
}
