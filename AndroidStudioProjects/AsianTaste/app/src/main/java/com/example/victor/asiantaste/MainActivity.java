package com.example.victor.asiantaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
