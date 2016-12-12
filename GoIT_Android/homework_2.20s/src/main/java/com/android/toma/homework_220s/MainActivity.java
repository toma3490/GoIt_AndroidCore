package com.android.toma.homework_220s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText string1;
    private EditText string2;
    private EditText string3;
    private EditText string4;
    private Button delDuplicates;
    private TextView textRes;
    List<String> list = new ArrayList<>(4);

    StringUtils stringUtils = new StringUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        string1 = (EditText) findViewById(R.id.string1);
        string2 = (EditText) findViewById(R.id.string2);
        string3 = (EditText) findViewById(R.id.string3);
        string4 = (EditText) findViewById(R.id.string4);
        delDuplicates = (Button) findViewById(R.id.button);
        textRes = (TextView) findViewById(R.id.textRes);

        delDuplicates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (string1.length() > 0 && string2.length() > 0 && string3.length() > 0 && string4.length() > 0){
                    list.add(String.valueOf(string1.getText()));
                    list.add(String.valueOf(string2.getText()));
                    list.add(String.valueOf(string3.getText()));
                    list.add(String.valueOf(string4.getText()));
                    textRes.setText(stringUtils.deleteEquals(list).toString());
                    StringUtils.clearList(list);
                }else{
                    Toast.makeText(MainActivity.this, R.string.warning, Toast.LENGTH_SHORT).show();
                    textRes.setText("");
                }
            }
        });

    }

}
