package com.example.victor.melt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Victor on 10/15/2016.
 */
public class CustomAdapter extends BaseAdapter implements ListAdapter{

    private Context context;
    private Orders order;



    public CustomAdapter(Context context, Orders order){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customlistview,null);
        }

        final TextView order_text = (TextView)view.findViewById(R.id.order_name_text);
        final TextView quantity_text = (TextView)view.findViewById(R.id.quantity_text);
        final ImageView dish_image = (ImageView)view.findViewById(R.id.dish_image);
        order_text.setText(order.getOrder_names_list().get(position));

        dish_image.setImageResource(order.getDish_images().get(position));
        quantity_text.setText(String.valueOf(order.getQuantity_list().get(position)));
        final Button subtract_button = (Button)view.findViewById(R.id.subtract_button);
        final Button add_button = (Button)view.findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer new_quantity = order.getQuantity_list().get(position) + 1;
                order.getQuantity_list().set(position, new_quantity);
                notifyDataSetChanged();

            }
        });

        subtract_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer new_quantity = order.getQuantity_list().get(position) -1;
                order.getQuantity_list().set(position, new_quantity);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
