package com.example.cardrunfast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WordCardActivity extends AppCompatActivity {
    private List<Card> cardList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_word_card);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView_has_studied=findViewById(R.id.fragment_box);
        ImageView back=findViewById(R.id.back_arrow);

       //MyDatabaseHelper dbHelper=new MyDatabaseHelper(this,"WordCard.db",null,1);
        //dbHelper.getWritableDatabase();
    //  putData();
        loadData();
        //replaceFragment(new hasStudiedFragment(cardList));
  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_has_studied.setLayoutManager(layoutManager);
        WordCardAdapter adapter = new WordCardAdapter(cardList);
        recyclerView_has_studied.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WordCardActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
        //点击已学单词
        LinearLayout noStudy=findViewById(R.id.no_study);
        noStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(WordCardActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                WordCardAdapter adapter = new WordCardAdapter(cardList);
                recyclerView.setAdapter(adapter);
                replaceFragment(new noStudiedFragment(cardList));

            }
        });



    }
    @SuppressLint("Range")
    private void loadData() {
        MyDatabaseHelper dbHelper=new MyDatabaseHelper(this,"WordCard.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
         Cursor   cursor = db.query("card", null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    Card card = new Card(id, name, number);
                    cardList.add(card);




                } while (cursor.moveToNext());

            }
                cursor.close();
            }
    private void putData(){
        MyDatabaseHelper dbHelper=new MyDatabaseHelper(this,"WordCard.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("name","YX1");
        values.put("number","游欣1");
        db.insert("card",null,values);
        values.clear();
        values.put("name","YX2");
        values.put("number","游欣2");
        db.insert("card",null,values);
        values.clear();
        values.put("name","YX3");
        values.put("number","游欣3");
        db.insert("card",null,values);
        values.clear();
        values.put("name","YX4");
        values.put("number","游欣4");
        db.insert("card",null,values);

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_box,fragment);
        transaction.commit();




    }
    



}