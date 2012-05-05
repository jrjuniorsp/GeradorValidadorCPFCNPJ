package com.jrmobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity implements Runnable {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		Handler handler = new Handler();
		handler.postDelayed(this, 3000);
	}

	@Override
	public void run() {
		Intent intent = new Intent(this, GeradorValidadorCPFCNPJActivity.class);
		startActivity(intent);
		finish();
	}

}
