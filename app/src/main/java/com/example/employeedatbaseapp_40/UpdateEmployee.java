package com.example.employeedatbaseapp_40;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEmployee extends AppCompatActivity {
    Button btnupdate;
    EditText employeeid,employeename,employeesalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        btnupdate=findViewById(R.id.btnupdate);
        employeeid=findViewById(R.id.employeeid);
        employeename=findViewById(R.id.employeename);
        employeesalary=findViewById(R.id.employeesalary);

        EmployeeDBHelper employeeDBHelper=new EmployeeDBHelper(this);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int emp_id=Integer.parseInt(employeeid.getText().toString());
                String empstr=employeename.getText().toString();
               int  empsalary=Integer.parseInt(employeesalary.getText().toString());

               if (employeeDBHelper.updateEmployee(emp_id,empstr,empsalary))
               {
                   Toast.makeText(getApplicationContext(), "Record has been updated",
                           Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(), "Record has been not updated",
                           Toast.LENGTH_SHORT).show();
               }

            }
        });

        employeeid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                employeeid.setEnabled(false);
                int emp_id=Integer.parseInt(employeeid.getText().toString());
                Cursor c=employeeDBHelper.retriveEmployee(emp_id);

                if (c.moveToFirst()){
                    employeename.setText(c.getString(1));
                    employeesalary.setText(c.getString(2));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "NO EMPLOYEE RECORD FOUND",
                            Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}