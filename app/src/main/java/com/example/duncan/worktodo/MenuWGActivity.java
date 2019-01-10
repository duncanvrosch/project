package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_wg);
    }

    public void onClickLOG(View v) {

        Intent intent = new Intent(MenuWGActivity.this, LogWGActivity.class);
        startActivity(intent);
    }

    public void onClickTODOLIST(View v) {

        Intent intent = new Intent(MenuWGActivity.this, ToDoListWGActivity.class);
        startActivity(intent);
    }

    public void onClickLOGOUT(View v) {

        Intent intent = new Intent(MenuWGActivity.this, LogInActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MenuWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }
}
