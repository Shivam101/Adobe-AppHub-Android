package com.example.shivam.apphub2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shivam on 25/01/15.
 */
public class ItemListAdapter2 extends ArrayAdapter<ListItemHolder> {

    static Context context;
    static int layoutResourceId;
    ListItemHolder data[] = null;

    public ItemListAdapter2(Context context, int layoutResourceId, ListItemHolder[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProductHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            //row.setMinimumHeight(200);
            holder = new ProductHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.txtTitle2 = (TextView)row.findViewById(R.id.txtTitle2);
            row.setTag(holder);
        }
        else
        {
            holder = (ProductHolder)row.getTag();
        }

        ListItemHolder hold = data[position];
        int limit = 12;
            holder.txtTitle.setText(hold.name);


        holder.txtTitle2.setText(hold.inapp);
        /*if(weather.inapp=="InApp:YES")
        {
            holder.txtTitle2.setTextColor(Color.GREEN);
        }
        else
        {
            holder.txtTitle2.setTextColor(Color.RED);
        }*/
        return row;
    }

    static class ProductHolder
    {
        TextView txtTitle;
        TextView txtTitle2;
        TextView txtTitle3;
    }


}
