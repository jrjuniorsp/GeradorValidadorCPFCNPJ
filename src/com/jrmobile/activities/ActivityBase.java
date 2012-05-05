package com.jrmobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Activity Base. Todas as activities devem fazer um extends da base
 * 
 * @author jairrillo
 *
 */
public abstract class ActivityBase extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
	    	Intent intent = new Intent(this, SobreActivity.class);
	    	startActivity(intent);
			break;
		}
		return true;
	}

}
