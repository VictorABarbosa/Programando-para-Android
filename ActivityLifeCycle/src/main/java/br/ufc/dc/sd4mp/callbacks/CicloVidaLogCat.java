package br.ufc.dc.sd4mp.callbacks;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class CicloVidaLogCat extends Activity {

    public static final String CATEGORIA = "CicloVida";

    private String getClassName()
    {
        return CicloVidaLogCat.class.getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_vida_log_cat);
        Log.i(CATEGORIA,getClassName() + ".onCreate() --> created");
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
}
