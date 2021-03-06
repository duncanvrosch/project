package com.example.duncan.worktodo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DonePost implements Response.Listener<String>, Response.ErrorListener{

    String title, name, description, priority, timestamp;
    Context context;
    Callback callback_activity;

    public class PostRequest extends StringRequest {

        public PostRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(method, url, listener, errorListener);
        }

        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            params.put("title", title);
            params.put("name", name);
            params.put("description", description);
            params.put("priority", priority);
            params.put("timestamp", timestamp);
            return params;
        }
    }

    public interface Callback {
        void gotpostDone(String highscores);
        void gotpostDoneError(String message);
    }

    // post new done-item
    public DonePost(Context context) {
        this.context = context;
    }

    public void doneLogger(Context aContext, String logger_title, String logger_name, String logger_description, String logger_priority, String logger_timestamp){
        this.context = aContext;
        title = logger_title;
        name = logger_name;
        description = logger_description;
        priority = logger_priority;
        timestamp = logger_timestamp;
        String json_url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/donelist";
        RequestQueue queue = Volley.newRequestQueue(context);

        PostRequest post = new PostRequest(Request.Method.POST, json_url,this,this);
        queue.add(post);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        callback_activity.gotpostDoneError(error.getMessage());
    }

    @Override
    public void onResponse(String response) {
        try{
            callback_activity.gotpostDone(response);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}

