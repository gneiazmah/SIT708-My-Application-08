package com.example.sit708_my_application_01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewAdvertActivity extends AppCompatActivity {

    RadioButton lost, found;
    EditText name,phone,description,date, location;
    Button save;

    private Integer postType = 0;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);

        lost = findViewById(R.id.radiolost);
        found = findViewById(R.id.radioFound);
        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
        description = findViewById(R.id.etDescription);
        date = findViewById(R.id.etDate);
        location = findViewById(R.id.etLocation);
        save = findViewById(R.id.btnSaveAdvert);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        int savedAttempts = sharedPreferences.getInt("attempts", 0);


        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.getText().toString().isEmpty()||
                        phone.getText().toString().isEmpty()||
                        description.getText().toString().isEmpty() || date.getText().toString().isEmpty() ||
                location.getText().toString().isEmpty())

                {
                    Toast.makeText(getApplicationContext(),
                            "Fields can't be blank",Toast.LENGTH_LONG).show();
                }
                else{

                    if (found.isChecked()){
                        postType = 1;
                    }else {
                        postType = 0;
                    }

                    Items itemClass = new Items(savedAttempts, name.getText().toString(),
                            phone.getText().toString(),description.getText().toString(),
                            date.getText().toString(), location.getText().toString(), postType);

                    if (dbHelper.CreateNewItem((itemClass))) {

                        Toast.makeText(getApplicationContext(), "Advert Saved Successfully", Toast.LENGTH_LONG).show();

                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

                        int currentAttempts = savedAttempts + 1;

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("attempts", currentAttempts);
                        editor.apply();

                    }else
                    {
                        Toast.makeText(getApplicationContext(),
                                "Advert Creation Failed",Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


    }
}