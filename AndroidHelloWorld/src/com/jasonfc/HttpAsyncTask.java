package com.jasonfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Intent;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class HttpAsyncTask extends AsyncTask<String, Integer, String> {

	private String url;
	private String result;

	public HttpAsyncTask(String url, String result) {
		this.url = url;
		this.result = result;
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

	}

	@Override
	protected void onPostExecute(String result) {


	}

}
