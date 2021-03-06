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
	private static uq9db_handler uq9db_instance;
	
	// Database version
	// Database Name and Paths
	private static final String DB_NAME = "UQ9DB.db";
	private static final String DB_PATH = "/data/data/pt.projecttransporter/databases/";
	private static final int DB_VERSION = 1;

	// Contacts table name
	private static final String TABLE_MAIN = "uq9db_main";
    	private static final String TABLE_VOLATILE = "uq9db_volatile";

	// Contacts Table Columns names
	private static final String K_ID = "id";
	private static final String K_FIRSTNAME = "firstname";
	private static final String K_LASTNAME = "lastname";
	private static final String K_GENDER = "gender";
	private static final String K_ADDR = "address";
	private static final String K_TEL = "tel";
	private static final String K_DOB = "dob";
	private static final String K_EMAIL = "email";
	private static final String K_FBLINK = "fblink";
	private static final String K_NATIONALITY = "nationality";
	private static final String K_WORKSTAT = "work_stat";
	private static final String K_DRIVE = "drive?";
	private static final String K_CARSPACE = "carspace";
	private static final String K_GOCARD = "gocard";
	
	// Use the application context, which will ensure that you 
	// don't accidentally leak an Activity's context.
	// See this article for more information: http://bit.ly/6LRzfx
	public static uq9db_handler getInstance(Context context) {
		if (uq9db_instance == null) {
			uq9db_instance = new uq9db_handler(context.getApplicationContext());
		}
		return uq9db_instance;
	}
	
	/* Constructor should be private to prevent direct instantiation.
	make call to static factory method "getInstance()" instead */
	private uq9db_handler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		// Check whether database is already exist on path, to ensure 
		// one time call for creating database so that it does not overwrite the old
		// one everytime the application starts
		if (!uq9db_instance.isDatabaseExist()){

			// Create table - Main
			String create_main_table = "CREATE TABLE " + TABLE_MAIN + "("
					+ K_ID + " INTEGER PRIMARY KEY," + K_FIRSTNAME + " TEXT,"
					+ K_LASTNAME + " TEXT," + K_GENDER + " TEXT," 
					+ K_ADDR + " TEXT," + K_TEL  + " TEXT," 
					+ K_DOB + " TEXT," + K_EMAIL + " TEXT,"
					+ K_FBLINK + " TEXT," + K_NATIONALITY + " TEXT,"
					+ K_WORKSTAT + " TEXT," + ")";
			db.execSQL(create_main_table); 	// Execute SQL command
			
			// Create table - Volatile
			String create_volatile_table = "CREATE TABLE " + TABLE_VOLATILE + "("
					+ K_ID + " INTEGER PRIMARY KEY," + K_DRIVE + " TEXT,"
					+ K_CARSPACE + " INT," + K_GOCARD + " TEXT,"
					+ "FOREIGN KEY (" + K_ID + ") "
					+ "REFERENCES " + TABLE_MAIN + "(" + K_ID + ")" + ")";
			db.execSQL(create_drivers_table); // Execute SQL command
		}
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAIN);
        	db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOLATILE);

        	// Create tables again
		onCreate(db);
	}
	
	// Is database exist on path?
	private boolean isDatabaseExist(){
		
		SQLiteDatabase db = null;
		try{
			// Build database path
			String dbpath = DB_PATH + DB_NAME;
			db = SQLiteDatabase.openDatabase(dbpath, null, SQLiteDatabase.OPEN_READWRITE);
			db.setLocale(Locale.getDefault());
			db.setVersion(1);

		} catch (SQLiteException e){			
			Log.e("SQlHelper", "database not found");
		}

		// If database exist on the path, then close it and don't do anything to it
		// and return true
		if (db !=null){
			db.close();
		}

		// Otherwise return false to indicate it is not there
		return db !=null ? true:false;
	}
	
	// Adding a new person's attribute
	void addPerson(uq9db person){
		// Get database instance
		SQLiteDatabase db = uq9db_instance.getWritableDatabase();
		
		// Put attributes/params into content values
		ContentValues values = new ContentValues();
		values.put(K_ID, person.getID());
		values.put(K_FIRSTNAME, person.getFirstname());
		values.put(K_LASTNAME, person.getLastname());
		values.put(K_GENDER, person.getGender().toString());
		values.put(K_ADDR, person.getAddress());
		values.put(K_TEL, person.getTel().toString());
		values.put(K_DOB, person.getDoB());
		values.put(K_EMAIL, person.getEmail());
		values.put(K_FBLINK, person.getFblink());
		values.put(K_NATIONALITY, person.getNationality());
        	values.put(K_WORKSTAT, person.getWork_stat());

		// Inserting Row
		// VOLATILE TABLE will automatically insert person ID column
		// due to foreign key constraints that was referenced to the 
		// person ID on MAIN TABLE
		db.insert(TABLE_MAIN, null, values);
		db.close(); // Closing database connection
	}
	
	void add_volatileAttr(uq9db_volatile person_volatile){
		// Extract a volatile person's attributes
		
	}
	











}


