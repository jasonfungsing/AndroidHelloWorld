package com.jasonfc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SourceCodeViewActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle b = getIntent().getExtras();
		String page = b.getString("page");

		TextView vw1 = (TextView) findViewById(R.id.text_view_1);
		vw1.setText(page);
		setContentView(R.layout.sourcecodeview);
	}
}
