package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLOGIN(View v) {

        EditText name = findViewById(R.id.etName);
        EditText insertedpassword = findViewById(R.id.etPassword);

        final String username = name.getText().toString();
        final String password = insertedpassword.getText().toString();

        if ((username.equals("werkgever")) && (password.equals("werkgever"))) {
            Intent intent = new Intent(LogInActivity.this, MenuWGActivity.class);
            startActivity(intent);
            return;

        } else {

            RequestQueue queue = Volley.newRequestQueue(this);

            String url = String.format("https://ide50-duncanvrosch.legacy.cs50.io:8080/accountlist?username=%s", username);

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {

                    if (response.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Wrong username!", Toast.LENGTH_SHORT).show();

                    } else {
                        try {

                            JSONObject account = response.getJSONObject(0);
                            String accountPassword = account.getString("password");

                            if (accountPassword.equals(password)) {

                                Intent intent = new Intent(LogInActivity.this, MenuWNActivity.class);
                                intent.putExtra("username", username);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong password, try again", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            queue.add(jsonArrayRequest);
        }

    }

    @Override
    public void onBackPressed() {
    }
}
