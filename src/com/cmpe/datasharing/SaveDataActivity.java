package com.cmpe.datasharing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SaveDataActivity extends Activity implements OnClickListener{

	public static final String MyPREFERENCES = "MyPrefs" ;
	private Button btn_preferences;
	private Button btn_sqlite;
	private SharedPreferences sharedPreferences;
	private Editor editor;
	private Customer customer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTheme(android.R.style.Theme_Holo);
		getActionBar().setTitle("Save Data");
		setContentView(R.layout.save_data);
		customer = (Customer)getIntent().getSerializableExtra("customer");
		//Set OnClick Listener
		btn_preferences = (Button)findViewById(R.id.btn_preferences);
		btn_sqlite = (Button)findViewById(R.id.btn_sqlite);
		btn_preferences.setOnClickListener(this);
		btn_sqlite.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_preferences:
			/* Data Storage in Shared Preferences */
			sharedPreferences = getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
			editor = sharedPreferences.edit();
			editor.putString("fname",customer.getFname());
			editor.putString("lname",customer.getLname());
			editor.putString("address",customer.getAddress());
			editor.putString("details", customer.getDetails());
			editor.commit();
			finish();
			break;
		case R.id.btn_sqlite:
			CustomerDB.init(this);
			CustomerDB.addCustomer(customer);
			CustomerDB.deactivate();
			finish();
			break;

		default:
			break;
		}
	}
}
