package edu.umb.cs443.Mover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeFragment extends Fragment {

	EditText search;
	ImageButton profile;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		search = (EditText) view.findViewById(R.id.search_movers);
		profile = (ImageButton) view.findViewById(R.id.search_profile_pic);

		final Fragment profileFrag = new ProfileFragment();

		final FragmentManager fm = getActivity().getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Toast msg = Toast
						.makeText(
								getActivity(),
								"Movers are found within the area of the entered zip code.",
								Toast.LENGTH_LONG);
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

		return view;
	}

}
