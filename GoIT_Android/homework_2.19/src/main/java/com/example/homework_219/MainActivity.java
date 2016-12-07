package com.example.homework_219;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editProduct;
    private EditText editManufacturer;
    private EditText editCustomer;
    private EditText editQuantity;
    private EditText editPrice;
    private TextView totalPrice;
    private TextView info;
    private Button infoBtn;
    Sales sales = new Sales();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editProduct = (EditText) findViewById(R.id.editProduct);
        editManufacturer = (EditText) findViewById(R.id.editManufacturer);
        editCustomer = (EditText) findViewById(R.id.editCustomer);
        editQuantity = (EditText) findViewById(R.id.editQuantity);
        editPrice = (EditText) findViewById(R.id.editPrice);
        totalPrice = (TextView) findViewById(R.id.totalPriceValue);
        info = (TextView) findViewById(R.id.info);
        infoBtn = (Button) findViewById(R.id.buttonInfo);

        editQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editQuantity.getText().toString().equals("-")){
                    Toast.makeText(MainActivity.this, R.string.warning, Toast.LENGTH_SHORT).show();
                    editQuantity.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editQuantity.length() > 0){
                    int quantity = Integer.parseInt(editQuantity.getText().toString());
                    sales.setQuantity(quantity);
                    totalPrice.setText(String.valueOf(sales.getTotalPrice()));
                }
            }
        });

        editPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPrice.getText().toString().equals("-")){
                    Toast.makeText(MainActivity.this, R.string.warning, Toast.LENGTH_SHORT).show();
                    editPrice.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editPrice.length() > 0){
                    int price =  Integer.parseInt(editPrice.getText().toString());
                    sales.setPrice(price);
                    totalPrice.setText(String.valueOf(sales.getTotalPrice()));
                }
            }
        });



        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sales.setProduct(String.valueOf(editProduct.getText()));
                sales.setManufacturer(String.valueOf(editManufacturer.getText()));
                sales.setCustomer(String.valueOf(editCustomer.getText()));

                info.setText(sales.toString());
            }
        });
    }
}
