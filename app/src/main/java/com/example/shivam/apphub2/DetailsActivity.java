package com.example.shivam.apphub2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



public class DetailsActivity extends ActionBarActivity {

    TextView mProductName,mProductDesc,mProductType,mProductInApp,mProductUpdate;
    Button mPlayStore;
    RatingBar mProductRating;
    ImageView mProductLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mProductDesc = (TextView)findViewById(R.id.productDescription);
        mProductInApp = (TextView)findViewById(R.id.productInApp);
        mProductName = (TextView)findViewById(R.id.productName);
        mProductType = (TextView)findViewById(R.id.productType);
        mProductUpdate = (TextView)findViewById(R.id.productUpdate);
        mPlayStore = (Button)findViewById(R.id.productLink);
        mProductRating = (RatingBar)findViewById(R.id.productRating);
        mProductLogo = (ImageView)findViewById(R.id.productImage);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffF44336));

        mProductName.setText(MainActivity.name);
        mProductDesc.setText(MainActivity.desc);
        mProductUpdate.setText("Last Updated : "+MainActivity.updated1);
        mProductRating.setRating(Float.parseFloat(MainActivity.rating1));
        mProductInApp.setText("InApp Purchase : " + MainActivity.inapp);

        mProductType.setText("Category : "+MainActivity.type1);
        Picasso.with(DetailsActivity.this).load(MainActivity.image1).placeholder(R.drawable.placeholder).into(mProductLogo);

        mPlayStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(MainActivity.link1);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sms) {
            Intent i = new Intent(DetailsActivity.this,SMSActivity.class);
            startActivity(i);
        }
        else if(id==R.id.action_share){
            Intent i=new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Details about " + MainActivity.name);
            i.putExtra(android.content.Intent.EXTRA_TEXT, ""+MainActivity.desc+"\n"+"You can download it at "+MainActivity.link1);
            startActivity(Intent.createChooser(i, "Share via..."));
        }

        return super.onOptionsItemSelected(item);
    }
}
