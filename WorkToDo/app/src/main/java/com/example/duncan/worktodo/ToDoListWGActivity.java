package com.example.duncan.worktodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ToDoListWGActivity extends AppCompatActivity implements LoggerHelper.Callback {

    ArrayList<Helper> highscoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_wg);

        ToDoHelper helper = new ToDoHelper(this);
        helper.getScore(this);

        ListView lv = findViewById(R.id.scores);
        lv.setOnItemClickListener(new SelectItemClickListener());
    }

    @Override
    public void gotScore(ArrayList<Helper> highscoresList) {
        this.highscoresList = highscoresList;
        ListView highscores = findViewById(R.id.scores);
        ToDoAdapter adapter = new ToDoAdapter(this, highscoresList);
        highscores.setAdapter(adapter);
    }

    @Override
    public void gotScoreError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private class SelectItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Helper item = (Helper) parent.getItemAtPosition(position);

            Intent intent = new Intent(ToDoListWGActivity.this, ToDoListDetailWGActivity.class);
            intent.putExtra("selected_item", item);
            startActivity(intent);
        }
    }

    public void onClickNEWTODOITEM(View v) {

        Intent intent = new Intent(ToDoListWGActivity.this, ToDoNewItemWGActivity.class);
        startActivity(intent);
    }

    public void onClickBACKTOMENU(View v) {

        Intent intent = new Intent(ToDoListWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ToDoListWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }
}
