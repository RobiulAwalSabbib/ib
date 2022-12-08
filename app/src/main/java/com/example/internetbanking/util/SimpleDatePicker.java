package com.example.internetbanking.util;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    Activity context;

    EditText editText;


    public SimpleDatePicker(){

    }


    static public SimpleDatePicker getInstance(Activity activity, EditText textView){
        SimpleDatePicker datePicker = new SimpleDatePicker();
        datePicker.context = activity;
        datePicker.editText = textView;
        return datePicker;
    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Log.e("Date","On Create" );

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);

    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {


        Calendar c = Calendar.getInstance();
        c.set(year, monthOfYear, dayOfMonth);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = "";
        formattedDate = sdf.format(c.getTime());

        Log.e("Date",dayOfMonth+"/"+monthOfYear+"/"+year );

        //editText.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
        editText.setText(formattedDate.toUpperCase());


    }
}
