package com.mydreamworld.multipleaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public void clicked(View view){
        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent in=getIntent();

        Toast.makeText(this,in.getStringExtra("name"),Toast.LENGTH_SHORT).show();

    }
}
