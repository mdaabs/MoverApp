package edu.umb.cs443.Mover;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {
	
	public static String u;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login, container, false);

		Button login = (Button) view.findViewById(R.id.login_submit);
		final MoverDBAdapter adapter = new MoverDBAdapter(getActivity());
		final EditText mUser = (EditText) view
				.findViewById(R.id.username_login);
		final EditText mPass = (EditText) view
				.findViewById(R.id.password_login);

		final Fragment homeFrag = new HomeFragment();
		final Fragment buttons = new StartButtonsFragment();

		final FragmentManager fm = getActivity().getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				adapter.open();
				
				String user = mUser.getText().toString();
				String pass = mPass.getText().toString();
				String dbPass = adapter.getAccountPass(user);

				if (!dbPass.equals(pass)) {

					DialogFragment msg = new CreateFailedDialogFragment();
					msg.show(getActivity().getFragmentManager(), "failed");

				} else {
					
					ft.replace(R.id.top_fragment, homeFrag);
					ft.replace(R.id.bottom_fragment, buttons);
					ft.remove(buttons);
					ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
					ft.addToBackStack(null);
					ft.commit();
					
					u = user;
				}
				adapter.close();
			}
		});
		return view;
	}
}
