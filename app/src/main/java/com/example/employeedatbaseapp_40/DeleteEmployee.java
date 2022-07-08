package com.example.employeedatbaseapp_40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteEmployee extends AppCompatActivity {
    EditText empid;
    Button btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);

        empid=findViewById(R.id.deleteid);
        btndelete=findViewById(R.id.btndelete);

        EmployeeDBHelper employeeDBHelper=new EmployeeDBHelper(this);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int emp_id=Integer.parseInt(empid.getText().toString());

                if (employeeDBHelper.deleteEmployee(emp_id)){
                    Toast.makeText(getApplicationContext(), "delete successfully!", Toast.LENGTH_SHORT)
                            .show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "No record found so that's why can not delete"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}