package com.cmpe.datasharing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ProcessDataActivity extends Activity implements OnClickListener{
	
	private ProgressDialog dialog ;
	private Button btn_complete;
	private RadioGroup rg_result;
	private RadioButton r_result;
	private Intent returnIntent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Holo);
		setContentView(R.layout.process_data);
		dialog = new ProgressDialog(ProcessDataActivity.this);
		new ShowProgressBar(dialog).execute(); 
		
		btn_complete = (Button)findViewById(R.id.btn_complete);
		rg_result = (RadioGroup)findViewById(R.id.rg_result);
		
		//Setting OnClick Listeners
		btn_complete.setOnClickListener(this);
		getActionBar().setTitle("Process Data");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_complete:
			returnIntent  = new Intent();
			r_result = (RadioButton)findViewById(rg_result.getCheckedRadioButtonId());
			returnIntent.putExtra("result", r_result.getText());
			setResult(RESULT_OK,returnIntent);
			finish();
			break;
	
		default:
			break;
		}	
	}
}

class ShowProgressBar extends AsyncTask<Void,Void,Void>{

	private ProgressDialog dialog ;
	
	public ShowProgressBar(ProgressDialog dialog){
		this.dialog = dialog;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dialog.setMessage("Processing Credit Card..Plz Wait");
		dialog.show();
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		if(dialog.isShowing()){
			dialog.dismiss();
		}	
	}
}
