package pt.projecttransporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by JuLIANG on 5/03/15.
 */
public class uq9db_handler extends SQLiteOpenHelper{
  
  // All static variables
  // Ensuring only and ONLY one instance of DatabaseHelper is 
	// existing at any given time
	private static uq9db_handler db_instance
	
	// Database version
	// Database Name and Paths
	private static final String DB_NAME = "UQ9DB.db";
	private static final String DB_PATH = "/data/data/com.example.transport/databases/";

	// Contacts table name
	private static final String TABLE_CONTACTS = "uq9db";

	// Contacts Table Columns names
	private static final String K_ID = "id";
	private static final String K_NAME = "name";
	private static final String K_GENDER = "gender";
	private static final String K_DRIVER = "driver";
	private static final String K_STUDENT = "student";
	private static final String K_CARCAP = "carcap";
	private static final String K_GOING = "going";
}
