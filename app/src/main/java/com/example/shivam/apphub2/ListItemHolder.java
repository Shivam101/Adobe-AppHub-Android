package com.example.shivam.apphub2;

import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;

/**
 * Created by Shivam on 25/01/15.
 */
public class ListItemHolder {

    //public Drawable icon;
    public String name;
    public String inapp;
    public String iconURL;

    public ListItemHolder(String name,String inapp,String iconURL)
    {
        this.name = name;
        this.inapp = inapp;
        this.iconURL = iconURL;

    }

    public ListItemHolder(String name,String inapp)
    {
        this.name = name;
        this.inapp = inapp;
    }
}
