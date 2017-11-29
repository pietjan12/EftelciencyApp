package com.example.nickburgt.routeapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Info
    /** Indien er iets aangepast is in de database -> DATABASE_VERSION omhoog zetten. OnUpgrade wordt dan automatisch aangeroepen. */
    private static final String DATABASE_NAME = "eftelciency";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_events = "Attracties";


    // Attracties Table Columns
    private static final String KEY_THEME_ID = "id";
    private static final String KEY_THEME_TYPE = "attractietype";
    private static final String KEY_THEME_NAME = "attractienaam";
    private static final String KEY_THEME_LOCATION = "attractielocatie";
    private static final String KEY_THEME_STATUS = "attractiestatus";
    private static final String KEY_THEME_WAITTIME = "attractiewachttijd";
    private static final String KEY_THEME_PERCENTAGE = "attractiepercentage";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_RIDES_TABLE = "CREATE TABLE " + TABLE_events +
                "(" +
                KEY_THEME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + // Define a primary key
                KEY_THEME_TYPE + " VARCHAR, " +
                KEY_THEME_NAME + " VARCHAR NOT NULL," +
                KEY_THEME_LOCATION + " INTEGER," +
                KEY_THEME_STATUS + " VARCHAR," +
                KEY_THEME_WAITTIME + "  INTEGER," +
                KEY_THEME_PERCENTAGE + " VARCHAR" +
                ")";

        String sql = "INSERT INTO Attracties (attractietype, attractienaam, attractielocatie,attractiestatus,attractiewachttijd,attractiepercentage) VALUES('Attractie','Baron',1,'open',20,'50%')" ;

        db.execSQL(CREATE_RIDES_TABLE);
        db.execSQL(sql);
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            //opnieuw database creeren
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_events);
            onCreate(db);
        }
    }
}
