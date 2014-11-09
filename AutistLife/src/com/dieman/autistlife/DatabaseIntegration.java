package com.dieman.autistlife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseIntegration {

	private static final String DATABASE_NAME = "autist_life_db";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_TABLE = "subcategories";
	public static final String ROW_ID = "id";
	public static final String KEY_NAME = "subcategories_name";
	public static final String KEY_LIKES = "subcategories_likes";
	public static final String KEY_DISLIKES = "subcategories_dislikes";
	
	private DBHelper dbHelper;
	private final Context context;
	private SQLiteDatabase autistDatabase;
	
	private static class DBHelper extends SQLiteOpenHelper
	{

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
		db.execSQL(
				 "CREATE TABLE IF NOT EXISTS"+ DATABASE_TABLE +" (" +
				 	ROW_ID + "INT(11) PRIMARY KEY AUTOINCREMENT, "	
				 	+KEY_NAME+"VARCHAR(255) NOT NULL"+
				 	KEY_LIKES+"INT(5) DEFAULT 0"+
				 	KEY_DISLIKES + "INT(5) DEFAULT 0);"
				);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public DatabaseIntegration(Context context)
	{
		this.context = context;
	}
}
