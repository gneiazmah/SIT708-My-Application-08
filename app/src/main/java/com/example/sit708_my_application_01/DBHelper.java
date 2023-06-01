package com.example.sit708_my_application_01;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private Context con;

    private SQLiteDatabase db;

    public DBHelper(Context con){
        super(con, "DB_ITEMS", null, 1);
        this.con=con;
    }

    public DBHelper OpenDB(){
        DBConnector dbCon=new DBConnector(con);
        db=dbCon.getWritableDatabase();
        return this;
    }

    public boolean CreateNewItem(Items itemClass){
        try
        {
            db.execSQL("insert into Items values('"+itemClass.getID()+"','"+itemClass.getName()+"','"+itemClass.getPhone()+"','"+itemClass.getDescription()+"','"+itemClass.getDate()+"' ,'"+itemClass.getLocation()+"','"+itemClass.getPostType()+"')");
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public Cursor SearchAllProduct()
    {
        Cursor cursor=null;
        try {
            cursor=db.rawQuery("Select Name from Items ", null);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cursor;
    }


    public ArrayList<Items> SearchProduct(Integer ProductID)
    {
        ArrayList<Items> productList = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery("Select * from Items where ItemID='" + ProductID + "' ", null);
            if (cursor.moveToFirst()) {
                do {
                    Items items = new Items();
                    items.setID(cursor.getInt(0));
                    items.setName(cursor.getString(1));
                    items.setDate(cursor.getString(2));
                    items.setLocation(cursor.getString(3));
                    items.setPostType(cursor.getInt(4));
                    productList.add(items);

                } while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return productList;
    }


    public Integer removeItemData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Items", "ItemID = ?", new String[]{id});
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

