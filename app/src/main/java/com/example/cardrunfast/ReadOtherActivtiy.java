package com.example.cardrunfast;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ReadOtherActivtiy extends AppCompatActivity {
    private ReadOtherSQLiteOpenHelper dataHelper;
    private SQLiteDatabase aa;
    private List<Sentence>sentences=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_other);
        dataHelper=new ReadOtherSQLiteOpenHelper(this,"Sentences.db",null,1);
        aa=dataHelper.getReadableDatabase();

        //putData();
        loadData();

    }
    @SuppressLint("Range")
    private void loadData() {
       Cursor cursor= aa.query("sentences",null,null,null,null,null,null);
       if(cursor.moveToFirst()){
           do{
               String sentence=cursor.getString(cursor.getColumnIndex("sentence"));
               String chinese=cursor.getString(cursor.getColumnIndex("chinese"));
               Sentence data=new Sentence(sentence,chinese);
               sentences.add(data);


           }while (cursor.moveToNext());
       }
       cursor.close();

    }

    private void putData() {
        ContentValues values=new ContentValues();
        values.put("sentence","Bow that is the most gentle, like a lotus cool shy");
        values.put("chinese","最是那一低头的温柔，恰似一朵水莲花不胜凉风的娇羞");
        aa.insert("sentences",null, values);
        values.clear();
        values.put("sentence","Spring born, spring forest Chusheng, ten in the spring, as you.");
        values.put("chinese","春水初生，春林初盛，春风十里，不如你。");
        aa.insert("sentences",null, values);
        values.clear();
        values.put("sentence","Give time, let the past pass.");
        values.put("chinese","给时间时间，让过去过去");
        aa.insert("sentences",null, values);
        values.clear();


    }
}