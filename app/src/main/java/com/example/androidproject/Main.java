package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private RequestQueue queue;
    Button login , reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        queue = Volley.newRequestQueue(this);
        login = findViewById(R.id.BtLogin);
        reg=findViewById(R.id.BtRegister);



    }


    public void btnOpen_Click(View view) {
        Intent intent  = new Intent(this, AddDish.class);

        startActivity(intent);
    }

    public void btnSearch_Click(View view) {
        EditText edtCat = findViewById(R.id.edt);
        final ListView lst = findViewById(R.id.lstDishes);
        String cat = edtCat.getText().toString();
        //GET METHOD
        String url ="https://192.168.1.157:8080/restaurant/infoDish.php?cat=" + cat;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<String> dishes = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        dishes.add( obj.getString("name"));
                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }
                String[] arr = new String[dishes.size()];
                arr = dishes.toArray(arr);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        Main.this, android.R.layout.simple_list_item_1,
                        arr);
                lst.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Main.this, error.toString(),
                        Toast.LENGTH_SHORT).show();
                Log.d("Error_json", error.toString());
            }
        });

        queue.add(request);
    }
//
//    public void reg(View view) {
//        Intent intent = new Intent(this,register.class);
//        startActivity(intent);
//    }
}