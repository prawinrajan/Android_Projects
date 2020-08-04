package com.mydreamworld.showandhide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button show,hide;

    public void show(View view){
        textView.setVisibility(view.VISIBLE);
    }
    public void hide(View view){
        textView.setVisibility(view.INVISIBLE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.textview);

    }
}
