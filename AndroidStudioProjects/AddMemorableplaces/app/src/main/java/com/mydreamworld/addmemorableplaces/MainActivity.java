package com.mydreamworld.addmemorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstview=(ListView) findViewById(R.id.lstview);

        final ArrayList<String> places= new ArrayList<>();

        places.add("add a new place");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);

        lstview.setAdapter(arrayAdapter);

        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("placenumber",position);
                startActivity(intent);
            }
        });
    }
}
