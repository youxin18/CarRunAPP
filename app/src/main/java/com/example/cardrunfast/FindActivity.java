package com.example.cardrunfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

public class FindActivity extends AppCompatActivity {
    private RelativeLayout mWordRootLayout;
    private RelativeLayout mMeRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_find);
        mWordRootLayout=findViewById(R.id.word_root);
        mMeRootLayout=findViewById(R.id.me_root);
        mMeRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });
        mWordRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
    }
}