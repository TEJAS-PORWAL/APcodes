package com.example.program5;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    Thread th;
    int count = 0;
    TextView display;
    Button start, stop;
    Boolean isRunning = false;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
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
            th = new Thread(this);
            th.start();
        }
        else if(v.equals(stop)){
            isRunning = false;
        }
    }
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            display.setText(""+msg.what);
        }
    };
    public void run(){
        while(isRunning){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            h.sendEmptyMessage(count);
        }
    }
}