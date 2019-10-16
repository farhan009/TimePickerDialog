package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView_id);
        button = findViewById(R.id.button_id);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final TimePicker timePicker = new TimePicker(this);
        int currentHours = timePicker.getCurrentHour();
        final int currentMunites = timePicker.getCurrentMinute();

        timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textView.setText(hourOfDay + " : " + minute);
                    }
                }, currentHours, currentMunites, true
        );  timePickerDialog.show();
    }
}
