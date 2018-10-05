package com.sriyanksiddhartha.sharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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

	}

	public void loadObjectType(View view) {

	}

	public void saveGenericType(View view) {

	}

	public void loadGenericType(View view) {

	}
}