package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ToDoListWNActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_wn);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ToDoListWNActivity.this, MenuWNActivity.class);
        startActivity(intent);
    }
}

