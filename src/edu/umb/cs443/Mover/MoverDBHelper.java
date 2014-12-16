package edu.umb.cs443.Mover;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.umb.cs443.Mover.MoverDBContract.MoverDB;

public class MoverDBHelper extends SQLiteOpenHelper {
	// If you change the database schema, you must increment the database
	// version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "android.db";

	// Database creation sql statement
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String DATABASE_CREATE = "CREATE TABLE "
			+ MoverDB.TABLE_NAME + " (" + MoverDB._ID + " INTEGER PRIMARY KEY,"
			+ MoverDB.COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP
			+ MoverDB.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP
			+ MoverDB.COLUMN_NAME_FIRST_NAME + TEXT_TYPE + COMMA_SEP
			+ MoverDB.COLUMN_NAME_LAST_NAME + TEXT_TYPE + COMMA_SEP
			+ MoverDB.COLUMN_NAME_PROFILE_ZIP + TEXT_TYPE + COMMA_SEP
			+ MoverDB.COLUMN_NAME_PROFILE_VEHICLE + TEXT_TYPE + COMMA_SEP
			+ MoverDB.COLUMN_NAME_PROFILE_BIO + TEXT_TYPE + ")";

	private static final String DATABASE_DELETE = "DROP TABLE IF EXISTS "
			+ MoverDB.TABLE_NAME;

	public MoverDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This database is only a cache for online data, so its upgrade policy
		// is
		// to simply to discard the data and start over
		db.execSQL(DATABASE_DELETE);
		onCreate(db);
	}

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}
}