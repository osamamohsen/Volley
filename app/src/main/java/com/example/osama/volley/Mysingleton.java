package com.example.osama.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by osama on 10/28/2017.
 */

public class Mysingleton {
    public static Mysingleton mySingletonInstance;
    public static Context mCtx;
    public RequestQueue requestQueue;

    private Mysingleton(Context context) {
        mCtx = context;
        this.requestQueue = getRequestQu();
    }

    public RequestQueue getRequestQu(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        return  requestQueue;
    }

    public static synchronized Mysingleton getInstance(Context context){
        if(mySingletonInstance == null){
            mySingletonInstance = new Mysingleton(context);
        }
        return  mySingletonInstance;
    }

    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
