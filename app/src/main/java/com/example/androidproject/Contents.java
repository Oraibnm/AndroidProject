package com.example.androidproject;

import android.widget.Button;

public class Contents {

    private String name;
    private int imageID;

    public static final Contents[] contents = {
//            new Contents("Our Menu", R.drawable.menu),
//            new Contents("Reservation ", R.drawable.reservation),
//            new Contents("Order", R.drawable.order),
//            new Contents("About Us", R.drawable.place),
//            new Contents("Our Location", R.drawable.location),
//            new Contents("Log In", R.drawable.login),



    };
    private Contents(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName(){return name;}
    public int getImageID(){return imageID;}

}


