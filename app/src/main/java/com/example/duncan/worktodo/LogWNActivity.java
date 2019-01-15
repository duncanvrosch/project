package com.example.duncan.worktodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class LogWNActivity extends AppCompatActivity implements LoggerHelper.Callback {

    ArrayList<Score> highscoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_wn);

        LoggerHelper helper = new LoggerHelper(this);
        helper.getScore(this);
    }

    @Override
    public void gotScore(ArrayList<Score> highscoresList) {
        this.highscoresList = highscoresList;
        ListView highscores = findViewById(R.id.scores);
        LoggerAdapter adapter = new LoggerAdapter(this, highscoresList);
        highscores.setAdapter(adapter);
    }

    @Override
    public void gotScoreError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public void onClickNEWLOGITEM(View v) {

        Intent intent = new Intent(LogWNActivity.this, LogNewItemWNActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LogWNActivity.this, MenuWNActivity.class);
        startActivity(intent);
    }
}
