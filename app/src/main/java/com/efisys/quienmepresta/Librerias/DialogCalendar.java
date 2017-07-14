package com.efisys.quienmepresta.Librerias;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;

import com.efisys.quienmepresta.PerfilVista;


public class DialogCalendar {
    private PerfilVista bitacoraActivity;
    private Dialog dialog;

    public DialogCalendar(PerfilVista bitacoraActivity, int mYear, int mMonth, int mDay){
        this.bitacoraActivity=bitacoraActivity;
        dialog = new DatePickerDialog(bitacoraActivity, mDateSetListener, mYear, mMonth-1, mDay);
    }

    public void showDialog(){
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    if (view.isShown()) {
                        bitacoraActivity.updateDisplay(year, monthOfYear+1, dayOfMonth);
                    }
                }
            };

}
