package com.example.flatownerapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;

public class FlatOwnerDBHelper extends SQLiteOpenHelper {
    public FlatOwnerDBHelper(@Nullable Context context) {

        super(context, "flatdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE flat(flatno TEXT,name TEXT,flatholdertype TEXT,carpet TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertFlatOwner(FlatOwner flatOwner) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("flatno", flatOwner.getFlatno());
        values.put("name", flatOwner.getName());
        values.put("flatholdertype", flatOwner.getFlatholdertype());
        values.put("carpet", flatOwner.getCarpet());

        db.insert("flat", null, values);
    }


    public void getListVechicle(List<FlatOwner> flatOwnerList) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("flat", null, null, null, null, null, null);

        while (cursor.moveToNext()) {


            String flatno = cursor.getString(0);
            String name = cursor.getString(1);
            String flatholdertype = cursor.getString(2);
            String capret = cursor.getString(3);


            FlatOwner flatOwner = new FlatOwner(flatno, name, flatholdertype, capret);

            flatOwnerList.add(flatOwner);
        }

    }
}
