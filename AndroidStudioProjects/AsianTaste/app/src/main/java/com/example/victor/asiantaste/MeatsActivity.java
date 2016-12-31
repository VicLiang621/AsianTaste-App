package com.example.victor.asiantaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MeatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meats);

        setupButton();

    }

    public void setupButton(){
        Button button = (Button)findViewById(R.id.back_button_meats);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MeatsActivity.this, "Clicked back button", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
