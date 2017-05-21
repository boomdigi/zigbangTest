package com.homework.hsj.zigbanghomework.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by boomd on 2017-05-16.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    private static DBHelper dbHelper;
    private SQLiteDatabase mSQLiteDatabase = null;

    public static DBHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }

    public DBHelper(Context context) {
        super(context, "Homework.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE KEYWORDS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "keyword TEXT NOT NULL UNIQUE" +
                ");");
    }

    public SQLiteDatabase open() {
        if (mSQLiteDatabase == null || !mSQLiteDatabase.isOpen()) {
            mSQLiteDatabase = getWritableDatabase();
        }
        return mSQLiteDatabase;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public synchronized void insertKeyword(String keyword) {
        SQLiteDatabase db;

        db = open();
        db.beginTransaction();
        Cursor cursor = null;

        try {
            db.execSQL("insert into KEYWORDS values (" +
                    "null," +
                    "'" + keyword + "');");

            cursor = db.rawQuery("SELECT * from KEYWORDS", null); // order by _index ASC
            cursor.moveToFirst();

            if (cursor.getCount() > 20) {
                db.execSQL("delete from KEYWORDS where _index = " + cursor.getInt(0) + ";");
            }

        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public synchronized void deleteKeyword(int index) {
        SQLiteDatabase db;

        db = open();
        db.beginTransaction();
        db.execSQL("delete from KEYWORDS where _index = " + index + ";");
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public synchronized void deleteAll() {
        SQLiteDatabase db;

        db = open();
        db.beginTransaction();
        db.execSQL("delete from KEYWORDS");
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public synchronized ArrayList<Pair<Integer, String>> getKeywords() {

        ArrayList<Pair<Integer, String>> returnArr = new ArrayList<>();
        SQLiteDatabase db;

        db = open();
        db.beginTransaction();

        Cursor cursor = db.rawQuery("SELECT * from KEYWORDS", null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                returnArr.add(new Pair<>(cursor.getInt(0), cursor.getString(1)));
            }
            cursor.close();
        }

        db.setTransactionSuccessful();
        db.endTransaction();

        return returnArr;
    }
}