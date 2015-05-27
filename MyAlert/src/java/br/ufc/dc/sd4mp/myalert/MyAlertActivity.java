package br.ufc.dc.sd4mp.myalert;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.util.EventListener;


public class MyAlertActivity extends Activity {

    private boolean MudancaBateria;
    private boolean ModoAviao;
    private boolean ModoConectado;
    private boolean ModoDesconectado;

    public static final String CATEGORIA = "MyAlert";

    private String getClassName()
    {
        return MyAlertActivity.class.getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alert);
        Log.i(CATEGORIA, getClassName() + ".onCreate() --> created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(CATEGORIA,getClassName() + ".onDestroy() --> destroyed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(CATEGORIA,getClassName() + ".onResume() --> resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(CATEGORIA,getClassName() + ".onPause() --> paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(CATEGORIA,getClassName() + ".onRestart() --> restarted");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(CATEGORIA,getClassName() + ".onStart() --> started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(CATEGORIA, getClassName() + ".onStop() --> stopped");
    }

    public void CheckboxAlert(View view){
        boolean isChecked = ((CheckBox)view).isChecked();

        switch(view.getId()){
            case R.id.mudanca_bateria:
                MudancaBateria = isChecked;
                if (MudancaBateria) {
                    /*Intent intent = new Intent(this, MyAlertReceiver.class);
                    //PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
                    IntentService intentService = (IntentService)getSystemService(Context.BATTERY_SERVICE);
                    intentService.sendBroadcast(intent);*/
                }
                else{

                }
                break;
            case R.id.modo_aviao:
                ModoAviao = isChecked;
                if (ModoAviao){
                    Intent intent = new Intent(this, MyAlertReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);



                    //AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    //alarmManager.set(0,3000,pendingIntent);
                }
                break;
            case R.id.modo_conectado:
                ModoConectado = isChecked;
                break;
            case R.id.modo_desconectado:
                ModoDesconectado = isChecked;
                break;
        }
    }
}
