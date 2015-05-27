package br.ufc.dc.sd4mp.myservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StartServiceActivity extends Activity {

    private static final String CATEGORIA = "UsingService";

    private String getClassName(){
        return StartServiceActivity.class.getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(CATEGORIA, getClassName() + ".onDestroy() --> destroyed");
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

    public void startingService(View view){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stoppingService(View view){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

}
