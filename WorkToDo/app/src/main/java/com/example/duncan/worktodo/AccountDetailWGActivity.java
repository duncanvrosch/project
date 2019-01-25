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

import java.util.concurrent.TimeUnit;

public class AccountDetailWGActivity extends AppCompatActivity {

    Account selectedItem;
    int removalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail_wg);

        Intent intent = getIntent();
        selectedItem = (Account) intent.getSerializableExtra("selected_item");

        String username = selectedItem.getUsername();
        String password = selectedItem.getPassword();

        // place info
        TextView itemUsername = findViewById(R.id.username);
        TextView itemPassword = findViewById(R.id.password);

        itemUsername.setText(username);
        itemPassword.setText(password);
    }

    public void onClickDELETEACCOUNT(View v) {

        String url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/accountlist";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                String username = selectedItem.getUsername();

                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject item = response.getJSONObject(i);
                        String checkId = item.getString("username");

                        if (username.equals(checkId)) {
                            removalId = item.getInt("id");
                            break;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Doesn't work!", Toast.LENGTH_LONG).show();
                    }
                }

                RequestQueue deleteQueue = Volley.newRequestQueue(getApplicationContext());

                String deleteUrl = String.format("https://ide50-duncanvrosch.legacy.cs50.io:8080/accountlist/%d", removalId);

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

        Toast.makeText(getApplicationContext(), "Deleted selected account successfully!", Toast.LENGTH_LONG).show();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(AccountDetailWGActivity.this, AccountListWGActivity.class);
        startActivity(intent);
    }

    public void onClickBACKTOACCOUNTLIST(View v) {

        Intent intent = new Intent(AccountDetailWGActivity.this, AccountListWGActivity.class);
        startActivity(intent);
    }
}