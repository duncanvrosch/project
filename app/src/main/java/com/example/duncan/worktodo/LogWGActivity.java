package com.example.duncan.worktodo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class LogWGActivity extends AppCompatActivity implements LoggerHelper.Callback {

    ArrayList<Score> highscoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_wg);

        LoggerHelper helper = new LoggerHelper(this);
        helper.getScore(this);

        ListView lv = findViewById(R.id.scores);
        lv.setOnItemClickListener(new SelectItemClickListener());
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

    private class SelectItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Score item = (Score) parent.getItemAtPosition(position);

            Intent intent = new Intent(LogWGActivity.this, LogDetailWGActivity.class);
            intent.putExtra("selected_item", item);
            startActivity(intent);
        }
    }


    public void onClickNEWLOGITEM(View v) {

        Intent intent = new Intent(LogWGActivity.this, LogNewItemWGActivity.class);
        startActivity(intent);
    }

    public void onClickTODONELIST(View v) {

        Intent intent = new Intent(LogWGActivity.this, LogNewItemWGActivity.class);
        startActivity(intent);
    }

    public void onClickBACKTOMENU(View v) {

        Intent intent = new Intent(LogWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LogWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }
}
