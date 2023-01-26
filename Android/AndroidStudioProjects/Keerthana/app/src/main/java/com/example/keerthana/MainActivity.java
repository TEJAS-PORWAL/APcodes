package com.example.keerthana;

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
    Button btnjson;
    TextView txtresult;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        btnjson = findViewById(R.id.btn_1);
        txtresult = findViewById(R.id.txt_result);
        btnjson.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.equals(btnjson)) {
            try {
                JSONObject obj = new JSONObject();
                InputStream is = getAssets().open("sample.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String json = new String(buffer, StandardCharsets.UTF_8);
                JSONArray array = new JSONArray(json);
                txtresult.setText("");
                for (int i = 0; i < array.length(); i++) {
                    obj = array.getJSONObject(i);
                    String city = obj.getString("city");
                    String latitude = obj.getString("latitude");
                    String longitude = obj.getString("longitude");
                    String temperature = obj.getString("temperature");
                    String humidity = obj.getString("humidity");
                    txtresult.append("\nCity Name: " + city + "\nLatitude: " + latitude + "\nLongitude: " + longitude + "\nTemperature: " + temperature + "\nHumidity: " + humidity + "\n");
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
