package com.example.program10;

import android.os.Bundle;
import android.view.View;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import android.widget.Button;
import org.json.JSONException;
import android.widget.TextView;
import java.nio.charset.StandardCharsets;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button parse;
    TextView display;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        parse = findViewById(R.id.idParse);
        display = findViewById(R.id.idDisplay);
        parse.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.equals(parse)) {
            try {
                JSONObject obj = new JSONObject();
                InputStream is = getAssets().open("sample.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String json = new String(buffer, StandardCharsets.UTF_8);
                JSONArray array = new JSONArray(json);
                display.setText("");
                for (int i = 0; i < array.length(); i++) {
                    obj = array.getJSONObject(i);
                    display.append("\nCity Name: " + obj.getString("city") + "\nLatitude: " + obj.getString("latitude") + "\nLongitude: " + obj.getString("longitude") + "\nTemperature: " + obj.getString("temperature") + "\nHumidity: " + obj.getString("humidity") + "\n");
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
    }
}