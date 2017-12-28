package com.arkadiy.enter.imenu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by vadnu on 25/12/2017.
 */

public class DataConfig  extends SQLiteOpenHelper {


    private static final int VERSION=1;
    private static final String DB_NAME ="PRODUCTS";
    private  String table_name ="beers";
    private SQLiteDatabase myDb=null;

    LinkedList <String> list=null;

    private String create_products= create_products ="CREATE TABLE "+ table_name+ "(_id INTEGER NOT NULL PRIMARY KEY, "+
            "drinkName TEXT NOT NULL, "+
            "price REAL NOT NULL)";;

    private String insert_query ="";





    public DataConfig(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_products);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ table_name);

        this.onCreate(db);

    }

    public void setInsertQuery2(String tableName,String name,float price){
        table_name=tableName;
        String insert_query2=  "INSERT INTO " +table_name+
                "(drinkName,price) "+
                "VALUES"+
                "('"+name+"',"+price+")";
        myDb.execSQL(insert_query2);

    }


    public LinkedList<String> getDataFromDataBase(String categoryName){
         list= new LinkedList<String>();

        Cursor cursor=myDb.rawQuery("SELECT * FROM "+categoryName,null);
        if(cursor.moveToFirst())
        {
            String record="";
            do{
                record=String.format("%s",cursor.getString(1));
                list.add(record);
                record="";

            }while(cursor.moveToNext());
        }
        return list;
    }

    public void createNewProductsTable(String tableName)
    {
        table_name=tableName;
        create_products ="CREATE TABLE "+ table_name+ "(_id INTEGER NOT NULL PRIMARY KEY, "+
            "drinkName TEXT NOT NULL, "+
            "price REAL NOT NULL)";

        myDb.execSQL(create_products);



    }

    public void setDb(SQLiteDatabase db){
        myDb=db;
    }


}
