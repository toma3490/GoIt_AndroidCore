package com.example.homework_214s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView string1;
    private TextView string2;
    private TextView string3;
    private TextView stringLength;
    private SeekBar lengthSeekBar;
    private EditText editChar;
    private TextView textRes;

    StringUtils stringUtils = new StringUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        string1 = (TextView) findViewById(R.id.string1);
        string2 = (TextView) findViewById(R.id.string2);
        string3 = (TextView) findViewById(R.id.string3);
        textRes = (TextView) findViewById(R.id.textResult);
        Button generateBtn1 = (Button) findViewById(R.id.button1);
        Button generateBtn2 = (Button) findViewById(R.id.button2);
        Button generateBtn3 = (Button) findViewById(R.id.button3);
        lengthSeekBar = (SeekBar) findViewById(R.id.length);
        stringLength = (TextView) findViewById(R.id.stringLength);
        editChar = (EditText) findViewById(R.id.editText);

        lengthSeekBar.setOnSeekBarChangeListener(this);

        generateBtn1.setOnClickListener(onClickListener);
        generateBtn2.setOnClickListener(onClickListener);
        generateBtn3.setOnClickListener(onClickListener);



        editChar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editChar.length() > 0) {
                    StringUtils.clearList();
                    StringUtils.toCharList(string1.getText().toString());
                    StringUtils.toCharList(string2.getText().toString());
                    StringUtils.toCharList(string3.getText().toString());
                    char c = editChar.getText().charAt(0);
                    textRes.setText(String.valueOf(stringUtils.getQuantityOfMatches(c)));
                }

            }
        });

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

        stringLength.setText(String.valueOf(progress + 1) + " symbols");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            String text = stringUtils.generateRandomString(lengthSeekBar.getProgress() + 1);
            switch (view.getId()){
                case R.id.button1:
                    string1.setText(text);
                    break;
                case R.id.button2:
                    string2.setText(text);
                    break;
                case R.id.button3:
                    string3.setText(text);
                    break;
            }
        }
    };
}

