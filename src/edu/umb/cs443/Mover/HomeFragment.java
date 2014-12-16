package edu.umb.cs443.Mover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

	EditText search, mUser;
	ImageButton profile;
	Button movers;
	MoverDBAdapter adapter;
	TextView welcome;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		search = (EditText) view.findViewById(R.id.search_movers);
		profile = (ImageButton) view.findViewById(R.id.search_profile_pic);
		movers = (Button) view.findViewById(R.id.search_zip);
		adapter = new MoverDBAdapter(getActivity());
		welcome = (TextView) view.findViewById(R.id.welcome_home);

		final Fragment profileFrag = new ProfileFragment();
		final Fragment results = new ResultsFragment();

		final FragmentManager fm = getActivity().getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		
		adapter.open();
		
		String user = LoginFragment.u;
		
		String first = adapter.getFirstName(user);
		welcome.setText("Welcome Home, " + first + "!");
		
		adapter.close();

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Toast msg = Toast
						.makeText(
								getActivity(),
								"Movers are found within the area of the entered zip code.",
								9000);
				msg.setGravity(Gravity.CENTER_VERTICAL, 0, 40);
				msg.show();

			}
		});

		profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				ft.replace(R.id.top_fragment, profileFrag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();

			}
		});

		movers.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ft.replace(R.id.top_fragment, results);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();

			}
		});

		return view;
	}
}
