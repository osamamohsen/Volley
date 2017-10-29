package com.example.osama.volley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class JsonActivity extends AppCompatActivity {

    TextView txt_name,txt_email,txt_phone;
    Button btn_response_json,btn_json_next;

    String server_url = "http://192.168.1.106/api/user/first";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        txt_name = (TextView) findViewById(R.id.txt_person_name);
        txt_email = (TextView) findViewById(R.id.txt_person_email);
        txt_phone = (TextView) findViewById(R.id.txt_person_phone);
        btn_response_json = (Button) findViewById(R.id.btn_response_json);
        btn_json_next = (Button) findViewById(R.id.btn_json_next);

        btn_response_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //(String)null for -> response body
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            txt_name.setText(response.getString("name"));
                            txt_email.setText(response.getString("email"));
                            txt_phone.setText("01152517142");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(JsonActivity.this, "Error-...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });

                Mysingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }
        });
        btn_json_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ContactActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate
}
