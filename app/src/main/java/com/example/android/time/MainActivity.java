package com.example.android.time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generatetimestable(int timestable){
        ArrayList <String>timestablecontent=new ArrayList<String>();
        for(int i=1;i<=10;i++){

            timestablecontent.add(Integer.toString(i*timestable));
        }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timestablecontent);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar= (SeekBar)findViewById(R.id.seekBar);
         listView=(ListView)findViewById(R.id.listView2);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timestable;
                if(i<min) {
                    timestable = min;
                    seekBar.setProgress(min);
                }
                            else
                                timestable=i;
                generatetimestable(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generatetimestable(10);

    }
}
