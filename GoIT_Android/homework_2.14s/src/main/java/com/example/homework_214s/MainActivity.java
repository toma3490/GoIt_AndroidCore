package com.example.homework_214s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private Button generateBtn1;
    private Button generateBtn2;
    private Button generateBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        string1 = (TextView) findViewById(R.id.string1);
        string2 = (TextView) findViewById(R.id.string2);
        string3 = (TextView) findViewById(R.id.string3);
        generateBtn1 = (Button) findViewById(R.id.button1);
        generateBtn2 = (Button) findViewById(R.id.button2);
        generateBtn3 = (Button) findViewById(R.id.button3);
        lengthSeekBar = (SeekBar) findViewById(R.id.length);
        stringLength = (TextView) findViewById(R.id.stringLength);
        editChar = (EditText) findViewById(R.id.editText);

        lengthSeekBar.setOnSeekBarChangeListener(this);

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

//    textView = (TextView) findViewById(R.id.textView);
//    button1 = (Button) findViewById(R.id.button1);
//    button2 = (Button) findViewById(R.id.button2);
//    button3 = (Button) findViewById(R.id.button3);
//
//    View.OnClickListener onClickListener = new View.OnClickListener(){
//        @Override
//        public void onClick(View view){
//            switch (view.getId()){
//                case R.id.button1:
//                    textView.setText(R.string.text1);
//                    button1.setText(R.string.button1);
//                    break;
//                case R.id.button2:
//                    textView.setText(R.string.text2);
//                    button2.setText(R.string.button2);
//                    break;
//                case R.id.button3:
//                    textView.setText(R.string.text3);
//                    button3.setText(R.string.button3);
//                    break;
//            }
//        }
//    };
//
//    button1.setOnClickListener(onClickListener);
//    button2.setOnClickListener(onClickListener);
//    button3.setOnClickListener(onClickListener);
//
//    textView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            textView.setText(R.string.text4);
//            button1.setText(R.string.textButton);
//            button2.setText(R.string.textButton);
//            button3.setText(R.string.textButton);
//
//        }
//    });
}

