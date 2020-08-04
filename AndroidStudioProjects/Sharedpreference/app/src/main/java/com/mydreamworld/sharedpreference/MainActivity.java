package com.mydreamworld.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.mydreamworld.sharedpreference", Context.MODE_PRIVATE);
/*
        ArrayList<String> friends=new ArrayList<>();

        friends.add("prawin");
        friends.add("Sanjay");
        friends.add("sudharsan");

        try {

            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();


        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        ArrayList<String> newfrnds=new ArrayList<>();

        try {
            newfrnds=(ArrayList<String>) ObjectSerializer.deserialize((sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>()))));

        } catch (IOException e) {
            e.printStackTrace();
        }

Log.i("new frnds",newfrnds.toString());        //sharedPreferences.edit().putString("username","prawin").apply();

        //String username=sharedPreferences.getString("username","");

        //Log.i("username",username);

    }
}
