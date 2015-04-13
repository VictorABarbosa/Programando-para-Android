package br.ufc.dc.sd4mp.hellobroadcastreceiver;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BRTest extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent){
        CharSequence text = "Broadcast Received!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
