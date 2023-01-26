package com.example.program9;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView display;
    Button one, two, three, four, five, six, seven, eight, nine, zero, star, hash, save, call, delete;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.idDisplay);
        one = findViewById(R.id.id1);
        two = findViewById(R.id.id2);
        three = findViewById(R.id.id3);
        four = findViewById(R.id.id4);
        five = findViewById(R.id.id5);
        six = findViewById(R.id.id6);
        seven = findViewById(R.id.id7);
        eight = findViewById(R.id.id8);
        nine = findViewById(R.id.id9);
        zero = findViewById(R.id.id0);
        star = findViewById(R.id.idStar);
        hash = findViewById(R.id.idHash);
        save = findViewById(R.id.idSave);
        call = findViewById(R.id.idCall);
        delete = findViewById(R.id.idDelete);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        star.setOnClickListener(this);
        hash.setOnClickListener(this);
        save.setOnClickListener(this);
        call.setOnClickListener(this);
        delete.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String numStr = display.getText().toString();
        switch (v.getId()){
            case R.id.id1:
                display.append("1");
                break;
            case R.id.id2:
                display.append("2");
                break;
            case R.id.id3:
                display.append("3");
                break;
            case R.id.id4:
                display.append("4");
                break;
            case R.id.id5:
                display.append("5");
                break;
            case R.id.id6:
                display.append("6");
                break;
            case R.id.id7:
                display.append("7");
                break;
            case R.id.id8:
                display.append("8");
                break;
            case R.id.id9:
                display.append("9");
                break;
            case R.id.id0:
                display.append("0");
                break;
            case R.id.idStar:
                display.append("*");
                break;
            case R.id.idHash:
                display.append("#");
                break;
            case R.id.idSave:
                Intent it1 = new Intent(Intent.ACTION_INSERT);
                it1.setType("vnd.android.cursor.dir/contact");
                it1.putExtra("phone", numStr);
                startActivity(it1);
                break;
            case R.id.idCall:
                Intent it2 = new Intent(Intent.ACTION_DIAL);
                it2.setData(Uri.parse("tel:"+numStr));
                startActivity(it2);
                break;
            case R.id.idDelete:
                if (numStr.length() > 0){
                    numStr = numStr.substring(0, numStr.length()-1);
                    display.setText(numStr);
                }
                break;
        }
    }
}