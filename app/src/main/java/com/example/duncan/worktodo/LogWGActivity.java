package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_wg);
    }

    public void onClickNEWLOGITEM(View v) {

        Intent intent = new Intent(LogWGActivity.this, LogNewItemWGActivity.class);
        startActivity(intent);
    }
}
