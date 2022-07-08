package com.example.employeedatbaseapp_40;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDBHelper {
    public static final String Empid = "Empid";
    public static final String EmpName = "EmpName";
    public static final String EmpSal = "EmpSal";
    public static final String databasename = "EmployeeDB";
    public static final String tablename = "Employee";
    public static final int databaseversion = 1;

    //run query for create table
//    CREATE TABLE Persons (
//            PersonID int,
//            LastName varchar(255),
//    FirstName varchar(255),
//    Address varchar(255),
//    City varchar(255)
//);
    public static final String create_table = "create table employee(Empid integer primary key autoincrement , " +
            "EmpName text not null, Empsal integer not null)";
    private Context ct;//for insert
    private DatabaseHelper dbHelper;//for doing all operation to related query
    private static SQLiteDatabase database; //add data

    //create constructor and pass data context
    public EmployeeDBHelper(Context context) {
//        this.ct = context;
//        dbHelper = new DatabaseHelper(ct);
        this.ct=context;
        dbHelper=new DatabaseHelper(ct);
    }


    //database helper class extends with sqliteopenhelper class

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context c) {
            super(c, databasename, null, databaseversion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            {
                try {
                    sqLiteDatabase.execSQL(create_table);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Employee");
        }
    }

    public EmployeeDBHelper connect() throws SQLException {
        database = dbHelper.getWritableDatabase(); //to open databse for read and write
        return this;
    }

    public void disconnect() {
        dbHelper.close();
    }

    //inset records
    public long insertEmployee(String empname, int empsal) {
        //need to content
        //use contentvalues class for insert data
        ContentValues cv = new ContentValues();
        cv.put(EmpName, empname);
        cv.put(EmpSal, empsal);
        this.connect();
        return database.insert(tablename, null, cv);
    }


    public Cursor retriveAllEmployee(){
        this.connect();
        return database.query(tablename,new String[]{Empid,EmpSal,EmpName},
                null,null,null,null,null);

    }

    public Cursor retriveEmployee(long id) throws  SQLException {
        this.connect();
        //here use cursor class for retrive data
        Cursor c=database.query(true, tablename,new String[]{Empid,EmpName,EmpSal},Empid + "="+
                id,null,null,null,null,null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }


    public boolean deleteEmployee(long id){
        this.connect();
        return  database.delete(tablename, Empid + "=" + id,null)>0;

    }

    public boolean updateEmployee(long id, String empname,int empsal){
        this.connect();
        ContentValues cvalues=new ContentValues();
        cvalues.put(EmpName,empname);
        cvalues.put(EmpSal,empsal);
        return  database.update(tablename ,cvalues,Empid + "=" + id,null)>0;
    }


}




