package com.android.toma.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("Вовочка, обнимать буду! И целовать сейчас!");

        Button button = (Button) findViewById(R.id.button);
        button.setText("Vova любимка моя");



    }
}
