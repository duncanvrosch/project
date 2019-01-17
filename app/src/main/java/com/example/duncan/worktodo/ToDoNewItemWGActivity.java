package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class ToDoNewItemWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_new_item_wg);
    }

    public void onClickADDITEMTOTODOLIST(View v) {

        EditText titleEdit = findViewById(R.id.etTitle);
        String title = titleEdit.getText().toString();
        EditText nameEdit = findViewById(R.id.etName);
        String name = nameEdit.getText().toString();
        EditText descriptionEdit = findViewById(R.id.etDescription);
        String description = descriptionEdit.getText().toString();
        EditText priorityEdit = findViewById(R.id.etPriority);
        String priority = priorityEdit.getText().toString();

        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm").format(Calendar.getInstance().getTime());

        ToDoPost post = new ToDoPost(ToDoNewItemWGActivity.this);
        post.postLogger(ToDoNewItemWGActivity.this, title, name, description, priority, timestamp);

        Intent intent = new Intent(ToDoNewItemWGActivity.this, ToDoListWGActivity.class);
        startActivity(intent);
    }
}
