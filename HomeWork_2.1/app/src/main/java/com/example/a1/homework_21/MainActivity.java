package com.example.a1.homework_21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    EditText editBill;
    SeekBar seekBar;
    TextView percent;
    TextView percentValue;
    TextView totalSum;
    float tips = 0;
    float money;

    final String LOG_TAG = "Log";
    final String KEY_TIPS = "TIPS";
    final String KEY_MONEY = "MONEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");


        editBill = (EditText) findViewById(R.id.editBill);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        percent = (TextView) findViewById(R.id.percent);
        percentValue = (TextView) findViewById(R.id.percentValue);
        totalSum = (TextView) findViewById(R.id.totalSum);

        seekBar.setOnSeekBarChangeListener(this);
//        money = getBill(editBill);

    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tips = savedInstanceState.getFloat("KEY_TIPS");
        money = savedInstanceState.getFloat("KEY_MONEY");
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume ");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(KEY_TIPS, tips);
        outState.putFloat(KEY_MONEY, money);
        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

        percent.setText(String.valueOf(progress) + "%");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int tipsPercent = Integer.parseInt(String.valueOf(seekBar.getProgress()));
        money = getBill(editBill);
        tips = money * tipsPercent / 100;
        percentValue.setText(String.format("%.2f", tips));
        totalSum.setText(String.format("%.2f", tips + money));
    }

    private float getBill (EditText editBill){
        float bill;
        if (editBill.length() == 0){
            return 0;
        }else {
            bill = Float.parseFloat(String.valueOf(editBill.getText()));
            if (bill < 0){
                Toast.makeText(getApplicationContext(), "Your bill is incorrect!", Toast.LENGTH_SHORT).show();
                return 0;
            }
        }
        return bill;
    }
}
