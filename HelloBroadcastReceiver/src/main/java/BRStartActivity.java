package br.ufc.dc.sd4mp.hellobroadcastreceiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class BRStartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brstart);
    }

    public void SendBroadcast(View view) {
        Intent myintent = new Intent();
        myintent.setComponent(null);
        myintent.setAction("br.ufc.dc.sd4mp.action.BRSTART_ACTION");
        //Context thisContext = getApplicationContext();
        sendBroadcast(myintent);
    }
}
