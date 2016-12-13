package com.example.homework_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<String> listString;
    private ArrayList<Integer> listInteger;

    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<String> listString, ArrayList<Integer> listInteger) {
        this.listString = listString;
        this.listInteger = listInteger;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listString.size();
    }

    @Override
    public Object getItem(int i) {
        return listString.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = view;
        if (rootView == null) {
            rootView = layoutInflater.inflate(R.layout.item_layout, viewGroup, false);
        }

        TextView key = (TextView) rootView.findViewById(R.id.key);
        TextView value = (TextView) rootView.findViewById(R.id.value);

        key.setText(listString.get(i));
        value.setText(String.valueOf(listInteger.get(i)));

        return rootView;
    }
}
