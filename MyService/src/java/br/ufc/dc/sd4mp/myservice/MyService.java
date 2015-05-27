package br.ufc.dc.sd4mp.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service implements Runnable{

    private static final String CATEGORIA = "MyServiceClass";

    private String getClassName(){
        return MyService.class.getName();
    }

    private boolean running;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(CATEGORIA, getClassName() + ".onCreate() --> created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(CATEGORIA, getClassName() + ".onStartCommand() --> started command");
        running = true;
        run();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(CATEGORIA, getClassName() + ".onBind() --> bind service");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(CATEGORIA, getClassName() + ".onDestroy() --> destroyed");
    }

    public void run(){
        int i = 0;
        while (running && i <= 10) {
            Log.i("("+ i++ +")MyService", "MyService is running!!!");
            try {
                Thread.sleep(5000);
            } catch (
                InterruptedException e) {
            }
        }
        running = false;
    }
}
