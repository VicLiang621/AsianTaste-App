package com.example.victor.asiantaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class    MainActivity extends AppCompatActivity {
    OrderClass orders;
 public void main_to_meats(View view)
 {
     Intent main_to_meats_intent= new Intent(MainActivity.this, MeatsActivity.class);
     startActivity(main_to_meats_intent);
 }

    public void go_back(View view)
    {
        onBackPressed(); // TODO: Make back button more smooth
    }

    public void main_to_appetizers (View view){
        Intent main_to_appetizers_intent = new Intent(MainActivity.this, Appetizers.class);
        startActivity(main_to_appetizers_intent);

    }

    public void makeMenu(OrderClass orders){
        Log.d("Creation","Create a buffer reader");
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("OrderPrices.txt")));
            BufferedReader modifyreader = new BufferedReader(new InputStreamReader(getAssets().open("modifications.txt")));
            orders.putMenuhm(reader);
            orders.addModifyList(modifyreader);
            Log.d("Creation", "Added to menu and modify reader");
        }
        catch(IOException e){
            e.printStackTrace();
            Log.d("Creation", "Failed miserably");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orders = ((OrderClass) getApplicationContext());
        makeMenu(orders);
        orders.printMenu();

    }



}
