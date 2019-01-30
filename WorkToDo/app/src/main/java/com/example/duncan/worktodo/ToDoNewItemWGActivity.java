package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ToDoNewItemWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_new_item_wg);
    }

    public void onClickAddItemToToDoList(View v) {

        // grab info
        EditText titleEdit = findViewById(R.id.etTitle);
        String title = titleEdit.getText().toString();
        EditText nameEdit = findViewById(R.id.etName);
        String name = nameEdit.getText().toString();
        EditText descriptionEdit = findViewById(R.id.etDescription);
        String description = descriptionEdit.getText().toString();
        EditText priorityEdit = findViewById(R.id.etPriority);
        String priority = priorityEdit.getText().toString();

        // make a timestamp
        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm").format(Calendar.getInstance().getTime());

        // only three options available when entering a priority
        if("high".equals(priority) || "medium".equals(priority) || "low".equals(priority)){
            ToDoPost post = new ToDoPost(ToDoNewItemWGActivity.this);

            // post item to logger
            post.postLogger(ToDoNewItemWGActivity.this, title, name, description, priority, timestamp);

            // delay of 1 second
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(ToDoNewItemWGActivity.this, ToDoListWGActivity.class);
            startActivity(intent);
        }

        // wrong input in priority field
        else{
            Toast.makeText(getApplicationContext(), "Only use 'high' , 'medium' or 'low' as input for priority!", Toast.LENGTH_LONG).show();
        }
    }
}

