package com.example.employeedatbaseapp_40;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GetAllEmployee extends AppCompatActivity {
    Button findalldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_employee);

        findalldata=findViewById(R.id.findalldata);

        EmployeeDBHelper employeeDBHelper=new EmployeeDBHelper(this);

        findalldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c= employeeDBHelper.retriveAllEmployee();
                if (c.moveToFirst()){
                    do {
                        Toast.makeText(getApplicationContext(), "Employee id" + c.getString(0)
                                +" Employee name is:"      + c.getString(1)+  "Employee salary"
                                +c.getString(2), Toast.LENGTH_SHORT).show();
                    }
                    while (c.moveToNext());
                }
                else{
                    Toast.makeText(getApplicationContext(), "no record in the databse",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}