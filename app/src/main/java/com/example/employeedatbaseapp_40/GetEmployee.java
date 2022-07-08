package com.example.employeedatbaseapp_40;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetEmployee extends AppCompatActivity {

    Button findemp;
    EditText empid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_employee2);

        findemp=findViewById(R.id.btnfind);
        empid=findViewById(R.id.empid);

        EmployeeDBHelper employeeDBHelper=new EmployeeDBHelper(this);

        findemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int emp_id=Integer.parseInt(empid.getText().toString());
                //FOR READ DATA USE COURSER
                Cursor c= employeeDBHelper.retriveEmployee(emp_id);
                if(c.moveToFirst()){
                    Toast.makeText(getApplicationContext(), "Employee id" + c.getString(0)
                      +" Employee name is:"      + c.getString(1)+  "Employee salary"  +c.getString(2), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "NO employee record found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}