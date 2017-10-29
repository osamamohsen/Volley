package com.example.osama.volley;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class ImageActivity extends AppCompatActivity {

    ImageView img_response;
    Button btn_img_reponse,btn_next;
    String server_image = "http://192.168.1.106/images/rabbit.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        img_response = (ImageView) findViewById(R.id.img_response);
        btn_img_reponse = (Button) findViewById(R.id.btn_img_response);
        btn_next = (Button) findViewById(R.id.btn_img_next);

        btn_img_reponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageRequest imageRequest = new ImageRequest(server_image, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        img_response.setImageBitmap(response);
                    }//min_width,min_height,null:encode
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ImageActivity.this, "Some thing wennt wrong", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                Mysingleton.getInstance(getApplicationContext()).addToRequestQueue(imageRequest);
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),JsonActivity.class);
                startActivity(intent);
            }
        });
    }
}
