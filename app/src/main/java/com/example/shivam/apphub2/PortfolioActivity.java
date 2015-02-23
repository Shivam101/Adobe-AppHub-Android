package com.example.shivam.apphub2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shivam.apphub2.R;

public class PortfolioActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffF44336));

        ListView projectList = (ListView) findViewById(R.id.projectList);
        ListItemHolder holder[] = new ListItemHolder[]
                {
                        new ListItemHolder("ChitChat", "Android messaging app with the ability to send ephemeral photo and video"),
                        new ListItemHolder("Manipal Now", "Android application with local listings for the city of Manipal,Karnataka"),
                        new ListItemHolder("Sigma", "Android app for the fundraiser of an NGO"),
                        new ListItemHolder("Material Planner", "Android daily planner and note-taking app with cloud-sync"),
                        new ListItemHolder("Sachin App", "Fun Android app for cricket fans"),
                };
        ItemListAdapter2 adapter = new ItemListAdapter2(PortfolioActivity.this,
                R.layout.list_item_2, holder);
        projectList.setAdapter(adapter);
        projectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Uri uri = Uri.parse("https://github.com/Shivam101/ChitChat");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Uri uri = Uri.parse("https://github.com/Shivam101/ManipalNow-Android");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                else if(position==2)
                {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.shivamb7.sigma");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                else if(position==3)
                {
                    Uri uri = Uri.parse("https://github.com/Shivam101/Android-Material-Planner");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                else if(position==4)
                {
                    Uri uri = Uri.parse("https://github.com/Shivam101/SachinApp-Android");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_portfolio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
