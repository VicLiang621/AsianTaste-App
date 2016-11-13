package com.example.victor.melt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by Victor on 10/15/2016.
 */
public class CustomAdapter2 extends BaseAdapter implements ListAdapter{

    Context context;
    Orders order;


    public CustomAdapter2(Context context, Orders order){
        this.context = context;
        this.order = order;
    }
    @Override
    public int getCount() {
        return order.getOrder_names_list().size();
    }

    @Override
    public Object getItem(int position) {
        return order.getOrder_names_list().get(position);

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
            view = inflater.inflate(R.layout.customlistview2,null);
        }

        final TextView order_name = (TextView)view.findViewById(R.id.confirm_order);
        order_name.setText(order.getOrder_names_list().get(position));

        final TextView quantity = (TextView)view.findViewById(R.id.quantity_text2);
        quantity.setText(String.valueOf(order.getQuantity_list().get(position)));

        final TextView price = (TextView)view.findViewById(R.id.priceText);
        price.setText(order.getPrice_list().get(position));
        return view;
    }
}
