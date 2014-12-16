package edu.umb.cs443.Mover;

import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import edu.umb.cs443.Mover.MoverDBContract.MoverDB;

public class CreateAccountFragment extends Fragment {

	Button submit;
	EditText mUser, mPass, mConf, mFirst, mLast, mZip, mVehicle;
	MoverDBAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_create_account,
				container, false);

		submit = (Button) view.findViewById(R.id.account_submit);

		mUser = (EditText) view.findViewById(R.id.username_create);
		mPass = (EditText) view.findViewById(R.id.password_create);
		mConf = (EditText) view.findViewById(R.id.password_confirm);
		mFirst = (EditText) view.findViewById(R.id.first_name);
		mLast = (EditText) view.findViewById(R.id.last_name);
		mZip = (EditText) view.findViewById(R.id.create_zip);
		mVehicle = (EditText) view.findViewById(R.id.create_vehicle);

		adapter = new MoverDBAdapter(getActivity());

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				adapter.open();
				String user = mUser.getText().toString();
				String pass = mPass.getText().toString();
				String confirm = mConf.getText().toString();
				String first = mFirst.getText().toString();
				String last = mLast.getText().toString();
				String zip = mZip.getText().toString();
				String vehicle = mVehicle.getText().toString();

				if (!confirm.equals(pass)) {

					DialogFragment msg = new CreateFailedDialogFragment();
					msg.show(getActivity().getFragmentManager(), "failed");

				} else {

					adapter.insertAccount(user, pass, first, last, zip, vehicle);

					DialogFragment suc = new CreateSuccessDialogFragment();
					suc.show(getActivity().getFragmentManager(), "success");
				}
				adapter.close();
			}
		});

		return view;
	}

}