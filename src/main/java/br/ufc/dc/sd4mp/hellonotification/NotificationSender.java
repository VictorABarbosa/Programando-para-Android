package br.ufc.dc.sd4mp.hellonotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class NotificationSender extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_sender);
    }

    public void SendNotification(View view) {

        Intent intent = new Intent(this, NotificationHandler.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new Notification.Builder(this)
                .setTicker("MyStatus")
                .setContentTitle("MyNotification")
                .setContentText("Description")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentIntent(pIntent)
                .build();


        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(R.string.app_name, notification);
    }
}
