package com.example.nickburgt.routeapp;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class App extends Application {
    private static SQLiteDatabase db;
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = new DatabaseHandler(getApplicationContext()).getWritableDatabase();
    }

    public static SQLiteDatabase getDb() {
        return db;
    }
}
