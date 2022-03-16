package com.example.cardrunfast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

public class FirstActivity extends AppCompatActivity {
    private LinearLayout mbuttonStartLayout;
    private RelativeLayout mWordRootLayout;
    private RelativeLayout mFindRootLayout;
    private RelativeLayout mMeRootLayout;
    private RelativeLayout mWordCardBoxLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_first);
        mbuttonStartLayout = findViewById(R.id.button_start);
        mWordRootLayout=findViewById(R.id.word_root);
        mFindRootLayout=findViewById(R.id.find_root);
        mMeRootLayout=findViewById(R.id.me_root);
        //开始
        mbuttonStartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        //底部发现
        mFindRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,FindActivity.class);
                startActivity(intent);

            }
        });
        //底部我的
        mMeRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });
        //阅读外刊
        RelativeLayout read=findViewById(R.id.read_other);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,ReadActivity.class);
                startActivity(intent);
            }
        });
        //单词卡片
        mWordCardBoxLayout=findViewById(R.id.word_card_box);
        mWordCardBoxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FirstActivity.this,WordCardActivity.class);
                startActivity(intent);
            }
        });
    }

        private void dialog() {
            AlertDialog.Builder builder=new AlertDialog.Builder(FirstActivity.this,R.style.shareDialog);
            final AlertDialog dialog=builder
                    .setView(R.layout.dialog_activity)
                    .setCancelable(false)
                    .create();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
            dialog.getWindow().findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_LONG).show();
                }
            });
            dialog.getWindow().findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }


    }


