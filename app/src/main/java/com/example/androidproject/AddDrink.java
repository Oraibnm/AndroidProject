package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddDrink extends AppCompatActivity {
    private EditText edtName, edtPrice, edtSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_drinks);
        edtName= findViewById(R.id.edtName);
        edtPrice=findViewById(R.id.edtPrice);
        edtSize= findViewById(R.id.edtSize);

    }

    //event handler
    public void btnAddDrink_Click(View view) {
        String dishName= edtName.getText().toString();
        String dishPrice= edtPrice.getText().toString();
        int finalValue=Integer.parseInt(dishPrice );
        String dishSize= edtSize.getText().toString();

        //addDish();

    }

}