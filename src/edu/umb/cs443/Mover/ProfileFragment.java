package edu.umb.cs443.Mover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
	
	TextView name, zip, vehicle;
	EditText bio;
	Button done;
	MoverDBAdapter adapter;
	String user, first, username, sZip, sVehicle, sBio;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container, false);

		name = (TextView) view.findViewById(R.id.profile_name);
		zip = (TextView) view.findViewById(R.id.profile_area);
		vehicle = (TextView) view.findViewById(R.id.profile_vehicle);
		bio = (EditText) view.findViewById(R.id.information);
		done = (Button) view.findViewById(R.id.profile_submit);
		adapter = new MoverDBAdapter(getActivity());
		
		adapter.open();
		
		user = LoginFragment.myUser;
		
		first = adapter.getFirstName(user);
		username = adapter.getUser(user);
		sZip = adapter.getZip(user);
		sVehicle = adapter.getVehicle(user);
		sBio = adapter.getInfo(user);
		
		name.setText(first + " (" + username + ")");
		zip.setText(sZip);
		vehicle.setText(sVehicle);
		bio.setText(sBio);
		
		adapter.close();
		
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String sb = bio.getText().toString();
				adapter.open();
				adapter.updateInfo(sb, user);
				adapter.close();
				
				getActivity().onBackPressed();
			}
		});
		
		return view;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
	    super.onCreate(savedInstanceState);

	    setHasOptionsMenu(true);
	    setRetainInstance(true);
	}
	
/*	@Override
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
	}*/
	
/*	@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    super.onPrepareOptionsMenu(menu);

	    MenuItem profile  = menu.findItem(R.id.back);
	    profile.setVisible(true);

	}*/
}
