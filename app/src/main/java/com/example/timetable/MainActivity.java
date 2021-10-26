package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimesTable(int timeTableNumber){

        ArrayList<String> timeTableContent = new ArrayList<String>();
        for (int j = 1; j<=10; j++){
            timeTableContent.add(Integer.toString(j * timeTableNumber));
        }
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timeTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTableListView = findViewById(R.id.timesTableListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if (i < min){
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                }else{
                    timesTableNumber = i;
                }
                Log.i("Seekbar Value",Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}