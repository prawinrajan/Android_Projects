package com.mydreamworld.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.mydreamworld.notification.APP.CHANNEL_1_ID;
import static com.mydreamworld.notification.APP.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager=NotificationManagerCompat.from(this);
        editTextTitle=(EditText) findViewById(R.id.textView);
        editTextMessage=(EditText) findViewById(R.id.textView2);

    }

    public void sendOnChannel1(View v){
        String title=editTextTitle.getText().toString();
        String message=editTextMessage.getText().toString();
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1,notification);
    }

    public void sendOnChannel2(View v){
        String title=editTextTitle.getText().toString();
        String message=editTextMessage.getText().toString();
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_mood)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)

                .build();
        notificationManager.notify(2,notification);
    }
}
