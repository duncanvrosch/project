package com.example.duncan.worktodo;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class AccountListHelper implements Response.Listener<JSONArray>, Response.ErrorListener{

    private Context context;
    private ArrayList<Account> accountList;
    private AccountListHelper.Callback activity;

    public interface Callback {
        void gotAccount(ArrayList<Account> accountList);
        void gotAccountError(String message);
    }

    public AccountListHelper(Context aContext) {
        this.context = aContext;
    }

    @Override
    public void onResponse(JSONArray response) {
        accountList = new ArrayList<>();

        try {
            for (int i =  0; i < response.length(); i++) {
                JSONObject object = response.getJSONObject(i);
                String username = object.getString("username");
                String password = object.getString("password");
                Account account = new Account(username, password);
                accountList.add(account);
            }
            activity.gotAccount(accountList);
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "errorwithJSON", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotAccountError(error.getMessage());
    }

    public void getAccount(AccountListHelper.Callback activity) {
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/accountlist";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(jsonArrayRequest);
    }

}
