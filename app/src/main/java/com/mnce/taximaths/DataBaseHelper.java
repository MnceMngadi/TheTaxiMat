package com.mnce.taximaths;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "taxiFare.db";
    public static final String TABLE_NAME = "taxiFare_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "FROM1";
    public static final String COL3 = "TO1";
    public static final String COL4 = "FARE";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FARE TEXT, FROM1 TEXT, TO1 TEXT) ");
        String createTable = "create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FROM1 TEXT, TO1 TEXT ,FARE TEXT) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);

        // onCreate(db);

    }

    public boolean addData(String fare, String from, String to){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, from);
        contentValues.put(COL3, to);
        contentValues.put(COL4, fare);

        long relsult = db.insert(TABLE_NAME, null, contentValues);

        if(relsult == -1){

            return false;
        }else {

            return true;
        }
    }

    public Cursor getListContent(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return data;

    }




} // end of DBHelper




