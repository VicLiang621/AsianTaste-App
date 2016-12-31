package com.example.victor.melt;

import android.app.Application;


import java.util.ArrayList;

/**
 * Created by Victor on 10/15/2016.
 */
public class Orders extends Application {


    private ArrayList<String> order_names_list = new ArrayList<String>();
    private ArrayList<Integer> quantity_list = new ArrayList<>();
    private ArrayList<Integer> dish_images = new ArrayList<>();
    private ArrayList<String> price_list = new ArrayList<>();


    public ArrayList<String> getOrder_names_list() {
        return order_names_list;
    }

    public void addOrder_names_list(String order_name) {
        order_names_list.add(order_name);
    }

    public ArrayList<Integer> getQuantity_list() {
        return quantity_list;
    }

    public void addQuantity_list(Integer quantity) {
        quantity_list.add(quantity);
    }


    public ArrayList<Integer> getDish_images() {
        return dish_images;
    }

    public void addDish_images(Integer id) {
        dish_images.add(id);
    }

    public ArrayList<String> getPrice_list() {
        return price_list;
    }

    public void addPrice_list(String price) {
        price_list.add(price);
    }
}
