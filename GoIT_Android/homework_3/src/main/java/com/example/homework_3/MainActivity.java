package com.example.homework_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    private ArrayList<String> listKey;
    private ArrayList<Integer> listValue;

    private ListView listView;
    private MyAdapter myAdapter;
//    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listKey = new ArrayList<>();
        listValue = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_view);
        myAdapter = new MyAdapter(MainActivity.this, listKey, listValue);
        listView.setAdapter(myAdapter);

        editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                if (input.equals("")) {
                    return;
                }
                if (listKey.contains(input)) {
                    int index = listKey.indexOf(input);
                    int counter = listValue.get(index);
                    listValue.set(index, ++counter);
                } else {
                    listKey.add(input);
                    listValue.add(1);
                }
                editText.setText("");
                myAdapter.notifyDataSetChanged();
            }
        });

//        webView = (WebView) findViewById(R.id.web_view);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://google.com");

    }
}
