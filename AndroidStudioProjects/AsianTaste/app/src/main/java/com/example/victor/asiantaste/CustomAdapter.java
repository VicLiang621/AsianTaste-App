package com.example.victor.asiantaste;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Victor on 9/11/2016.
 */
public class CustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String>order_name_list = new ArrayList<String>();
    private Context context;
    private ArrayList<Integer> quantity_list = new ArrayList<Integer>();
    private ArrayList<String> price_list = new ArrayList<>();
    private HashMap<String, String> menu = new HashMap<>();
    private OrderClass orderClass;
    public CustomAdapter(OrderClass orderClass,  Context context) {
        this.orderClass = orderClass;
        this.order_name_list = orderClass.getOrderNameList();
        this.quantity_list = orderClass.getQuantityList();
        this.context = context;
        this.menu = orderClass.getMenu();
        this.price_list = orderClass.getPriceList();
    }


    @Override
    public int getCount() {
        return order_name_list.size();
    }

    @Override
    public Object getItem(int position) {
        return order_name_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO: Can implement holders to increase performance
        final DecimalFormat d = new DecimalFormat("##.##");
        View view = convertView;
        if (view ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customlistview,null);
        }

        final TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        final TextView priceView = (TextView)view.findViewById(R.id.priceView);
        listItemText.setText(order_name_list.get(position));


        final TextView quantityText = (TextView)view.findViewById(R.id.quantityView); //TODO: Need to change this so that any quantity can be inputted
        quantityText.setText(String.valueOf(quantity_list.get(position))); // TODO: No negatives allowed
        if (price_list.size() >0) {
            String priceViewText = price_list.get(position);
            priceView.setText(priceViewText);
        }

        double subtotalPrice =0;

        for (int j =0; j< price_list.size(); j++){
            subtotalPrice+= Double.parseDouble(price_list.get(j));
        }


        if(context instanceof Appetizers){
            if(order_name_list.size() != 0) {
                ((Appetizers) context).setSubtotal(subtotalPrice);
            }
            else{
                ((Appetizers) context).setSubtotal(0);
            }
        }


        Button deleteBtn = (Button)view.findViewById(R.id.delete_button);
        Button subtractBtn =(Button)view.findViewById(R.id.subtract_button);
        Button addBtn = (Button)view.findViewById(R.id.add_button);
        deleteBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                order_name_list.remove(position);
                quantity_list.remove(position);
                orderClass.reUpdateOrderhm(order_name_list, quantity_list);
                price_list = orderClass.getPriceList();

                if(context instanceof Appetizers){
                    if(order_name_list.size() == 0) {
                        ((Appetizers) context).setSubtotal(0);
                    }
                }
                notifyDataSetChanged();
            }
        });
        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer newsubQuant = quantity_list.get(position) - 1;
                quantity_list.set(position, newsubQuant);
                double newsubPrice = Double.parseDouble(menu.get(order_name_list.get(position)))
                        * quantity_list.get(position);

                //TODO: Need to get 2 decimal places to display
                price_list.set(position, d.format(newsubPrice));
                orderClass.reUpdateOrderhm(order_name_list, quantity_list);
                price_list = orderClass.getPriceList();
                notifyDataSetChanged();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Integer newaddQuant = quantity_list.get(position) + 1;
                quantity_list.set(position, newaddQuant);
                double newaddPrice = Double.parseDouble(menu.get(order_name_list.get(position)))
                        * quantity_list.get(position);
               //TODO: Need to get 2 decimal places to display
                price_list.set(position, d.format(newaddPrice));
                orderClass.reUpdateOrderhm(order_name_list, quantity_list);
                price_list = orderClass.getPriceList();

                notifyDataSetChanged();

            }
        });



        return view;
    }


    public ArrayList<String> getOrderNamesList(){
        return order_name_list;
    }

    public ArrayList<Integer> getQuantityList(){
        return quantity_list;
    }
}
