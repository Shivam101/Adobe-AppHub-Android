package com.example.shivam.apphub2;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Shivam on 25/01/15.
 */
public class ReadJSONTask extends AsyncTask<String,Void,String> {

    public interface OnTaskCompleted{
        void onTaskCompleted();
    }
    private OnTaskCompleted listener;

    public ReadJSONTask(OnTaskCompleted listener){
        this.listener = listener;
    }


    protected String doInBackground(String... params)
    {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://adobe.0x10.info/api/products?type=json");
        StringBuilder builder = new StringBuilder();
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

    protected void onPostExecute(String result){
        // Call the interface method
        if (listener != null)
            listener.onTaskCompleted();
    }


}
