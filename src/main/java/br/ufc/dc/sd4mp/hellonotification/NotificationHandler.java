package br.ufc.dc.sd4mp.hellonotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class NotificationHandler extends Activity {

    private static final String CATEGORIA = "Notification";

    private String getClassName(){
        return NotificationHandler.class.getName();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(CATEGORIA, getClassName() + ".onCreate() --> created");
        setContentView(R.layout.activity_notification_handler);
        //NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //manager.cancel(R.string.app_name);
        Context context = getApplicationContext();
        CharSequence text = "Notification Handled!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
