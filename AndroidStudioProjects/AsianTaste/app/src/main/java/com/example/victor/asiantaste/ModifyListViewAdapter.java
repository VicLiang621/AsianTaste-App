package com.example.victor.asiantaste;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Victor on 9/25/2016.
 */
class ModifyListViewAdapter extends BaseAdapter implements ListAdapter {
    private Context context;
    private OrderClass order;
    private ArrayList<String> modify_list = new ArrayList<String>();
    public ModifyListViewAdapter(OrderClass orderClass, Context context){
        this.order = orderClass;
        this.context = context;
        this.modify_list = order.getModifyList();
    }

    @Override
    public int getCount() {
        return modify_list.size();
    }

    @Override
    public Object getItem(int position) {
        return modify_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custommodifylistview,null);
        }

        TextView modification_text = (TextView)view.findViewById(R.id.modifyText);
        Log.d("popup", modify_list.get(position));
        modification_text.setText(modify_list.get(position));
        return view;
    }
}
