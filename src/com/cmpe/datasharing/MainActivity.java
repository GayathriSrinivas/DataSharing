package com.cmpe.datasharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button btn_process;
	private Button btn_save;
	private Button btn_report;
	private Button btn_close;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_process = (Button)findViewById(R.id.btn_process);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_report = (Button)findViewById(R.id.btn_report);
        btn_close = (Button)findViewById(R.id.btn_close);
        //Set OnClick Listeners for Button
        btn_process.setOnClickListener(this);
        btn_report.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_close.setOnClickListener(this);
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
			Intent processData = new Intent(getBaseContext(),ProcessDataActivity.class);
			startActivity(processData);
			break;
			
		case R.id.btn_save:
			
			break;
			
		case R.id.btn_report:
			
			break;
			
		case R.id.btn_close:
			finish();
			break;

		default:
			break;
		}
		
	}
    
}
