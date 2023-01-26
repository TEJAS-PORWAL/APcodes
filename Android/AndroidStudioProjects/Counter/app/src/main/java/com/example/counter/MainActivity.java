package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView display;
    Button start, stop;
    Thread th;
    int count = 0;
    Boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.idDisplay);
        start = findViewById(R.id.idStart);
        stop = findViewById(R.id.idStop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(start)){
            isRunning = true;
            th = new Thread(() -> {
                while(isRunning){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    display.setText(String.valueOf(count));
                }
            });
            th.start();
        }
        else if(v.equals(stop)){
            isRunning = false;
        }
    }
}
