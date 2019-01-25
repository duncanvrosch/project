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

public class LogNewItemWNActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_item_wn);
    }

    public void onClickADDITEMTOLOGGER(View v) {

        EditText titleEdit = findViewById(R.id.etTitle);
        String title = titleEdit.getText().toString();
        EditText nameEdit = findViewById(R.id.etName);
        String name = nameEdit.getText().toString();
        EditText descriptionEdit = findViewById(R.id.etDescription);
        String description = descriptionEdit.getText().toString();
        EditText priorityEdit = findViewById(R.id.etPriority);
        String priority = priorityEdit.getText().toString();

        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm").format(Calendar.getInstance().getTime());

        if("high".equals(priority) || "medium".equals(priority) || "low".equals(priority)){
            LoggerPost post = new LoggerPost(LogNewItemWNActivity.this);
            post.postLogger(LogNewItemWNActivity.this, title, name, description, priority, timestamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(LogNewItemWNActivity.this, LogWNActivity.class);
            startActivity(intent);
        }

        else{
            Toast.makeText(getApplicationContext(), "Only use 'high' , 'medium' or 'low' as input for priority!", Toast.LENGTH_LONG).show();
        }
    }
}
