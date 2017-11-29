package com.example.nickburgt.routeapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class attractieListAdapter extends RecycleCursorAdapter<attractieListAdapter.CustomViewHolder> {
    private Context mContext;
    private SQLiteDatabase db;

    public attractieListAdapter(Context context, Cursor cursor) {
        super(null);
        this.mContext = context;

        this.db = App.getDb();
        swapCursor(cursor);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.attracties_list, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, Cursor cursor) {
        String themeID = cursor.getString(cursor.getColumnIndex("id"));

        customViewHolder.attractienaam.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension(R.dimen.attractienaamtext));
        customViewHolder.attractietype.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension(R.dimen.attractietypetext));

        customViewHolder.attractiepriority.setVisibility(View.INVISIBLE);

        Cursor getAttractie = db.rawQuery("SELECT attractietype, attractienaam,attractiewachttijd FROM Attracties WHERE id=? LIMIT 1", new String[]{themeID});
        getAttractie.moveToFirst();
        if (getAttractie != null && getAttractie.getCount() > 0) {
            String attractienaam = getAttractie.getString(getAttractie.getColumnIndex("attractienaam"));
            String attractietype = getAttractie.getString(getAttractie.getColumnIndex("attractietype"));
            String attractiewachttijd = getAttractie.getString(getAttractie.getColumnIndex("attractiewachttijd"));

            customViewHolder.attractienaam.setText(attractienaam);
            customViewHolder.attractietype.setText(attractietype);
            customViewHolder.attractiewachttijd.setText(attractiewachttijd);

            // image aanpassen
            //customViewHolder.attractiepriority
        }

        getAttractie.close();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView attractienaam, attractietype, attractiewachttijd;
        protected ImageView attractiepriority;

        public CustomViewHolder(View view) {
            super(view);
            this.attractienaam = (TextView) view.findViewById(R.id.attractienaam);
            this.attractietype = (TextView) view.findViewById(R.id.attractietype);
            this.attractiewachttijd = (TextView) view.findViewById(R.id.attractiewachttijd);
            this.attractiepriority = (ImageView) view.findViewById(R.id.attractiepriority);
        }
    }
}
