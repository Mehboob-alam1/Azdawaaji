package com.mehboob.azdawaaj.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mehboob.azdawaaj.R;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private String[] items;
    private LayoutInflater inflater;

    public GridAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;

        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.grid_layout,null);
        TextView tv= convertView.findViewById(R.id.itemSelected);
        tv.setText(items[position]);

        return convertView;
    }
}
