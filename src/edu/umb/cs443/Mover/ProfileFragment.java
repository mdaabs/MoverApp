package edu.umb.cs443.Mover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
	
	TextView name, zip, vehicle;
	MoverDBAdapter adapter;
	String user, first, last, sZip, sVehicle;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container, false);

		name = (TextView) view.findViewById(R.id.profile_name);
		zip = (TextView) view.findViewById(R.id.profile_area);
		vehicle = (TextView) view.findViewById(R.id.profile_vehicle);
		adapter = new MoverDBAdapter(getActivity());
		
		adapter.open();
		
		user = LoginFragment.u;
		
		first = adapter.getFirstName(user);
		last = adapter.getLastName(user);
		sZip = adapter.getZip(user);
		sVehicle = adapter.getVehicle(user);
		
		name.setText(first + " " + last);
		zip.setText(sZip);
		vehicle.setText(sVehicle);
		
		return view;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
	    super.onCreate(savedInstanceState);

	    setHasOptionsMenu(true);
	    setRetainInstance(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {	
		final Fragment home = new HomeFragment();
		
		final FragmentManager fm = getActivity().getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		
		int id = item.getItemId();
		if (id == R.id.back) {
			getActivity().onBackPressed();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    super.onPrepareOptionsMenu(menu);

	    MenuItem profile  = menu.findItem(R.id.back);
	    profile.setVisible(true);

	}
}
