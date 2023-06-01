package com.example.sit708_my_application_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper

{
    public DBConnector(Context context){
        super(context,"DB_ITEMS",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table Items (ItemID INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR,Phone VARCHAR,Description VARCHAR,DATE VARCHAR,Location VARCHAR, PostType INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
