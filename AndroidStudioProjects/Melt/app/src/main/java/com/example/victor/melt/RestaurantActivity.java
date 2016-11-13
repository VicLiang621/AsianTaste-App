package com.example.victor.melt;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by Victor on 10/14/2016.
 */
public class RestaurantActivity extends AppCompatActivity {
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Restaurants");
        setContentView(R.layout.restaurant_activity);
        final Intent to_menu = new Intent(this, MenuActivity.class);
        ImageButton qr_button = (ImageButton)findViewById(R.id.qr_button);
        ImageButton leigardenButton = (ImageButton)findViewById(R.id.leigardenImage);
        final Activity activity = this;
        leigardenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(to_menu);
            }
        });
        qr_button.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
//                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(camera_intent, CAM_REQUEST);

                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
//                integrator.setOrientationLocked(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
                new AlertDialog.Builder( RestaurantActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Grove has been selected. Continue?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(to_menu);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled scan", Toast.LENGTH_LONG).show();
            } else {
                  Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
//                Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
