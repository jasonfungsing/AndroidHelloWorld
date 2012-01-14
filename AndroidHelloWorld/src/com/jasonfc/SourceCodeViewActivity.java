package com.jasonfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SourceCodeViewActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sourcecodeview);

		Intent sender=getIntent();
		Bundle b = sender.getExtras();
		String page = b.getString("page");

		TextView vw1 = (TextView) findViewById(R.id.text_view_1);
		vw1.setText(page);
		
	}
}
