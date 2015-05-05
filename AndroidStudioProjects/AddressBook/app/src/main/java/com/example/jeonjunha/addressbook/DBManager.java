package com.example.jeonjunha.addressbook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeonjunha on 15. 5. 5..
 */
public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
    //새로운 테이블 생성
    //create table 테이블명(컬럼명 타입 옵션);
    db.execSQL("CREATE TABLE ADDRESS_LIST(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, number INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS ADDRESS_TABLE");
        onCreate(db);
    }

    //insert
    public void insert(String _query){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    //reset

    public void reset(String _query){

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    //결과표시
    public String PrintData(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from ADDRESS_LIST", null);
        while(cursor.moveToNext()){
            str += cursor.getInt(0)
                + " : name "
                + cursor.getString(1)
                + ", number = "
                + cursor.getString(2)
                + "\n";
        }

        return str;
    }

}

