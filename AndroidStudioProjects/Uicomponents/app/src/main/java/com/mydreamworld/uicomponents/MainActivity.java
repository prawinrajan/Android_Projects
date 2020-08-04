package com.mydreamworld.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int t=1;
    int color=1;
    int font=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView= (TextView) findViewById(R.id.textView);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(t==1){
                    textView.setText("Hai user!, this is first cilck");
                    t+=1;
                }
                else if(t==2){
                    textView.setText("Hai user!, this is second cilck");
                    t+=1;
                }
                else if (t==3){
                    textView.setText("Hai user!, this is thired cilck");
                    t=1;
                }
            }
        });

        Button reset=(Button) findViewById(R.id.reset1);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Hello User!");
            }
        });

        Button button1=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (color){
                    case 1:
                        textView.setTextColor(Color.RED);
                        break;
                    case 2:
                        textView.setTextColor(Color.BLUE);
                        break;
                    case 3:
                        textView.setTextColor(Color.YELLOW);
                        break;
                }
                color++;
                if (color == 4)
                    color = 1;
            }
        });
        Button reset1=(Button) findViewById(R.id.reset2);
        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextColor(Color.BLACK);
            }
        });

        Button button2=(Button) findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(font==20){
                    textView.setTextSize(30);
                    font=30;
                }
                else if(font==30){
                    textView.setTextSize(40);
                    font=40;
                }
                else if(font==40){
                    textView.setTextSize(50);
                    font=20;
                }
            }
        });

        Button reset2=(Button) findViewById(R.id.reset3);
        reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextSize(20);
            }
        });

    }
}