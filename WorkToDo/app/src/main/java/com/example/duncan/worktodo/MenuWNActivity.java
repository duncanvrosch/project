package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MenuWNActivity extends AppCompatActivity {

    TextView t1_temp, t2_city, t3_description, t4_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_wn);

        t1_temp = (TextView) findViewById(R.id.textViewTemp);
        t2_city = (TextView) findViewById(R.id.textViewCity);
        t3_description = (TextView) findViewById(R.id.textViewDescription);
        t4_date = (TextView) findViewById(R.id.textViewDate);

        find__weather();
    }

    // get weather from API for Amsterdam
    public void find__weather() {

        // url data of API
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Amsterdam,NL&appid=f93b3bd64addf0f3c6d0e2338f153114&units=metric";

        // get required info
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(Math.round(main_object.getDouble("temp")));
                    String description = object.getString("description");
                    String city = response.getString("name");

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd - MM -" + " 2019");
                    String formatted_date = sdf.format(calendar.getTime());

                    // set info
                    t1_temp.setText(temp + "°C");
                    t2_city.setText(city);
                    t3_description.setText(description);
                    t4_date.setText(formatted_date);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }

    public void onClickLog(View v) {

        Intent intent = new Intent(MenuWNActivity.this, LogWNActivity.class);
        startActivity(intent);
    }

    public void onClickToDoList(View v) {

        Intent intent = new Intent(MenuWNActivity.this, ToDoListWNActivity.class);
        startActivity(intent);
    }

    public void onClickLogOut(View v) {

        Intent intent = new Intent(MenuWNActivity.this, LogInActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}
