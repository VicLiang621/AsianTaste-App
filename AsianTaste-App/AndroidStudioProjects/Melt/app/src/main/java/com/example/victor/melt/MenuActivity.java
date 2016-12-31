package com.example.victor.melt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Victor on 10/15/2016.
 */
public class MenuActivity extends AppCompatActivity {

    Orders order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        ListView lv  = (ListView)findViewById(R.id.listView);
        order = ((Orders)getApplicationContext());
        order.addDish_images(R.drawable.sandwich);
        order.addDish_images(R.drawable.bakedchicken);
        order.addOrder_names_list("Ham and Cheese");
//        order.addOrder_names_list("Baked Chicken");
        order.addQuantity_list(1);
//        order.addQuantity_list(0);
        order.addPrice_list("$20.00");

        lv.setAdapter(new CustomAdapter(this,order));

        final Intent to_confirmation= new Intent(this, ConfirmationActivity.class);

        Button continue_button = (Button)findViewById(R.id.continue_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(to_confirmation);
            }
        });
    }


}
