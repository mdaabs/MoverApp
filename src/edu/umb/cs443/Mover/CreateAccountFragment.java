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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_create_account,
				container, false);

		Button submit = (Button) view.findViewById(R.id.account_submit);
		final EditText mUser = (EditText) view
				.findViewById(R.id.username_create);
		final EditText mPass = (EditText) view
				.findViewById(R.id.password_create);
		final EditText mConf = (EditText) view
				.findViewById(R.id.password_confirm);
		final MoverDBHelper dbHelper = new MoverDBHelper(view.getContext());

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String user = mUser.getText().toString();
				String pass = mPass.getText().toString();
				String confirm = mConf.getText().toString();

				if (!confirm.equals(pass)) {

					DialogFragment msg = new CreateFailedDialogFragment();
					msg.show(getActivity().getFragmentManager(), "failed");

				} else {

					SQLiteDatabase db = dbHelper.getWritableDatabase();
					ContentValues values = new ContentValues();
					values.put(MoverDB.COLUMN_NAME_USERNAME, user);
					values.put(MoverDB.COLUMN_NAME_PASSWORD, pass);

					long newRowId;
					newRowId = db.insert(MoverDB.TABLE_NAME, null, values);
					
					DialogFragment suc = new CreateSuccessDialogFragment();
					suc.show(getActivity().getFragmentManager(), "success");
				}
			}
		});

		return view;
	}

}