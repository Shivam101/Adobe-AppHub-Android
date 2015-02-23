package com.example.shivam.apphub2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shivam.apphub2.R;

public class SMSActivity extends ActionBarActivity {

    SmsManager smsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        //getActionBar().hide();
        smsManager = SmsManager.getDefault();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffF44336));
        final EditText mNumber = (EditText)findViewById(R.id.number);
        Button mSend = (Button)findViewById(R.id.send);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsManager.sendTextMessage(mNumber.getText().toString(), null, "Hi ! Check out this app "+MainActivity.link1, null, null);
                Toast.makeText(SMSActivity.this,"SMS Sent Successfully",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sm, menu);
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
