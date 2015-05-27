package br.ufc.dc.sd4mp.sensors;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.sensors.R;


public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager sMgr;
    private boolean listening;
    private Sensor lightSensor;
    private Sensor temperatureSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView sensorsData = (TextView) findViewById(R.id.textView1);

        StringBuilder builder = new StringBuilder();
        builder.append("Pressione start button para iniciar.");

        sensorsData.setText(builder);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (listening == false) return;

        float v = event.values[0];

        TextView sensorsData = (TextView) findViewById(R.id.textView1);
        sensorsData.setText(
                lightSensor.getName() + "\n" +
                lightSensor.getVendor() + "\n" +
                Float.toString(v) + " lx");
    }

    public void startListeningSensors(View view){
        listening = true;
        sMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sMgr != null) {
            lightSensor = sMgr.getDefaultSensor(Sensor.TYPE_LIGHT);
            sMgr.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void stopListeningSensors(View view){
        listening = false;
        TextView sensorsData = (TextView) findViewById(R.id.textView1);
        sensorsData.setText("Start para monitorar luminosidade.");
    }
}
