package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogNewItemWNActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_item_wn);
    }

    public void onClickADDITEMTOLOGGER(View v) {

        Intent intent = new Intent(LogNewItemWNActivity.this, LogWNActivity.class);
        startActivity(intent);
    }
}