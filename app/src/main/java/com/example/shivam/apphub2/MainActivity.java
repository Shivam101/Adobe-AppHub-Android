package com.example.shivam.apphub2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView productList;
    TextView tv;
    String url = "http://adobe.0x10.info/api/products?type=json";
    StringBuilder builder = new StringBuilder();
    ArrayList<String> itemName,isInApp,image,updated,type,rating,link,description;
    private ProgressDialog progress;
    JSONObject jsonObject;
    static String name,inapp,image1,updated1,type1,rating1,link1,desc;
    ItemListAdapter adapter;
    static int flag;
    ReadJSONTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        itemName = new ArrayList<String>();
        isInApp = new ArrayList<String>();
        image = new ArrayList<String>();
        updated = new ArrayList<String>();
        type = new ArrayList<String>();
        rating = new ArrayList<String>();
        link = new ArrayList<String>();
        description = new ArrayList<String>();
        String JSONOutput = readJSON();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffF44336));
        productList = (ListView)findViewById(R.id.productList);

        try{

            final JSONArray jsonArray = new JSONArray(JSONOutput);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //jobj.add(jsonArray.getJSONObject(i));
                itemName.add(jsonObject.getString("name"));
                isInApp.add(jsonObject.getString("inapp-purchase"));
                image.add(jsonObject.getString("image"));
                updated.add(jsonObject.getString("last updated"));
                type.add(jsonObject.getString("type"));
                rating.add(jsonObject.getString("rating"));
                link.add(jsonObject.getString("url"));
                description.add(jsonObject.getString("description"));

            }
            //Toast.makeText(MainActivity.this,itemName.get(0)+""+itemName.get(1),Toast.LENGTH_LONG).show();

            ListItemHolder holder[] = new ListItemHolder[]
                    {
                            new ListItemHolder(itemName.get(0), "InApp : "+isInApp.get(0), image.get(0)),
                            new ListItemHolder(itemName.get(1), "InApp : "+isInApp.get(1), image.get(1)),
                            new ListItemHolder(itemName.get(2), "InApp : "+isInApp.get(2), image.get(2)),
                            new ListItemHolder(itemName.get(3), "InApp : "+isInApp.get(3), image.get(3)),
                            new ListItemHolder(itemName.get(4), "InApp : "+isInApp.get(4), image.get(4)),
                            new ListItemHolder(itemName.get(5), "InApp : "+isInApp.get(5), image.get(5)),
                            new ListItemHolder(itemName.get(6), "InApp : "+isInApp.get(6), image.get(6)),
                            new ListItemHolder(itemName.get(7), "InApp : "+isInApp.get(7), image.get(7)),
                            new ListItemHolder(itemName.get(8), "InApp : "+isInApp.get(8), image.get(8)),
                            new ListItemHolder(itemName.get(9), "InApp : "+isInApp.get(9), image.get(9)),
                            new ListItemHolder(itemName.get(10), "InApp : "+isInApp.get(10), image.get(10)),

                    };
                            ItemListAdapter adapter = new ItemListAdapter(MainActivity.this,
                    R.layout.list_item, holder);

            productList.setAdapter(adapter);

            productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        for(int i=0;i<jsonArray.length()-1;i++)
                        {
                            if(position==i)
                            {
                                flag = i;
                                name = itemName.get(i);
                                inapp = isInApp.get(i);
                                image1 = image.get(i);
                                updated1 = updated.get(i);
                                type1 = type.get(i);
                                link1 = link.get(i);
                                desc = description.get(i);
                                rating1 = rating.get(i);
                            }
                            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                            startActivity(intent);

                        }
                }
            });

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }

    public String readJSON() {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet(url);

        HttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StatusLine statusLine = response.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        if (statusCode == 200) {
                            HttpEntity entity = response.getEntity();
                            InputStream content = null;
                            try {
                                content = entity.getContent();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                            String line;
                            try {
                                while ((line = reader.readLine()) != null) {
                                    builder.append(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //Log.e(re.class.toString(), "Failed to download file");
                        }
        return builder.toString();
                    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_portfolio) {
            Intent i = new Intent(MainActivity.this,PortfolioActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
