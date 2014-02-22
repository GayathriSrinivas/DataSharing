package com.cmpe.datasharing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity implements OnClickListener{

	private Button btn_process;
	private Button btn_save;
	private Button btn_report;
	private Button btn_close;
	private Intent processDataIntent;
	private Intent saveDataIntent;
	private Intent reportDataIntent;
	static final int PROCESS_DATA_REQUEST = 0;
	String fname;
	String lname;
	String address;
	String details;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Holo);
        setContentView(R.layout.activity_main);
        
        btn_process = (Button)findViewById(R.id.btn_process);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_report = (Button)findViewById(R.id.btn_report);
        btn_close = (Button)findViewById(R.id.btn_close1);

        //Set OnClick Listeners for Button
        btn_process.setOnClickListener(this);
        btn_report.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        getActionBar().setTitle("Android Activity & Data Storage Sample");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btn_process:
	        processDataIntent = new Intent(this,ProcessDataActivity.class);
			startActivityForResult(processDataIntent,PROCESS_DATA_REQUEST);
			break;
			
		case R.id.btn_save:
			saveDataIntent = new Intent(this,SaveDataActivity.class);
			fname = "FirstName : " +((EditText)findViewById(R.id.et_fname)).getText().toString();
			lname = "LastName : "+((EditText)findViewById(R.id.et_lname)).getText().toString();
			address ="Address : " +((EditText)findViewById(R.id.et_address)).getText().toString();
			details = "Card Deatils : " +((EditText)findViewById(R.id.et_details)).getText().toString();
			Customer customer = new Customer(fname,lname,address,details);
			saveDataIntent.putExtra("customer",customer);
			startActivity(saveDataIntent);
			break;
			
		case R.id.btn_report:
			reportDataIntent = new Intent(this,ReportDataActivity.class);
			startActivity(reportDataIntent);
			break;
			
		case R.id.btn_close1:
			finish();
			break;

		default:
			break;
		}
		
	}
	
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	if (requestCode == PROCESS_DATA_REQUEST) {

            if (resultCode == RESULT_OK) {
    		String result = data.getStringExtra("result");
            	Toast.makeText(this, "Process Data : " + result	, Toast.LENGTH_SHORT).show();
            }
        }    	
    }
}