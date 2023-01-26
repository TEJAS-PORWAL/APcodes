package com.example.program1b;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    EditText text;
    Button speak;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.idText);
        speak = findViewById(R.id.idSpeak);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = text.getText().toString();
                Toast.makeText(getBaseContext(),toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}