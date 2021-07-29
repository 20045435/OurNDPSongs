package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter (Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTile);
        TextView tvSingers = rowView.findViewById(R.id.textViewSingers);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvStars = rowView.findViewById(R.id.textViewStars);
        ImageView ivNew = rowView.findViewById(R.id.imageViewNew);
        RatingBar rbar = rowView.findViewById(R.id.ratingBar);

        // Obtain the Android Version information based on the position
        Song currentItem = songList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentItem.getTitle());
        tvSingers.setText(currentItem.getSingers());
        tvYear.setText(String.valueOf(currentItem.getYearReleased()));
        rbar.setRating(currentItem.getStars());

        if (currentItem.getYearReleased() >= 2019) {
            ivNew.setImageResource(R.drawable.newsong);
        } else {
            ivNew.setVisibility(View.INVISIBLE);
        }
        return rowView;
    }
}
