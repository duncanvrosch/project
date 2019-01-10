package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogNewItemWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_item_wg);
    }

    public void onClickADDITEMTOLOGGER(View v) {

        Intent intent = new Intent(LogNewItemWGActivity.this, LogWGActivity.class);
        startActivity(intent);
    }
}
