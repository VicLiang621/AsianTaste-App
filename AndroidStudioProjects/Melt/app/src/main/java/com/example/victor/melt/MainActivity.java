package com.example.victor.melt;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Orders order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText)findViewById(R.id.usernameEditText);
        username.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        Button login_button = (Button)findViewById(R.id.loginButton);
        final Intent to_restaurantActivity = new Intent(this, RestaurantActivity.class);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(to_restaurantActivity);
            }
        });
    }
}
