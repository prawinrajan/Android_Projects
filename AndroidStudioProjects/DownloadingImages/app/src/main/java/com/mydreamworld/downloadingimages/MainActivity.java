package com.mydreamworld.downloadingimages;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView downloadimage;
    public void Download(View view){

        ImageDownloader task=new ImageDownloader();
        Bitmap image;
        try {
             image=task.execute("https://i.ytimg.com/vi/gEVPoTuyQXo/maxresdefault.jpg").get();
             downloadimage.setImageBitmap(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("Interaction","Button tapped");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadimage=(ImageView) findViewById(R.id.imageview);
    }
    public class ImageDownloader extends AsyncTask <String , Void , Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in= connection.getInputStream();
                Bitmap bitmap= BitmapFactory.decodeStream(in);
                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }
    }
}
