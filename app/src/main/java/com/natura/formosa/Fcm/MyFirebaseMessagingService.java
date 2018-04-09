package com.natura.formosa.Fcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.natura.formosa.R;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by Marceloi7 on 07/04/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Inject
    Context context;
    NotificationManager notificationManager;
    String ADMIN_CHANNEL_ID = "my_channel_id_01";
    Uri sound = Uri.parse("android.resource://com.natura.formosa/" + R.raw.tono);

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            setupChannels(); }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, ADMIN_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_name)
        .setContentTitle("Natura, siempre junto a vos")
        .setContentText(remoteMessage.getNotification().getBody())
        .setSound(sound)
        .setDefaults(Notification.DEFAULT_VIBRATE)
        .setAutoCancel(true);


        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notificationBuilder.build());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupChannels() {
        CharSequence adminChannelName = "marcelo";
        String adminChannelDescription = "channel_admin";
        NotificationChannel adminChannel;
        adminChannel = new NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_LOW);
        adminChannel.setDescription(adminChannelDescription);
        adminChannel.enableLights(true);
        adminChannel.setLightColor(Color.RED);
        adminChannel.enableVibration(true);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(adminChannel);
        }
    }
}
