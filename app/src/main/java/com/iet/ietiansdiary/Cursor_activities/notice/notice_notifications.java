package com.iet.ietiansdiary.Cursor_activities.notice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class notice_notifications extends Application {
    public static final String Channel_1_ID="channel1";
    public static final String Channel_2_ID="channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createnotificationchaneels();
    }
    private void createnotificationchaneels(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel1=new NotificationChannel(
                    Channel_1_ID,"Priority", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("High-Priority");
            NotificationChannel channel2=new NotificationChannel(
                    Channel_2_ID,"LOW", NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("Low-Priority");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);



        }

    }
}
