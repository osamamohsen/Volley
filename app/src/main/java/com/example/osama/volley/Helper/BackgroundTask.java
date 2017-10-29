package com.example.osama.volley.Helper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.osama.volley.Models.Contact;
import com.example.osama.volley.Mysingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by osama on 10/28/2017.
 */

public class BackgroundTask {
    Context context;
    ArrayList<Contact> arrayList = new ArrayList<>();
    String server_url = "http://192.168.1.106/api/contact/index";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public void getList(final arrayCallBack onCallBack){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                Log.d("Array Length",""+response.length());
                while (count < response.length()){
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Contact contact = new Contact(jsonObject.getString("name"),jsonObject.getString("email"),jsonObject.getString("id"));
                        arrayList.add(contact);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }//end while
                onCallBack.onSuccess(arrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        Log.d("my Array final",""+arrayList.size());

        Mysingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);

//        return  arrayList;
    }

    public interface arrayCallBack { void onSuccess(ArrayList<Contact> contacts); void onFail(String msg); }
}
