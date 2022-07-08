package com.example.employeedatbaseapp_40;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add_emp,get_all_emp,get_emp,update_emp,delete_emp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_emp=findViewById(R.id.addemp);
        get_all_emp=findViewById(R.id.selectallemp);
        get_emp=findViewById(R.id.selectemp);
        update_emp=findViewById(R.id.updateemp);
        delete_emp=findViewById(R.id.deleteemp);

        add_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AddEmployee.class);
                startActivity(i);

            }
        });

        get_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,GetEmployee.class);
                startActivity(i);
            }
        });
        get_all_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,GetAllEmployee.class);
                startActivity(i);
            }
        });
        update_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UpdateEmployee.class);
                startActivity(i);
            }
        });
        delete_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DeleteEmployee.class);
                startActivity(i);
            }
        });
    }
}