package com.example.program2;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    EditText id;
    Button search;
    TextView display;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_search);
        id = findViewById(R.id.idId);
        search = findViewById(R.id.idSearch);
        display = findViewById(R.id.idDisplay);
        search.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.equals(search)) {
            String idStr = id.getText().toString();
            Database db = new Database(this, Database.DATABASE_NAME, null, 1);
            SQLiteDatabase mydb = db.getReadableDatabase();
            String[] columns = {"ID", "NAME", "AGE", "ADDRESS"};
            String[] selectionArgs = {idStr};
            String selection = "ID = ?";
            Cursor c = mydb.query(Database.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            display.setText("");
            if(c.moveToNext()) {
                display.append(idStr + " " + c.getString(1) + " " + c.getString(2) + " " + c.getString(3) + "\n");
            }
            else {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }
    }
}