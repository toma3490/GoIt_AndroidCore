package com.android.toma.homework_224s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView string1;
    private TextView string2;
    private TextView string3;
    private TextView string4;

    StringUtils stringUtils = new StringUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        string1 = (TextView) findViewById(R.id.string1);
        string2 = (TextView) findViewById(R.id.string2);
        string3 = (TextView) findViewById(R.id.string3);
        string4 = (TextView) findViewById(R.id.string4);

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.button1:
                    string1.setText(stringUtils.transformToUpper(String.valueOf(editText1.getText())));
                    break;
                case R.id.button2:
                    string2.setText(stringUtils.transformToUpper(String.valueOf(editText2.getText())));
                    break;
                case R.id.button3:
                    string3.setText(stringUtils.transformToUpper(String.valueOf(editText3.getText())));
                    break;
                case R.id.button4:
                    string4.setText(stringUtils.transformToUpper(String.valueOf(editText4.getText())));
                    break;
            }
        }
    };
}
