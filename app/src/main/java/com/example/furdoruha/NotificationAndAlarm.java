package com.example.furdoruha;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationAndAlarm {

    private final int NotificationId = 0;
    private static final String CHANNEL_ID = "shop_notification_channel";
    private NotificationManager mManager;
    private Context mContext;

    public NotificationAndAlarm(Context context){
        this.mContext = context;
        this.mManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    createChannel();
    }

    private void createChannel(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            return;
        }
        else {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"Furdoruha Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLightColor(Color.RED);
            channel.setDescription("Értesítés a fürdőruha applikációból!");
            this.mManager.createNotificationChannel(channel);
        }
    }
    public void send(String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, CHANNEL_ID).setContentTitle("Fürdőruha app").setContentText(message).setSmallIcon(R.drawable.bathicon);
        this.mManager.notify(NotificationId, builder.build());
    }
}
