package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ToDoListDetailWNActivity extends AppCompatActivity {

    Helper selectedItem;
    int removalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_detail_wn);

        // grab item
        Intent intent = getIntent();
        selectedItem = (Helper) intent.getSerializableExtra("selected_item");

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

    public void onClickBackToToDoList(View v) {

        Intent intent = new Intent(ToDoListDetailWNActivity.this, ToDoListWNActivity.class);
        startActivity(intent);
    }

    public void onClickDoneToDoItem(View v) {

        // grab name
        EditText nameEdit = findViewById(R.id.Name);
        String name = nameEdit.getText().toString();

        // line cannot be empty
        if(name.equals("")){
            Toast.makeText(getApplicationContext(), "Fill in a name please.", Toast.LENGTH_LONG).show();
        }

        else {

            // get info
            TextView titleEdit = findViewById(R.id.entryTitle);
            String title = titleEdit.getText().toString();
            TextView descriptionEdit = findViewById(R.id.entryDescription);
            String description = descriptionEdit.getText().toString();
            TextView priorityEdit = findViewById(R.id.entryPriority);
            String priority = priorityEdit.getText().toString();

            // make timestamp
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm").format(Calendar.getInstance().getTime());

            // post done item
            DonePost post = new DonePost(ToDoListDetailWNActivity.this);
            post.doneLogger(ToDoListDetailWNActivity.this, title, name, description, priority, timestamp);

            String url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/todolist";
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {

                    String title = selectedItem.getTitle();

                    // search for to-do item with title
                    for (int i = 0; i < response.length(); i++) {

                        try {
                            JSONObject item = response.getJSONObject(i);
                            String checkTitle = item.getString("title");

                            // grab id of item when found
                            if (title.equals(checkTitle)) {
                                removalId = item.getInt("id");
                                break;
                            }

                        // item not found
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Doesn't work!", Toast.LENGTH_LONG).show();
                        }
                    }

                    // delete account
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

            // shown when successfully deleted item
            Toast.makeText(getApplicationContext(), "Marked selected to-do item as done!", Toast.LENGTH_LONG).show();

            // delay of 1 second
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(ToDoListDetailWNActivity.this, ToDoListWNActivity.class);
            startActivity(intent);
        }
    }
}
