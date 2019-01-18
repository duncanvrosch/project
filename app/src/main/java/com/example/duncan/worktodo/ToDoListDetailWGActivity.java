package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ToDoListDetailWGActivity extends AppCompatActivity {

    Score score;
    int removalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_detail_wg);

        // grab item
        Intent intent = getIntent();
        Score selectedItem = (Score) intent.getSerializableExtra("selected_item");

        // grab info
        String title = selectedItem.getTitle();
        String description = selectedItem.getDescription();
        String name = selectedItem.getName();
        String timestamp = selectedItem.getTimestamp();
        String priority = selectedItem.getPriority();

        // place info
        TextView itemTitle = findViewById(R.id.entryTitle);
        TextView itemDescription = findViewById(R.id.entryDescription);
        TextView itemName = findViewById(R.id.entryName);
        TextView itemTimestamp = findViewById(R.id.entryDate);
        TextView itemPriority = findViewById(R.id.entryPriority);
        itemTitle.setText(title);
        itemDescription.setText(description);
        itemName.setText(name);
        itemTimestamp.setText(timestamp);
        itemPriority.setText(priority);
    }

    public void onClickDONETODOITEM(View v) {

        Intent intent = getIntent();
        final Score selectedItem = (Score) intent.getSerializableExtra("selected_item");

        String url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/todolist";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                String title = selectedItem.getTitle();
                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject test = response.getJSONObject(i);
                        String checkId = test.getString("theId");

                        if (title.equals(checkId)) {
                            removalId = test.getInt("id");
                            break;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "TOT HIER", Toast.LENGTH_LONG).show();
                    }
                }

                removalId = 1;

                RequestQueue deleteQueue = Volley.newRequestQueue(getApplicationContext());

                String deleteUrl = String.format("https://ide50-duncanvrosch.legacy.cs50.io:8080/todolist/%d", removalId);

                StringRequest dr = new StringRequest(Request.Method.DELETE, deleteUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                );
                deleteQueue.add(dr);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonArrayRequest);

        Intent intentt = new Intent(ToDoListDetailWGActivity.this, ToDoListWGActivity.class);
        startActivity(intentt);
    }
}