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

public class AccountPost implements Response.Listener<String>, Response.ErrorListener{

    String username, password;
    Context context;
    Callback callback_activity;

    public class PostRequest extends StringRequest {

        public PostRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(method, url, listener, errorListener);
        }

        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            return params;
        }
    }

    public interface Callback {
        void gotpostAccount(String account);
        void gotpostAccountError(String message);
    }

    public AccountPost(Context context) {
        this.context = context;
    }

    // post new username and password in database
    public void postLogger(Context aContext, String logger_username, String logger_password){
        this.context = aContext;
        username = logger_username;
        password = logger_password;
        String json_url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/accountlist";
        RequestQueue queue = Volley.newRequestQueue(context);

        PostRequest post = new PostRequest(Request.Method.POST, json_url,this,this);
        queue.add(post);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        callback_activity.gotpostAccountError(error.getMessage());
    }

    @Override
    public void onResponse(String response) {
        try{
            callback_activity.gotpostAccount(response);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}

