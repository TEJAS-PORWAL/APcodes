package com.example.program6;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    TextView number, message;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.idNumber);
        message = findViewById(R.id.idMessage);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            number.setText(bundle.getString("num"));
            message.setText(bundle.getString("msg"));
        }
    }
}