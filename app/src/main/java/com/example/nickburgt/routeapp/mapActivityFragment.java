package com.example.nickburgt.routeapp;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arlib.floatingsearchview.FloatingSearchView;

public class mapActivityFragment extends Fragment {
    private Map eftelingMap;
    private DrawerLayout mDrawer;
    private FloatingSearchView mSearchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mSearchView = (FloatingSearchView)view.findViewById(R.id.searchbar);

        //Lege TileView genereren voor gebruik map
        eftelingMap = new Map(getActivity(), 2040, 1790);
        //Tileview toevoegen aan activity
        ((CoordinatorLayout)view.findViewById(R.id.layout)).addView(eftelingMap.getMap());

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Hamburger menu onclick menu laten zien.

        mDrawer = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
        mSearchView.attachNavigationDrawerToMenuButton(mDrawer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
