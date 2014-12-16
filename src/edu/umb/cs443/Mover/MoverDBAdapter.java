package edu.umb.cs443.Mover;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.webkit.WebView.FindListener;
import edu.umb.cs443.Mover.MoverDBContract.MoverDB;

public class MoverDBAdapter {

	public SQLiteDatabase db;
	private final Context context;

	private MoverDBHelper dbHelper;

	public MoverDBAdapter(Context _context) {

		context = _context;
		dbHelper = new MoverDBHelper(context);

	}

	public MoverDBAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
	}

	public SQLiteDatabase getDatabaseInstance() {
		return db;
	}

	public void insertAccount(String user, String pass, String first,
			String last, String zip, String vehicle) {
		ContentValues values = new ContentValues();

		values.put(MoverDB.COLUMN_NAME_USERNAME, user);
		values.put(MoverDB.COLUMN_NAME_PASSWORD, pass);
		values.put(MoverDB.COLUMN_NAME_FIRST_NAME, first);
		values.put(MoverDB.COLUMN_NAME_LAST_NAME, last);
		values.put(MoverDB.COLUMN_NAME_PROFILE_ZIP, zip);
		values.put(MoverDB.COLUMN_NAME_PROFILE_VEHICLE, vehicle);

		db.insert(MoverDB.TABLE_NAME, null, values);
	}

	public String getAccountPass(String user) {

		Cursor cursor = db.query(MoverDB.TABLE_NAME, null,
				MoverDB.COLUMN_NAME_USERNAME + "=?", new String[] { user },
				null, null, null);
		if (cursor.getCount() < 1) {
			cursor.close();
			return "DOES NOT EXIST";
		}
		cursor.moveToFirst();
		String pass = cursor.getString(cursor
				.getColumnIndex(MoverDB.COLUMN_NAME_PASSWORD));
		cursor.close();
		return pass;
	}

	public String getFirstName(String user) {

		Cursor cursor = db.query(MoverDB.TABLE_NAME, null,
				MoverDB.COLUMN_NAME_USERNAME + "=?", new String[] { user },
				null, null, null);
		if (cursor.getCount() < 1) {
			cursor.close();
			return "N/A";
		}
		cursor.moveToFirst();
		String fName = cursor.getString(cursor
				.getColumnIndex(MoverDB.COLUMN_NAME_FIRST_NAME));
		cursor.close();
		return fName;
	}
	
	public String getLastName(String user) {
		Cursor cursor = db.query(MoverDB.TABLE_NAME, null,
				MoverDB.COLUMN_NAME_USERNAME + "=?", new String[] { user },
				null, null, null);
		if (cursor.getCount() < 1) {
			cursor.close();
			return "N/A";
		}
		cursor.moveToFirst();
		String lName = cursor.getString(cursor
				.getColumnIndex(MoverDB.COLUMN_NAME_LAST_NAME));
		cursor.close();
		return lName;
	}
	
	public String getZip(String user) {
		Cursor cursor = db.query(MoverDB.TABLE_NAME, null,
				MoverDB.COLUMN_NAME_USERNAME + "=?", new String[] { user },
				null, null, null);
		if (cursor.getCount() < 1) {
			cursor.close();
			return "N/A";
		}
		cursor.moveToFirst();
		String zip = cursor.getString(cursor
				.getColumnIndex(MoverDB.COLUMN_NAME_PROFILE_ZIP));
		cursor.close();
		return zip;
	}
	
	public String getVehicle(String user) {
		Cursor cursor = db.query(MoverDB.TABLE_NAME, null,
				MoverDB.COLUMN_NAME_USERNAME + "=?", new String[] { user },
				null, null, null);
		if (cursor.getCount() < 1) {
			cursor.close();
			return "N/A";
		}
		cursor.moveToFirst();
		String vehicle = cursor.getString(cursor
				.getColumnIndex(MoverDB.COLUMN_NAME_PROFILE_VEHICLE));
		cursor.close();
		return vehicle;
	}
}
