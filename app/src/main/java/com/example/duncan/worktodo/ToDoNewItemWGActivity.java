package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ToDoNewItemWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_new_item_wg);
    }

    public void onClickADDITEMTODOLIST(View v) {

        Intent intent = new Intent(ToDoNewItemWGActivity.this, ToDoListWGActivity.class);
        startActivity(intent);
    }
}
