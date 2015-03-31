package br.ufc.dc.sd4mp.reservalaboratorio;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public Object chosen_item;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Object item = parent.getItemAtPosition(pos);
        chosen_item = item;
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    public Object getChosenItem(){
        return chosen_item;
    }
}
