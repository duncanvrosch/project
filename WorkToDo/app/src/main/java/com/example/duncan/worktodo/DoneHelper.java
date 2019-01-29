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

public class DoneHelper implements Response.Listener<JSONArray>, Response.ErrorListener{

    private Context context;
    private ArrayList<Helper> itemList;
    private DoneHelper.Callback activity;

    public interface Callback {
        void gotDone(ArrayList<Helper> itemList);
        void gotDoneError(String message);
    }

    public DoneHelper(Context aContext) {
        this.context = aContext;
    }

    @Override
    public void onResponse(JSONArray response) {
        itemList = new ArrayList<>();

        // search all items
        try {
            for (int i =  0; i < response.length(); i++) {
                JSONObject object = response.getJSONObject(i);
                String title = object.getString("title");
                String description = object.getString("description");
                String priority = object.getString("priority");
                String timestamp = object.getString("timestamp");
                String name = object.getString("name");
                Helper helper = new Helper(title, name, description, priority, timestamp);
                itemList.add(helper);
            }
            activity.gotDone(itemList);
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotDoneError(error.getMessage());
    }


    public void getDone(DoneHelper.Callback activity) {
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://ide50-duncanvrosch.legacy.cs50.io:8080/donelist";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(jsonArrayRequest);
    }

}
