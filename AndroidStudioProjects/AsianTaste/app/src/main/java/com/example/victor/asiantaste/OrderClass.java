package com.example.victor.asiantaste;

import android.app.Application;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Victor on 9/8/2016.
 */
public class OrderClass extends Application {
    private LinkedHashMap<String, Integer> order_hm = new LinkedHashMap<>();
    private HashMap<String, String> menu = new HashMap<String, String>();
    private ArrayList<String> order_names_list = new ArrayList<String>();
    private ArrayList<Integer> quantity_list = new ArrayList<>();
    private ArrayList<String> price_list = new ArrayList<>();
    private ArrayList<String> modify_list = new ArrayList<>();

    public void putOrderhm(String name, Integer quantity) {
        order_hm.put(name, quantity);
    }


    public void putMenuhm(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                menu.put(key, value);
            } else {
                Log.d("Creation","ignoring line: " + line);
            }
        }

        reader.close();

    }
    public HashMap<String, Integer> getOrderhm(){
        return order_hm;
    }

    public HashMap<String, String> getMenu (){
        return menu;
    }

    public void printMenu(){

        for (String key : menu.keySet()) {
            Log.d("Menu",(key + ": " + menu.get(key)));
        }

    }
    public void printOrders(){
        for (String key: order_hm.keySet()){
            Log.d("Order", (key + ": " + order_hm.get(key)));
        }
        Log.d("Order", "Size of order_names_list is " + order_names_list.size());
        for (int i =0; i < order_names_list.size(); i++) {
            Log.d("OrderNameList", order_names_list.get(i) +":" +quantity_list.get(i) );

        }

    }

    public void addAppetizer(String appetizer_name, CustomAdapter adapter){
        if (order_hm.containsKey(appetizer_name)){
            Integer new_quantity = order_hm.get(appetizer_name) + 1;
            putOrderhm(appetizer_name, new_quantity);

        }
        else{
            putOrderhm(appetizer_name, 1);
        }
        updateOrderList();
        updateQuantityList();
        updatePriceList();
        adapter.notifyDataSetChanged();
    }

    public ArrayList<String> getOrderNameList(){
        return order_names_list;
    }

    public ArrayList<Integer> getQuantityList(){
        return quantity_list;
    }

    public ArrayList<String> getPriceList(){
        return price_list;
    }

    public void updateQuantityList() {
        quantity_list.clear();
        for (Integer value : order_hm.values()) {
            quantity_list.add(value);
        }
    }

    public void updateOrderList(){
        order_names_list.clear();
        for (String key: order_hm.keySet()){
            order_names_list.add(key);
        }
    }

    public void reUpdateOrderhm(ArrayList<String> order_names_list, ArrayList<Integer> quantity_list){
        order_hm.clear();
        for (int i = 0; i < order_names_list.size(); i++){
            order_hm.put(order_names_list.get(i), quantity_list.get(i));
        }

        updateOrderList();
        updateQuantityList();
        updatePriceList();
    }

    public void updatePriceList(){
        price_list.clear();
        for (int i=0; i< order_names_list.size(); i++){
            DecimalFormat f = new DecimalFormat("##.##"); //TODO: Need to get 2 decimal places to display
            String price = f.format(Double.parseDouble(menu.get(order_names_list.get(i))) * quantity_list.get(i));
            price_list.add(price);
        }
    }

    public ArrayList<String> getModifyList(){
        return modify_list;
    }

    public void addModifyList(String modification){
        modify_list.add(modification);
    }




}
