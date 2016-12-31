package com.example.victor.melt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Victor on 10/15/2016.
 */
public class ConfirmationActivity extends AppCompatActivity {
    Orders order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);
        order = ((Orders)getApplicationContext());
        ListView lv2  = (ListView)findViewById(R.id.listView2);
        lv2.setAdapter(new CustomAdapter2(this, order));

        Button confirm_button = (Button)findViewById(R.id.confirmButton);

        confirm_button.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder( ConfirmationActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("You order has been placed!")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })

                        .show();

            }
        });
    }
}
