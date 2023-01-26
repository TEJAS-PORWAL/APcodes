package com.example.program4b;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText date;
    Button search;
    TextView display;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.idDate);
        search = findViewById(R.id.idSearch);
        display = findViewById(R.id.idDisplay);
        search.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(search)) {
            String searchDate = date.getText().toString();
            Uri uri = Uri.parse("content://com.example.notesprovider/notes");
            String[] columns = {"date", "note"};
            String selection = "date = ?";
            String[] selectionArgs = {searchDate};
            Cursor c = getContentResolver().query(uri, columns, selection, selectionArgs, null);
            if (c!=null && c.moveToNext()) {
                String dateText = c.getString(0);
                String noteText = c.getString(1);
                display.setText(dateText + " : " + noteText);
            } else {
                Toast.makeText(this, "No Note Found", Toast.LENGTH_SHORT).show();
            }
        }
    }
}