package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class NotesProvider extends ContentProvider
{
    SQLiteDatabase db;
    ProviderDatabase dbHelper;
    @Override
    public int delete(Uri arg0, String arg1, String[] arg2) {
        return 0;
    }
    @Override
    public String getType(Uri arg0) {
        return null;
    }
    @Override
    public Uri insert(Uri arg0, ContentValues cv) {
        db = dbHelper.getWritableDatabase();
        db.insert(ProviderDatabase.TABLE_NAME,null,cv);
        db.close();
        return null;
    }
    @Override
    public boolean onCreate() {
        dbHelper=new
                ProviderDatabase(getContext(),ProviderDatabase.DATABASE_NAME+".db",null,1);
        return (db == null)? false:true;
    }
    @Override
    public Cursor query(Uri uri, String[] arg1, String arg2, String[] arg3,
                        String arg4) {
        Cursor cursor=null;
        db = dbHelper.getReadableDatabase();
        cursor=
                db.query(ProviderDatabase.TABLE_NAME,arg1,arg2,arg3,arg4,null,null);
        return cursor;
    }
    @Override
    public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
        return 0;
    }
}