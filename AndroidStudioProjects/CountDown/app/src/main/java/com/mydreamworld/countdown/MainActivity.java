package com.mydreamworld.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int counter=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView counttime=findViewById(R.id.counttime);
        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText("seconds remaining: " + millisUntilFinished / 1000);

            }
            @Override
            public void onFinish() {
                counttime.setText("Finished");
            }
        }.start();
    }
}
