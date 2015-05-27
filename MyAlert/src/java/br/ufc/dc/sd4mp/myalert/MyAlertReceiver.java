package br.ufc.dc.sd4mp.myalert;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyAlertReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        Intent myIntent = new Intent(context, MyAlertNotification.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, myIntent, 0);
        Notification notification = new Notification.Builder(context)
                .setTicker("Battery")
                .setContentTitle("BatteryModeChanged")
                .setContentText("Description01")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentIntent(pIntent)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(R.string.app_name, notification);
    }
}
