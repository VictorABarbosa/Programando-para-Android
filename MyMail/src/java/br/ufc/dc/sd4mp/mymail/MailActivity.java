package br.ufc.dc.sd4mp.mymail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.i(CATEGORIA, getClassName() + ".onDestroy() --> destroyed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.i(CATEGORIA,getClassName() + ".onResume() --> resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.i(CATEGORIA,getClassName() + ".onPause() --> paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Log.i(CATEGORIA,getClassName() + ".onRestart() --> restarted");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.i(CATEGORIA,getClassName() + ".onStart() --> started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Log.i(CATEGORIA, getClassName() + ".onStop() --> stopped");
    }


   public void EnviarEmailActivity(View view){
       Intent emailActivity = new Intent(this, SendMail.class); //COMPONENTE ESPECIFICADO
       emailActivity.setAction(null);
       emailActivity.setType(null);
       emailActivity.setData(null);
       startActivity(emailActivity);
   }

   public void FinalizarAplicativo(View view){
        finish();
   }
}
