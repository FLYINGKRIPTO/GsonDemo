package com.sriyanksiddhartha.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Author : Sriyank Siddhartha
 * Module 3 : Using GSON to Save and Retrieve Non-primitive Data Type
 *
 * 		"BEFORE" Demo Project
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private TextView txvDisplay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txvDisplay = (TextView) findViewById(R.id.txvDisplay);
	}

	public void saveObjectType(View view) {

	    Employee employee = getEmployeeObject();

	}

	public void loadObjectType(View view) {
	    SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
	    String jsonString = sharedPreferences.getString("employee_key","N/A");
        Log.i(TAG,jsonString);

        //Deserialization
        Gson gson = new Gson();
        Employee employee = gson.fromJson(jsonString,Employee.class);
        displayText(employee);



	}

    private void displayText(Employee employee) {
	    if(employee==null)
        {
            return;
        }
	    String displayText = employee.getName()+
                "\n" + employee.getProfession()
	           +"\n"+employee.getProfId()
                +"\n"+employee.getRoles();
	    txvDisplay.setText(displayText);
    }

    public void saveGenericType(View view) {
         Employee employee = getEmployeeObject();
         Foo<Employee> foo = new Foo<>();
         foo.setObject(employee);
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Serialization by GSON Library
        Gson gson = new Gson();
        Type type = new TypeToken<Foo<Employee>>(){}.getType();
        String jsonString = gson.toJson(foo,type);
        Log.i(TAG, jsonString);

        editor.putString("foo_key",jsonString);
        editor.apply();

    }

	public void loadGenericType(View view) {

	}
	private Employee getEmployeeObject(){
        Employee employee = new Employee();
        employee.setName("Shivanshu Srivastava");
        employee.setProfession("Android Developer");
        employee.setProfId(287);
        employee.setRoles(Arrays.asList("Developer","Admin"));
        return employee;
    }
}
