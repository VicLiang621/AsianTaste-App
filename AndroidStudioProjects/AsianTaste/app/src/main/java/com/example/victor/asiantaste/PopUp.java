package com.example.victor.asiantaste;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by Victor on 9/22/2016.
 */
public class PopUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifylayout);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int)(height*0.8));
        OrderClass orderClass = ((OrderClass)getApplicationContext());
        orderClass.addModifyList("Hello");
        Log.d("popup", "added in something to modify list in orderClass");
        Log.d("popup", "gonna create modify adapter");
        ModifyListViewAdapter modifyListViewAdapter =  new ModifyListViewAdapter(orderClass, this);
        Log.d("popup", "created modify adapter");
        ListView modifyListView = (ListView)findViewById(R.id.modifyListView);
        modifyListView.setAdapter(modifyListViewAdapter);
        Log.d("popup", "set the adapter!");
    }
}
