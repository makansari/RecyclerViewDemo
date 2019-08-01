package com.ansari.recyclerviewdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movies_Data> myMovieList = new ArrayList<>();
    ProgressDialog progressDialog;
    Movies_Adapter myMovies_adapter;
    private static String url = "https://api.androidhive.info/contacts/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        getDataFromServer();

            //getMyData();

    }

    private void getDataFromServer() {

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("DATA DOWNLOADING");
        progressDialog.setMessage("Please wait !!!");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();
                Log.i("mytag",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray myContacts = jsonObject.getJSONArray("contacts");

                    for(int i =0; i<myContacts.length(); i++){

                        JSONObject data = myContacts.getJSONObject(i);
                              String id = data.getString("id");
                              String name = data.getString("name");
                              String email = data.getString("email");

                             Movies_Data myMovieData = new Movies_Data(name,email,id);
                             myMovieList.add(myMovieData);

                    }
                     myMovies_adapter = new Movies_Adapter(myMovieList);
                    recyclerView.setAdapter(myMovies_adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }

    private void getMyData() {

        Movies_Data data = new Movies_Data("TITLE 1","comedy movie","2001");
        myMovieList.add(data);
        Movies_Data data2 = new Movies_Data("TITLE 2","Action movie","2012");
        myMovieList.add(data2);
        Movies_Data data3 = new Movies_Data("TITLE 3","Drama movie","2011");
        myMovieList.add(data3);
        Movies_Data data4 = new Movies_Data("TITLE 4","horror movie","2000");
        myMovieList.add(data4);
        Movies_Data data5 = new Movies_Data("TITLE 5","comedy movie","2019");
        myMovieList.add(data5);

    }
}
