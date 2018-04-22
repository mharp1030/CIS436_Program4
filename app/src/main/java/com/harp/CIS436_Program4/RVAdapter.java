package com.harp.CIS436_Program4;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MovieHolder> {

    public static class MovieHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView year;
        TextView Desc;
        ImageView photo;

        MovieHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            Desc = itemView.findViewById(R.id.desc);
            photo = itemView.findViewById(R.id.photo);
        }
    }

    List<Movies> movies;

    RVAdapter(List<Movies> movies){
        this.movies = movies;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MovieHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieHolder MovieHolder, int i) {
        MovieHolder.title.setText(movies.get(i).Title);
        MovieHolder.year.setText(movies.get(i).ReleaseYr);
        MovieHolder.Desc.setText(movies.get(i).Desc);
        MovieHolder.photo.setImageResource(movies.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}