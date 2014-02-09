package com.cmpe.datasharing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class ProcessDataActivity extends Activity{
	
	private ProgressDialog dialog ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.process_data);
		dialog = new ProgressDialog(ProcessDataActivity.this);
		dialog.setMessage("Processing Credit Card..");
		dialog.show();
		
	}

}
