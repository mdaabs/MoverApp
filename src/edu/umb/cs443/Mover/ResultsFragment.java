package edu.umb.cs443.Mover;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResultsFragment extends Fragment {

	ListView listViewResults;
	MoverDBAdapter adapter;
	String name, user, vehicle, zip;
	TextView n, u, v, z;
	public static ArrayList<String> list = new ArrayList<String>();

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_results, container,
				false);
		listViewResults = (ListView) view.findViewById(R.id.list_view_results);

		Cursor c;
		c = adapter.createCursor(HomeFragment.zipSearch);
		c.moveToFirst();
		
		while (c.isAfterLast() == false) {
		
			c.moveToNext();
		}

		return view;
	}
}
