package com.example.nickburgt.routeapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Attracties extends AppCompatActivity {
    private SQLiteDatabase db;
    private RecyclerView attractieList;
    private attractieListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attracties);

        db = App.getDb();

        attractieList = (RecyclerView) findViewById(R.id.attractieList);
        attractieList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        loadGuests();
    }

    private void loadGuests() {
        Cursor getAttracties = db.rawQuery("SELECT rowid _id, id from Attracties limit 20", null);
        getAttracties.moveToFirst();
        if (getAttracties != null && getAttracties.getCount() > 0) {
            listAdapter = new attractieListAdapter(getApplicationContext(), getAttracties);

            attractieList.setAdapter(listAdapter);
        }
    }
}
