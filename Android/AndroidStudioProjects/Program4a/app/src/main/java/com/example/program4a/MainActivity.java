package com.example.program4a;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText date, note;
    Button add;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.idDate);
        note = findViewById(R.id.idNote);
        add = findViewById(R.id.idAdd);
        add.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(add)){
            String dateText = date.getText().toString();
            String noteText = note.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("date", dateText);
            cv.put("note", noteText);
            getContentResolver().insert(NotesProvider.CONTENT_URI, cv);
            Toast.makeText(getBaseContext(), "Note added", Toast.LENGTH_SHORT).show();
        }
    }
}