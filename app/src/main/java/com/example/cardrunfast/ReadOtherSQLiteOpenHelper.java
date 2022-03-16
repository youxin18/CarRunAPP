package com.example.cardrunfast;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ReadOtherSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String CREATE_SENTENCES="create table sentences("+"sentence text,"+"chinese text)";
    private Context mContext;
    public ReadOtherSQLiteOpenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context, name, factory, version);
        mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SENTENCES);
        Toast.makeText(mContext,"Created Succeeded",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
