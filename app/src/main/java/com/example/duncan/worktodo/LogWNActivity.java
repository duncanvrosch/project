package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogWNActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_wn);
    }

    public void onClickNEWLOGITEM(View v) {

        Intent intent = new Intent(LogWNActivity.this, LogNewItemWNActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LogWNActivity.this, MenuWNActivity.class);
        startActivity(intent);
    }
}
