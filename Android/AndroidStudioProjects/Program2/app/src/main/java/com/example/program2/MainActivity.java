package com.example.program2;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText id, name, age, address;
    Button insert, search;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.idId);
        name = findViewById(R.id.idName);
        age = findViewById(R.id.idAge);
        address = findViewById(R.id.idAddress);
        insert = findViewById(R.id.idInsert);
        search = findViewById(R.id.idSearch);
        insert.setOnClickListener(this);
        search.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(insert)) {
            String idStr = id.getText().toString();
            String nameStr = name.getText().toString();
            String ageStr = age.getText().toString();
            String addressStr = address.getText().toString();
            Database db = new Database(this, Database.DATABASE_NAME, null, 1);
            SQLiteDatabase mydb = db.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("ID", idStr);
            cv.put("NAME", nameStr);
            cv.put("AGE", ageStr);
            cv.put("ADDRESS", addressStr);
            mydb.insert(Database.TABLE_NAME, null, cv);
            mydb.close();
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        else if(v.equals(search)) {
            Toast.makeText(this, "Search Activity", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, SearchActivity.class);
            startActivity(it);
        }
    }
}