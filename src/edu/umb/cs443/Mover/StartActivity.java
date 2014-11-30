package edu.umb.cs443.Mover;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StartActivity extends FragmentActivity {

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		/* actionBar.hide(); */
		getActionBar().setDisplayShowTitleEnabled(false);
		actionBar.setIcon(android.R.color.transparent);
		setContentView(R.layout.activity_start);
		/*
		 * if (savedInstanceState == null) {
		 * getSupportFragmentManager().beginTransaction() .add(R.id.container,
		 * new StartFragment()) .commit(); }
		 */
		StartButtonsFragment mFragmentStart = new StartButtonsFragment();
		LogoFragment mFragmentLogo = new LogoFragment();

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();

		transaction.add(R.id.bottom_fragment, mFragmentStart);
		transaction.add(R.id.top_fragment, mFragmentLogo);
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
	    super.onPrepareOptionsMenu(menu);

	    MenuItem profile  = menu.findItem(R.id.edit_profile);
	    profile.setVisible(false);
	    
	    return true;
	}

/*	@Override
	public void onBackPressed() {
		if (getFragmentManager().getBackStackEntryCount() == 0) {
			super.onBackPressed();
		} else {
			getFragmentManager().popBackStack();
		}
	}*/
}
