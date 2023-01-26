package com.example.program2;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "employee.db";
    public static final String TABLE_NAME = "employee_table";
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID TEXT, NAME TEXT, AGE TEXT, ADDRESS TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
}