package com.example.contentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtDate,txtContent;
    Button btnAddNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDate=(EditText)findViewById(R.id.txt_date);
        txtContent=(EditText)findViewById(R.id.txt_Content);
        btnAddNote=(Button)findViewById(R.id.btn_add_note);
        btnAddNote.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(btnAddNote))
        {
            String sdate=txtDate.getText().toString();
            String scontent=txtContent.getText().toString();
            ContentValues values = new ContentValues();
            values.put("note_date",sdate);
            values.put("content",scontent);
            getContentResolver().insert(Uri.parse("content://com.example.noteprovider/notes"), values);
            Toast.makeText(getBaseContext(),"Data Inserted Successfully",
                    Toast.LENGTH_LONG).show();
        }
    }

}