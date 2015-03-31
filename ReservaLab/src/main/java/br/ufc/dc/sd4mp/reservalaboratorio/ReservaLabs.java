package br.ufc.dc.sd4mp.reservalaboratorio;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.util.Calendar;


public class ReservaLabs extends Activity {

    private static final String CATEGORIA = "ReservaLabs";

    private String getClassName(){
        return ReservaLabs.class.getName();
    }

    private String NameProfessor;
    private String SIAPE;
    private String Email;
    private Button dateText; private DatePickerFragment DateBox;
    private Button timeText; private TimePickerFragment TimeBox;
    private SpinnerActivity LabBox;
    private String Datashow;
    private boolean AndroidSDK;
    private boolean JavaSDK;
    private boolean SisLinux;
    private boolean SisWindows;
    private String Observacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_labs);
        dateText = (Button) findViewById(R.id.choose_date_button);
        timeText = (Button) findViewById(R.id.choose_time_button);

        SpinnerActivity spinnerAct = new SpinnerActivity();

        Spinner spinner = (Spinner)findViewById(R.id.lab_spinner);
        spinner.setOnItemSelectedListener(spinnerAct);

        String[] labs = getResources().getStringArray(R.array.lab_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,labs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        LabBox = spinnerAct;
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

    private void setAndroidSDK(boolean isNeeded){
        AndroidSDK = isNeeded;
    }

    private void setJavaSDK(boolean isNeeded){
        JavaSDK = isNeeded;
    }

    private void setSisLinux(boolean isNeeded){
        SisLinux = isNeeded;
    }

    private void setSisWindows(boolean isNeeded){
        SisWindows = isNeeded;
    }

    public void showDatePickerDialog(View view){
        DialogFragment newFragment = new DatePickerFragment();
        ((DatePickerFragment) newFragment).setDateReference(dateText);
        newFragment.show(this.getFragmentManager(),"datePicker");
        DateBox = (DatePickerFragment)newFragment;
    }

    public void showTimePickerDialog(View view){
        DialogFragment newFragment = new TimePickerFragment();
        ((TimePickerFragment) newFragment).setTimeReference(timeText);
        newFragment.show(this.getFragmentManager(),"timePicker");
        TimeBox = (TimePickerFragment)newFragment;
    }

    public void needForDataShow(View view){
        boolean isChecked = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.yesForDatashowId:
                if(isChecked){
                    Datashow = "Sim";
                }
                break;
            case R.id.noForDatashowId:
                if(isChecked){
                    Datashow = "Nao";
                }
                break;
            case R.id.maybeForDatashowId:
                if(isChecked){
                    Datashow = "Talvez";
                }
                break;
        }
    }

    public void needForConfigs(View view){
        boolean isChecked = ((CheckBox)view).isChecked();

        switch(view.getId()){
            case R.id.android_sdk:
                if(isChecked){
                    setAndroidSDK(true);
                }
                else{
                    setAndroidSDK(false);
                }
                break;
            case R.id.java_sdk:
                if(isChecked){
                    setJavaSDK(true);
                }
                else{
                    setJavaSDK(false);
                }
                break;
            case R.id.sistema_linux:
                if(isChecked){
                    setSisLinux(true);
                }
                else{
                    setSisLinux(false);
                }
                break;
            case R.id.sistema_windows:
                if(isChecked){
                    setSisWindows(true);
                }
                else{
                    setSisWindows(false);
                }
                break;
        }
    }

    public void sendEmailImplicit(View view){
        EditText nome = (EditText)findViewById(R.id.name_professor);
        EditText siape = (EditText)findViewById(R.id.siape_professor);
        EditText email = (EditText)findViewById(R.id.email_professor);
        String data = DateBox.getChosenDay() + "/" + DateBox.getChosenMonth() + "/" + DateBox.getChosenYear();
        String hora = TimeBox.getChosenHour() + ":" + TimeBox.getChosenMinute();
        String lab = LabBox.getChosenItem().toString();
        String dataShow = Datashow;
        ToggleButton prioridade = (ToggleButton)findViewById(R.id.priority_button);
        EditText observacao = (EditText)findViewById(R.id.obs_field);


        String boxIsChecked = "(X)";
        String boxNotChecked = "( )";


        String Identify = "====================================\n";
        Identify = Identify + "Identificacao\n";
        Identify = Identify + "====================================\n";
        Identify = Identify + "Nome do professor: " + nome.getText() + "\n";
        Identify = Identify + "SIAPE: " + siape.getText() + "\n";
        Identify = Identify + "E-mail: " + email.getText() + "\n";
        String DadosReserva = "====================================\n";
        DadosReserva = DadosReserva + "Dados da Reserva\n";
        DadosReserva =  DadosReserva + "====================================\n";
        DadosReserva = DadosReserva + "Data da reserva: " + data + "\n";
        DadosReserva = DadosReserva + "Horario da reserva: " + hora + "\n";
        DadosReserva = DadosReserva + "Laboratorio: " + lab + "\n";
        DadosReserva = DadosReserva + "Vai precisar de datashow: " + dataShow + "\n";
        DadosReserva = DadosReserva + "Configuracoes desejadas dos Computadores: " + "\n";
        if (AndroidSDK == true) DadosReserva = DadosReserva + boxIsChecked + "Android Studio + Android SDK" + "\n";
        else DadosReserva = DadosReserva + boxNotChecked + "Android Studio + Android SDK" + "\n";
        if (JavaSDK == true) DadosReserva = DadosReserva + boxIsChecked + "Java SDK" + "\n";
        else DadosReserva = DadosReserva + boxNotChecked + "Java SDK" + "\n";
        if (SisLinux == true) DadosReserva = DadosReserva + boxIsChecked + "Sistema Linux" + "\n";
        else DadosReserva = DadosReserva + boxNotChecked + "Sistema Linux" + "\n";
        if (SisWindows == true) DadosReserva = DadosReserva + boxIsChecked + "Sistema Windows" + "\n";
        else DadosReserva = DadosReserva + boxNotChecked + "Sistema Windows" + "\n";
        DadosReserva = DadosReserva + "Reserva Prioritaria?" + prioridade.getText() + "\n";
        DadosReserva = DadosReserva + "Observacao: " + observacao.getText() + "\n";
        DadosReserva = DadosReserva + "=====================================";

        String EmailBody = Identify + DadosReserva;

        Intent message = new Intent(Intent.ACTION_SEND);
        message.putExtra(Intent.EXTRA_EMAIL, new String[]{"vab.ccomp@gmail.com"});
        message.putExtra(Intent.EXTRA_SUBJECT, "Reserva de Laboratorio");
        message.putExtra(Intent.EXTRA_TEXT, EmailBody);
        message.setType("plain/text");
        startActivity(Intent.createChooser(message,"Enviando e-mail..."));
    }

}
