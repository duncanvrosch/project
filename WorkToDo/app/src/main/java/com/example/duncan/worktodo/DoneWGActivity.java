package com.example.duncan.worktodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class DoneWGActivity extends AppCompatActivity implements LoggerHelper.Callback {

    ArrayList<Helper> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_wg);

        LoggerHelper helper = new LoggerHelper(this);
        helper.getScore(this);

        ListView lv = findViewById(R.id.items);
        lv.setOnItemClickListener(new SelectItemClickListener());
    }

    // make to do items visible in list
    @Override
    public void gotScore(ArrayList<Helper> itemList) {
        this.itemList = itemList;
        ListView items = findViewById(R.id.items);
        DoneAdapter adapter = new DoneAdapter(this, itemList);
        items.setAdapter(adapter);
    }

    @Override
    public void gotScoreError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // show detail activity when specific item is clicked
    private class SelectItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Helper item = (Helper) parent.getItemAtPosition(position);

            Intent intent = new Intent(DoneWGActivity.this, DoneDetailWGActivity.class);
            intent.putExtra("selected_item", item);
            startActivity(intent);
        }
    }

    // back to menu when button is clicked
    public void onClickBackToMenu(View v) {
        Intent intent = new Intent(DoneWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }

    // back to menu when backbutton is clicked
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DoneWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }
}
