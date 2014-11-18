package edu.umb.cs443.Mover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class HomeFragment extends Fragment {

	EditText search;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		search = (EditText) view.findViewById(R.id.search_movers);

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Toast msg = Toast.makeText(getActivity(),
						"Movers are found within the area of the entered zip code.", Toast.LENGTH_LONG);
				msg.show();

			}

		});
		return view;
	}

}
