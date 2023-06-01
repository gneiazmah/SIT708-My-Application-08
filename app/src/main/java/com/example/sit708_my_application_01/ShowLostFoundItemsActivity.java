package com.example.sit708_my_application_01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowLostFoundItemsActivity extends AppCompatActivity {

    ListView ListViewProducts;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lost_found_items);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();
        ListViewProducts=(ListView) findViewById(R.id.lst_L_Products);

        ArrayList<String> theList=new ArrayList<>();
        Cursor cursor = dbHelper.SearchAllProduct();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(), "Items could not found!", Toast.LENGTH_LONG).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                theList.add(cursor.getString(0));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                ListViewProducts.setAdapter(listAdapter);
            }
        }

        ListViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Integer productId = position;
                ArrayList<Items> itemList= dbHelper.SearchProduct(productId);
                if(itemList.size()!=0){
                    Intent intentViewList = new Intent(ShowLostFoundItemsActivity.this, RemoveItemActivity.class);
                    Items items= itemList.get(0);
                    intentViewList.putExtra("Name",items.getName());
                    intentViewList.putExtra("Datex", items.getDate());
                    intentViewList.putExtra("Locationx",items.getLocation());
                    startActivity(intentViewList);
                }


            }
        });

    }
}