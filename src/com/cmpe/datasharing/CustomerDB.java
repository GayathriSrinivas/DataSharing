package com.cmpe.datasharing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class CustomerDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "customerManager";
    private static final String TABLE_CUSTOMER = "customer";
 
    // Customer Table Columns names
    private static final String CUSTOMER_ID = "cid";
    private static final String FNAME = "fname";
    private static final String LNAME = "lname";
    private static final String ADDRESS = "address";
    private static final String DETAILS = "details";
    
    //One Time Instantiation 
    static CustomerDB instance = null;
    static SQLiteDatabase db = null;
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CUSTOMER + "("
                + CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    		    + FNAME + " TEXT,"
                + LNAME + " TEXT, "
                + ADDRESS + " TEXT, "
                + DETAILS + " TEXT "
    		    + ")";
       	Log.i("CustomerDB String",CREATE_CUSTOMER_TABLE);
        db.execSQL(CREATE_CUSTOMER_TABLE);	
	}
    
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(db);		
	}
	
    public static void init(Context context) {
        if (null == instance) {
            instance = new CustomerDB(context);
        }
    }
    
    public static void deactivate() {
        if (null != db && db.isOpen()) {
            db.close();
        }
        db = null;
        instance = null;
    }
    
    public static SQLiteDatabase getDb() {
        if (null == db) {
            db = instance.getWritableDatabase();
        }
        return db;
    }
    
	public CustomerDB(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);	
	}
		
	public static void addCustomer(Customer customer){
	    SQLiteDatabase db = getDb();	    
	    ContentValues values = new ContentValues();
	    values.put(FNAME, customer.getFname()); 
	    values.put(LNAME, customer.getLname());
	    values.put(ADDRESS, customer.getAddress());
	    values.put(DETAILS, customer.getDetails());
	    db.insert(TABLE_CUSTOMER, null, values);
	    db.close();
	}
	
	public static Cursor getCustomerNames(){
		String query = "SELECT cid as _id, fname, lname, address, details  FROM " + TABLE_CUSTOMER ;
		return getDb().rawQuery(query, null);
	}
}
