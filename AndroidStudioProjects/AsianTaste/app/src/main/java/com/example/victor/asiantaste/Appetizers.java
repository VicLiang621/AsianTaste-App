package com.example.victor.asiantaste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Appetizers extends AppCompatActivity implements View.OnClickListener {

    int[] quantities;
    CustomAdapter adapter;
    OrderClass orderClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizers);
        setupButtons();
        orderClass = ((OrderClass)getApplicationContext());
        HashMap<String, String> menu = orderClass.getMenu();


        adapter = new CustomAdapter(orderClass.getOrderNameList(),
                orderClass.getQuantityList(), menu, orderClass, this);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }

    private void setupButtons() {
        Button[] buttons = new Button[100];
        for (int i = 1; i < 38; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = ((Button) findViewById(resID));
            buttons[i].setOnClickListener(this);
        }
        Button back_button = (Button)findViewById(R.id.back_button_appetizer);
        back_button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Log.d("Test", "Inside onClick function");
        orderClass = ((OrderClass) getApplicationContext());
        switch(v.getId()){
            case R.id.btn1:
                Log.d("Test", "got inside switch");
                orderClass.addAppetizer("Small Fried Wonton", adapter); //
                // TODO: I don't know if passing in an adapter to notify it is better or just calling notify dataset in each switch case itself
                break;
            case R.id.btn2:
                orderClass.addAppetizer("Large Fried Wonton", adapter);
                break;
            case R.id.btn3 :
                orderClass.addAppetizer("Small Egg Roll", adapter);

                break;
            case R.id.btn4:
                orderClass.addAppetizer("Large Egg Roll", adapter);
                break;
            case R.id.btn5:
                orderClass.addAppetizer("Small Spring Roll",adapter);
                break;
            case R.id.btn6:
                orderClass.addAppetizer("Large Spring Roll", adapter);
                break;
            case R.id.btn7:
                orderClass.addAppetizer("Small Scallion Pancake", adapter);
                break;
            case R.id.btn8:
                orderClass.addAppetizer("Large Scallion Pancake", adapter);
                break;
            case R.id.btn9:
                orderClass.addAppetizer("Small Fried Veggie", adapter);
                break;
            case R.id.btn10:
                orderClass.addAppetizer("Large Fried Veggie", adapter);
                break;
            case R.id.btn11:
                orderClass.addAppetizer("Small Chicken Wings", adapter);
                break;
            case R.id.btn12:
                orderClass.addAppetizer("Large Chicken Wings", adapter);
                break;
            case R.id.btn13:
                orderClass.addAppetizer("Small Spicy Chicken Wings", adapter);
                break;
            case R.id.btn14:
                orderClass.addAppetizer("Large Spicy Chicken Wings", adapter);
                break;
            case R.id.btn15:
                orderClass.addAppetizer("Small Pork Strip", adapter);
                break;
            case R.id.btn16:
                orderClass.addAppetizer("Large Pork Strip", adapter);
                break;
            case R.id.btn17:
                orderClass.addAppetizer("Small BBQ Spareribs",adapter);
                break;
            case R.id.btn18:
                orderClass.addAppetizer("Large BBQ Spareribs", adapter);
                break;
            case R.id.btn19:
                orderClass.addAppetizer("Small Boneless Spareribs", adapter);
                break;
            case R.id.btn20:
                orderClass.addAppetizer("Large Boneless Spareribs", adapter);
                break;
            case R.id.btn21:
                orderClass.addAppetizer("Small Crab Rangoon", adapter );
                break;
            case R.id.btn22:
                orderClass.addAppetizer("Large Crab Rangoon", adapter);
                break;
            case R.id.btn23:
                orderClass.addAppetizer("Small Chicken Fingers", adapter);
                break;
            case R.id.btn24:
                orderClass.addAppetizer("Large Chicken Fingers", adapter);
                break;
            case R.id.btn25:
                orderClass.addAppetizer("Small Jumbo Fried Shrimp", adapter);
                break;
            case R.id.btn26:
                orderClass.addAppetizer("Large Jumbo Fried Shrimp", adapter);
                break;
            case R.id.btn27:
                orderClass.addAppetizer("Small Beef Teriyaki", adapter);
                break;
            case R.id.btn28:
                orderClass.addAppetizer("Large Beef Teriyaki", adapter);
                break;
            case R.id.btn29:
                orderClass.addAppetizer("Small Chicken Teriyaki", adapter);
                break;
            case R.id.btn30:
                orderClass.addAppetizer("Large Chicken Teriyaki", adapter);
                break;
            case R.id.btn31:
                orderClass.addAppetizer("Small Pan Fried Ravioli", adapter);
                break;
            case R.id.btn32:
                orderClass.addAppetizer("Large Pan Fried Ravioli", adapter);
                break;
            case R.id.btn33:
                orderClass.addAppetizer("Spicy Wonton with Bean Sprout", adapter);
                break;
            case R.id.btn34:
                orderClass.addAppetizer("Tidbits", adapter);
                break;
            case R.id.btn35:
                orderClass.addAppetizer("Pu Pu Platter for One", adapter);
                break;
            case R.id.btn36:
                orderClass.addAppetizer("Pu Pu Platter for Two", adapter);
                break;
            case R.id.btn37:
                orderClass.printOrders();
                break;
            case R.id.back_button_appetizer:
                Toast.makeText(Appetizers.this, "Clicked back button", Toast.LENGTH_LONG).show();
                orderClass.reUpdateOrderhm(adapter.getOrderNamesList(), adapter.getQuantityList());
                finish();

        }
    }




}
