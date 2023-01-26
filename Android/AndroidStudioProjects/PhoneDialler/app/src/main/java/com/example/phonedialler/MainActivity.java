package com.example.phonedialler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView display;
    Button one, two, three, four, five, six, seven, eight, nine, zero, star, hash, save, call, delete; // clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
//        clear = findViewById(R.id.idClear);
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
//        clear.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String number = display.getText().toString();
        switch (view.getId()){
            case R.id.id1:
                display.setText(display.getText()+"1");
                break;
            case R.id.id2:
                display.setText(display.getText()+"2");
                break;
            case R.id.id3:
                display.setText(display.getText()+"3");
                break;
            case R.id.id4:
                display.setText(display.getText()+"4");
                break;
            case R.id.id5:
                display.setText(display.getText()+"5");
                break;
            case R.id.id6:
                display.setText(display.getText()+"6");
                break;
            case R.id.id7:
                display.setText(display.getText()+"7");
                break;
            case R.id.id8:
                display.setText(display.getText()+"8");
                break;
            case R.id.id9:
                display.setText(display.getText()+"9");
                break;
            case R.id.id0:
                display.setText(display.getText()+"0");
                break;
            case R.id.idStar:
                display.setText(display.getText()+"*");
                break;
            case R.id.idHash:
                display.setText(display.getText()+"#");
                break;
            case R.id.idSave:
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.dir/contact");
                intent.putExtra("phone", number);
                startActivity(intent);
                break;
            case R.id.idCall:
                Intent it = new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+number));
                startActivity(it);
                break;
            case R.id.idDelete:
                if (number.length() > 0){
                    number = number.substring(0, number.length()-1);
                    display.setText(number);
                }
                break;
//            case R.id.idClear:
//                display.setText("");
//                break;
        }
    }
}