package edu.umb.cs443.Mover;

import android.provider.BaseColumns;

public final class MoverDBContract {
	public MoverDBContract() {}

	/* Inner class that defines the table contents */
	public static abstract class MoverDB implements BaseColumns {
		public static final String TABLE_NAME = "moverAppDB";
		public static final String COLUMN_NAME_USERNAME = "username";
		public static final String COLUMN_NAME_PASSWORD = "password";
		public static final String COLUMN_NAME_FIRST_NAME = "first_name";
		public static final String COLUMN_NAME_LAST_NAME = "last_name";
		public static final String COLUMN_NAME_PROFILE_ZIP = "zip";
		public static final String COLUMN_NAME_PROFILE_VEHICLE = "vehicle";
		public static final String COLUMN_NAME_PROFILE_BIO = "bio";
	}
}
