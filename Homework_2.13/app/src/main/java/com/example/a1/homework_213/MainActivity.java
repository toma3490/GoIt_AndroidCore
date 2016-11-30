package com.example.a1.homework_213;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editSide;
    private TextView area;
    private TextView perimeter;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editSide = (EditText) findViewById(R.id.editSide);
        area = (TextView) findViewById(R.id.area);
        perimeter = (TextView) findViewById(R.id.perimeter);
        info = (TextView) findViewById(R.id.toString);

        editSide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editSide.getText().toString().equals("-")){
                    Toast.makeText(MainActivity.this, R.string.warning, Toast.LENGTH_SHORT).show();
                    editSide.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editSide.length() > 0) {
                    Square square = new Square();
                    int valueSide = Integer.parseInt(editSide.getText().toString());
                    square.setSide(valueSide);
                    area.setText(String.valueOf(square.getArea()));
                    perimeter.setText(String.valueOf(square.getPerimeter()));
                    info.setText(square.toString());
                }
            }
        });

    }

}
