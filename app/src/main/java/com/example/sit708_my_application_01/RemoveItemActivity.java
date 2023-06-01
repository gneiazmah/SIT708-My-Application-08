package com.example.sit708_my_application_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveItemActivity extends AppCompatActivity {

    TextView Name, Date , Location;
    Button Remove;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);

        Name = findViewById(R.id.tvName);
        Date = findViewById(R.id.tvDate);
        Location = findViewById(R.id.tvLocation);

        Remove = findViewById(R.id.btnRemove);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();


        Intent intent= this.getIntent();

        Name.setText("Found the " +intent.getStringExtra("Name"));
        Date.setText("On  " + intent.getStringExtra("Datex"));
        Location.setText("At  " + intent.getStringExtra("Locationx"));


        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbHelper.removeItemData(intent.getStringExtra("ID"));

                Toast.makeText(getApplicationContext(),"Removed the Item From the List", Toast.LENGTH_LONG).show();
            }
        });

    }
}