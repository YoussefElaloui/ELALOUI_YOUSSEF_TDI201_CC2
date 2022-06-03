package com.example.elaloui_youssef_tdi201_cc2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    public static String db_name="societes.db";
    public static String table_name="Societe";
    public static String col1="ID";
    public static String col2="Raison_Sociale";
    public static String col3="Secteur_activite";
    public static String col4="nb_employe";
    public MyDatabase(Context context){super(context,db_name,null,1);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql=String.format("create table %s(%s integer autoincrement primary key,%s text,%s text,%s integer)",table_name,col1,col2,col3,col4);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="drop table "+table_name;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long AddSociete(SQLiteDatabase db, Societe e){
        ContentValues cv=new ContentValues();
        cv.put(col2,e.getNom());
        cv.put(col3,e.getSecteur());
        cv.put(col4,e.getNbEmploye());
        return db.insert(table_name,null,cv);
    }


}
