package com.example.osama.volley;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.osama.volley.Adapter.ContactAdapter;
import com.example.osama.volley.Helper.BackgroundTask;
import com.example.osama.volley.Models.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button btn_contact,btn_contact_next;
    RecyclerView.Adapter adapter;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        btn_contact = (Button)findViewById(R.id.btn_contact);
        recyclerView = (RecyclerView)findViewById(R.id.rv_contact);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        BackgroundTask backgroundTask = new BackgroundTask(this);
//        arrayList = backgroundTask.getList();
        backgroundTask.getList(new BackgroundTask.arrayCallBack() {
            @Override public void onSuccess(ArrayList<Contact> contacts) {
                Log.d("Contacts",""+contacts.size());
                adapter = new ContactAdapter(ContactActivity.this, contacts);
                recyclerView.setAdapter(adapter);
            }
            @Override public void onFail(String msg) {
                // Do Stuff
             }
        });

    }
}
