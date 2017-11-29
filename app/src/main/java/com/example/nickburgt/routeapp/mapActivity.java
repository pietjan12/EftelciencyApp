package com.example.nickburgt.routeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class mapActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Standaard dingen initialiseren
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Actionbar verbergen zodat map beter zichtbaar is.
        getSupportActionBar().hide();

        //Slide left menu initialiseren
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setNavigationViewListner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Item clicks
        switch (item.getItemId()) {

            case R.id.attracties: {
                //do somthing
                Intent intent = new Intent(this, Attracties.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "Attracties", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.eten: {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);

                //Toast.makeText(getApplicationContext(), "Eten", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.contact: {
                Toast.makeText(getApplicationContext(), "Contact", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        //Navigatie drawer sluiten.
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
