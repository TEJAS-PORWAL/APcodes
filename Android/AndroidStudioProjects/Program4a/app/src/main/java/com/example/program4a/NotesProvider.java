package com.example.program4a;
import android.net.Uri;
import android.database.Cursor;
import android.content.ContentValues;
import android.content.ContentProvider;
import android.database.sqlite.SQLiteDatabase;
public class NotesProvider extends ContentProvider {
    static String AUTHORITY = "com.example.notesprovider";
    static String BASE_PATH = "notes";
    static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    ProviderDatabase dbHelper;
    SQLiteDatabase db;
    @Override
    public boolean onCreate() {
        dbHelper = new ProviderDatabase(getContext(), ProviderDatabase.DATABASE_NAME, null, 1);
        return (db == null) ? false : true;
    }
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        db = dbHelper.getReadableDatabase();
        Cursor c = db.query(ProviderDatabase.TABLE_NAME, strings, s, strings1, null, null, null);
        return c;
    }
    @Override
    public String getType(Uri uri) {
        return null;
    }
    @Override
    public Uri insert(Uri uri, ContentValues cv) {
        db = dbHelper.getWritableDatabase();
        db.insert(ProviderDatabase.TABLE_NAME, null, cv);
        db.close();
        return null;
    }
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }
    @Override
    public int update(Uri uri, ContentValues cv, String s, String[] strings) {
        return 0;
    }
}