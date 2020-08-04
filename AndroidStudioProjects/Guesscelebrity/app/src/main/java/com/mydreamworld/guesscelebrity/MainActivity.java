package com.mydreamworld.guesscelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result="";
            URL url;
            HttpURLConnection urlConnection= null;
            try{
                url= new URL(strings[0]);

                urlConnection=(HttpURLConnection) url.openConnection();

                InputStream in= urlConnection.getInputStream();
                InputStreamReader reader= new InputStreamReader(in);

                int data=reader.read();
                while(data!=-1){
                    char current= (char)data;
                    result+=current;
                    data=reader.read();
                }
                return result;
            }catch (Exception e){
                e.printStackTrace();
                return  "Failed";
            }

            //Log.i("URL",strings[0]);
        }
    }

    public void celbchoose() {
        //Log.i("interaction", "tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageview=(ImageView) findViewById(R.id.imageview);
        Button b1=(Button) findViewById(R.id.b1);
        Button b2=(Button) findViewById(R.id.b2);
        Button b3=(Button) findViewById(R.id.b3);
        Button b4=(Button) findViewById(R.id.b4);
        DownloadTask task=new DownloadTask();

        String result=null;

        try {
            result = task.execute("http://www.posh24.se/kandisar").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("Contents of URL",result);

    }
}