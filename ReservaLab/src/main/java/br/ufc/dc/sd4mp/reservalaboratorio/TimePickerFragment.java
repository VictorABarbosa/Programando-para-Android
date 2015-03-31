package br.ufc.dc.sd4mp.reservalaboratorio;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

// ESCOLHER HORARIO
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    private Button timeText;
    private int chosen_hour, chosen_minute;


    public TimePickerFragment() {
        chosen_hour = 0;
        chosen_minute = 0;
    }

    public void setTimeReference(Button time) {
        this.timeText = time;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hour, minute;
        final Calendar calendar = Calendar.getInstance();

        if (chosen_hour == 0) hour = calendar.get(Calendar.HOUR_OF_DAY);
        else hour = chosen_hour;
        if (chosen_minute == 0) minute = calendar.get(Calendar.MINUTE);
        else minute = chosen_minute;

        chosen_hour = hour;
        chosen_minute = minute;

        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    public void onTimeSet(TimePicker view, final int hour, final int minute){
        chosen_hour = hour;
        chosen_minute = minute;
        timeText.post(new Runnable() {
            @Override
            public void run() {
                CharSequence charset = "";
                if (minute == 0) charset = "" + hour + "h" + " - Alterar horário";
                else charset = "" + hour + "h" + minute + " - Alterar horário";
                timeText.setText(charset);
            }
        });
    }

    public int getChosenHour(){
        return chosen_hour;
    }

    public int getChosenMinute(){
        return chosen_minute;
    }
}
