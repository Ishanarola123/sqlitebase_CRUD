package com.example.employeedatbaseapp_40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity {
    Button add_emp;
    EditText empname,empsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        add_emp=findViewById(R.id.add_emp);
        empname=findViewById(R.id.empname);
        empsal=findViewById(R.id.empsal);

        EmployeeDBHelper  employeeDBHelper=new EmployeeDBHelper(this);

        add_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name;
                    int sal;
                    name=empname.getText().toString();
                    sal=Integer.parseInt(empsal.getText().toString());

                    long id=employeeDBHelper.insertEmployee(name,sal);
                    Toast.makeText(getApplicationContext(), "Your recored has beeen saved successfully with ID"+
                            id, Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}