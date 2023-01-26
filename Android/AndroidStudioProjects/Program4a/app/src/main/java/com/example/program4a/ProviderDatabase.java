package com.example.program4a;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class ProviderDatabase extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "notes.db";
    public static String TABLE_NAME = "notes";
    public ProviderDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (date TEXT, note TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
}