package br.ufc.dc.sd4mp.myalert;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MyAlertNotification extends Activity {

        public void onCreate(Bundle bundle){
            super.onCreate(bundle);
            Context context = getApplicationContext();
            CharSequence text = "Notification Handled!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
}
