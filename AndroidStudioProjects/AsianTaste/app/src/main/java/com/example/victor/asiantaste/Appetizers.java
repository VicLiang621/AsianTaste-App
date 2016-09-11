package com.example.victor.asiantaste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class Appetizers extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizers);
        setupButtons();

    }

    private void setupButtons() {
        Button[] buttons = new Button[100];
        for (int i = 1; i < 38; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = ((Button) findViewById(resID));
            buttons[i].setOnClickListener(this);

        }
    }
    @Override
    public void onClick(View v) {
        Log.d("Test", "Inside onClick function");
        final OrderClass orders = ((OrderClass) getApplicationContext());
        switch(v.getId()){
            case R.id.btn1:
                Log.d("Test", "got inside switch");
                orders.addAppetizer("Small Fried Wonton");
                break;
            case R.id.btn2:
                orders.addAppetizer("Large Fried Wonton");
                break;
            case R.id.btn3 :
                orders.addAppetizer("Small Egg Roll");
                break;
            case R.id.btn4:
                orders.addAppetizer("Large Egg Roll");
                break;
            case R.id.btn5:
                orders.addAppetizer("Small Spring Roll");
                break;
            case R.id.btn6:
                orders.addAppetizer("Large Spring Roll");
                break;
            case R.id.btn7:
                orders.addAppetizer("Small Scallion Pancake");
                break;
            case R.id.btn8:
                orders.addAppetizer("Large Scallion Pancake");
                break;
            case R.id.btn9:
                orders.addAppetizer("Small Fried Veggie");
                break;
            case R.id.btn10:
                orders.addAppetizer("Large Fried Veggie");
                break;
            case R.id.btn11:
                orders.addAppetizer("Small Chicken Wings");
                break;
            case R.id.btn12:
                orders.addAppetizer("Large Chicken Wings");
                break;
            case R.id.btn13:
                orders.addAppetizer("Small Spicy Chicken Wings");
                break;
            case R.id.btn14:
                orders.addAppetizer("Large Spicy Chicken Wings");
                break;
            case R.id.btn15:
                orders.addAppetizer("Small Pork Strip");
                break;
            case R.id.btn16:
                orders.addAppetizer("Large Pork Strip");
                break;
            case R.id.btn17:
                orders.addAppetizer("Small BBQ Spareribs");
                break;
            case R.id.btn18:
                orders.addAppetizer("Large BBQ Spareribs");
                break;
            case R.id.btn19:
                orders.addAppetizer("Small Boneless Spareribs");
                break;
            case R.id.btn20:
                orders.addAppetizer("Large Boneless Spareribs");
                break;
            case R.id.btn21:
                orders.addAppetizer("Small Crab Rangoon");
                break;
            case R.id.btn22:
                orders.addAppetizer("Large Crab Rangoon");
                break;
            case R.id.btn23:
                orders.addAppetizer("Small Chicken Fingers");
                break;
            case R.id.btn24:
                orders.addAppetizer("Large Chicken Fingers");
                break;
            case R.id.btn25:
                orders.addAppetizer("Small Jumbo Fried Shrimp");
                break;
            case R.id.btn26:
                orders.addAppetizer("Large Jumbo Fried Shrimp");
                break;
            case R.id.btn27:
                orders.addAppetizer("Small Beef Teriyaki");
                break;
            case R.id.btn28:
                orders.addAppetizer("Large Beef Teriyaki");
                break;
            case R.id.btn29:
                orders.addAppetizer("Small Chicken Teriyaki");
                break;
            case R.id.btn30:
                orders.addAppetizer("Large Chicken Teriyaki");
                break;
            case R.id.btn31:
                orders.addAppetizer("Small Pan Fried Ravioli");
                break;
            case R.id.btn32:
                orders.addAppetizer("Large Pan Fried Ravioli");
                break;
            case R.id.btn33:
                orders.addAppetizer("Spicy Wonton with Bean Sprout");
                break;
            case R.id.btn34:
                orders.addAppetizer("Tidbits");
                break;
            case R.id.btn35:
                orders.addAppetizer("Pu Pu Platter for One");
                break;
            case R.id.btn36:
                orders.addAppetizer("Pu Pu Platter for Two");
                break;
            case R.id.btn37:
                orders.printOrders();
        }
    }



}
