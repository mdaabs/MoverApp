package edu.umb.cs443.Mover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login,
				container, false);
		
		Button create = (Button) view.findViewById(R.id.create_button);
		Button login = (Button) view.findViewById(R.id.login_button);

		final Fragment frag = new CreateAccountFragment();
		final Fragment buttons = new StartButtonsFragment();
		final Fragment loginFrag = new LoginFragment();

		final FragmentManager fm = getActivity().getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		
		/*create.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ft.replace(R.id.top_fragment, frag);
				ft.replace(R.id.bottom_fragment, buttons);
				ft.remove(buttons);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ft.replace(R.id.top_fragment, loginFrag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});*/
		return view;
	}
}
