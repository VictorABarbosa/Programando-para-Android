package br.ufc.dc.sd4mp.reservalaboratorio;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

// ESCOLHER DATA
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private Button dateText;
    private int chosen_year, chosen_month, chosen_day;

    public DatePickerFragment() {
        super();
        chosen_year = 0;
        chosen_month = 0;
        chosen_day = 0;
    }

    public void setDateReference(Button date) {
        this.dateText = date;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) { // Use the current date as the default values for the picker final Calendar calendar = Calendar.getInstance();
        int year, month, day;
        Calendar calendar = Calendar.getInstance();

        if (chosen_year == 0) year = calendar.get(Calendar.YEAR);
        else year = chosen_year;
        if (chosen_month == 0) month = calendar.get(Calendar.MONTH);
        else month = chosen_month;
        if (chosen_day == 0) day = calendar.get(Calendar.DAY_OF_MONTH);
        else day = chosen_day;

        chosen_day = day;
        chosen_month = month;
        chosen_year = year;

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, final int year, final int month, final int day) {
        chosen_year = year;
        chosen_month = month;
        chosen_day = day;
        dateText.post(new Runnable() {
            @Override
            public void run() {
                CharSequence charset = "" + day + "/" + (month + 1) + "/" + year + " - Alterar data";
                dateText.setText(charset);
            }
        });
    }

    public int getChosenYear(){
        return chosen_year;
    }

    public int getChosenMonth(){
        return chosen_month;
    }


    public int getChosenDay(){
        return chosen_day;
    }
}
