package com.cmpe.datasharing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ReportDataActivity extends Activity implements OnClickListener{

	private SharedPreferences sharedPrefereces;
	private String fname;
	private String lname;
	private String address;
	private String details;
	private Cursor cursor;
	private ListView listview;
	private TextView textview;
	private Button button;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Holo);
		getActionBar().setTitle("Report Data");
		setContentView(R.layout.report_data);
		listview = (ListView)findViewById(R.id.lv_sqlite);
		textview = (TextView)findViewById(R.id.tv_pref);
		button = (Button)findViewById(R.id.btn_close1);
		button.setOnClickListener(this);
		
		sharedPrefereces = getSharedPreferences(SaveDataActivity.MyPREFERENCES,Context.MODE_PRIVATE);
		fname = sharedPrefereces.getString("fname", "FirstName");
		lname = sharedPrefereces.getString("lname", "LastName");
		address = sharedPrefereces.getString("address", "Address");
		details = sharedPrefereces.getString("details", "Details");

		textview.setText(fname + "\n" + lname + "\n" + address + "\n" + details);
		
		CustomerDB.init(this);
		cursor =CustomerDB.getCustomerNames();
		String fields[] = { "fname","lname","address","details" };
		int ids[] = { R.id.col1 , R.id.col2 , R.id.col3 , R.id.col4 };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.list_item,cursor,fields,ids );
		listview.setAdapter(adapter);
		CustomerDB.deactivate();
	}
		
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btn_close1)
			finish();
	}
}
