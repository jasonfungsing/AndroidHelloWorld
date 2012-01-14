package com.jasonfc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AndroidHelloWorldActivity extends Activity {

	private EditText text;
	private Uri url;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.editText1);
	}

	public void onClickShowWebView(View view) {
		if (isInputValid()) {
			Intent i = new Intent(Intent.ACTION_VIEW, url);
			startActivity(i);
		}
	}

	public void onClickShowSourceWeb(View view) {
		isInputValid();

	}

	private boolean isInputValid() {
		boolean isInputValid = false;
		String uri = text.getText().toString();
		if (uri.length() == 0) {
			Toast.makeText(this, "God, at least enter something", Toast.LENGTH_SHORT).show();
		} else if (uri.startsWith("http://") || uri.startsWith("https://")) {
			url = Uri.parse(uri);
			isInputValid = true;
		} else {
			uri = "http://" + uri;
			url = Uri.parse(uri);
			isInputValid = true;
		}

		return isInputValid;
	}
	
	
	
}