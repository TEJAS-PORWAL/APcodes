package com.example.program7;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start, stop;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.idStart);
        stop = findViewById(R.id.idStop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(start)) {
            Intent it = new Intent(this,MyService.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isStart", true);
            it.putExtras(bundle);
            startService(it);
        }
        else if(v.equals(stop)) {
            Intent it = new Intent(this, MyService.class);
            stopService(it);
        }
    }
}