package com.example.homework_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HashSet<Item> hashSet = new HashSet<>();

    private EditText editText;
    private Button add;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText = (EditText) findViewById(R.id.editText);
        add = (Button) findViewById(R.id.add);
        final ListView listView = (ListView) findViewById(R.id.listView1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item = new Item(editText.getText().toString());
                hashSet.add(item);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
        ArrayList<Item> list = new ArrayList<>(hashSet);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

    }
}
