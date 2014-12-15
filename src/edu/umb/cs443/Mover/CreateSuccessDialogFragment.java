package edu.umb.cs443.Mover;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;

public class CreateSuccessDialogFragment extends DialogFragment {

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		final FragmentManager fm = getActivity().getFragmentManager();
		
		final LogoFragment logo = new LogoFragment();
		final LoginFragment login = new LoginFragment();
		
		builder.setMessage("Account Created!")
				.setPositiveButton("Continue", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {						
						
						// needs to exit back to logo and login fragment; fix it
						fm.popBackStack();

					}
				});

		return builder.create();
	}
}
