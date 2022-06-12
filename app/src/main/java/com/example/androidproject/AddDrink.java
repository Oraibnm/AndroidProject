package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddDrink extends AppCompatActivity {
    private EditText edtName, edtPrice, edtSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
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
    private void addDish(){
        String url = "http://10.0.2.2:84/rest/addbook_json.php";

    }
}