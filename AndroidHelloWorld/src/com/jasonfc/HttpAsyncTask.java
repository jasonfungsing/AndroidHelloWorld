package com.jasonfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class HttpAsyncTask extends AsyncTask<String, Integer, String> {

	private String url;
	private String result;
	private AndroidHelloWorldActivity ahw;
	private ProgressDialog dialog;

	public HttpAsyncTask(String url, String result, AndroidHelloWorldActivity ahw) {
		this.url = url;
		this.result = result;
		this.ahw=ahw;
	}

	@Override
	protected String doInBackground(String... params) {
		BufferedReader in = null;
		String page = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			page = sb.toString();
			Log.i("info", page.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return page;
	}

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(ahw, ProgressDialog.STYLE_SPINNER); 
        dialog.setMessage("Please, wait...");
        dialog.show();
	}

	@Override
	protected void onPostExecute(String result) {
		dialog.dismiss();
		ahw.showSourceCodeView(result);

	}

}
