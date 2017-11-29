package com.example.nickburgt.routeapp;

import android.content.Context;
import android.widget.ImageView;

import com.qozix.tileview.TileView;

import java.util.ArrayList;

/**
 * Created by jan on 10-11-2017.
 */

public class Map {
    //Context voor creeren elementen
    private Context context;
    //Hoeveeleid attracties/Punten van aandacht
    private int numberOfRides = 6;

    private ArrayList<Coords> coordinates = new ArrayList<Coords>();

    private TileView tileview;


    public Map(Context context, int width, int height) {
        this.context = context;

        tileview = new TileView(context);

        //Tiles toevoegen en waardes initialiseren
        createMap(width, height);

        //Locaties opvragen vanuit database
        GetMarkerLocations();

        //Markers/points of interest toevoegen
        createMarkers();
    }

    private void createMap(int width, int height) {
        tileview.setSize(width, height);

        tileview.addDetailLevel( 1.000f, "1000/%d_%d.jpg", 256, 256 );
        tileview.addDetailLevel( 0.500f, "500/%d_%d.jpg", 256, 256 );
        tileview.addDetailLevel( 0.250f, "250/%d_%d.jpg", 256, 256 );
        tileview.addDetailLevel( 0.125f, "125/%d_%d.jpg", 128, 128 );

        tileview.setMarkerAnchorPoints( -0.5f, -1.0f );
    }

    private void GetMarkerLocations() {
        //Sqlite query bladiebladiebla

        int x = 450;
        int y = 500;
        //Voor nu hard coded om te testen
        for (int i = 0; i < numberOfRides; i++) {
            coordinates.add(new Coords(x, y));
            x += 50;
            y += 100;
        }
    }

    private void createMarkers(){
        for(Coords loc : coordinates) {
            //View genereren voor marker
            ImageView marker = new ImageView(context);
            //Coordinaten opslaan in tag
            marker.setTag(loc);

            //Icoontje toevoegen aan ImageView.
            marker.setImageResource(R.drawable.marker);
            //Toevoegen aan map.
            tileview.addMarker(marker, loc.getX(), loc.getY(), null, null );
        }
    }

    public TileView getMap() {
        return tileview;
    }
}
