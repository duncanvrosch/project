package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ToDoListWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_wg);
    }

    public void onClickNEWTODOITEM(View v) {

        Intent intent = new Intent(ToDoListWGActivity.this, ToDoNewItemWGActivity.class);
        startActivity(intent);
    }
}
