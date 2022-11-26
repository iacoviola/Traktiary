package com.emidev.traktiary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emidev.traktiary.R;
import com.emidev.traktiary.model.Trending;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder> {

    //private final Context context;
    private final List<Trending> showList;

    // Constructor
    public ShowAdapter(Context context, List<Trending> showList) {
        //this.context = context;
        this.showList = showList;
    }

    @NonNull
    @Override
    public ShowAdapter.ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_show, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ShowViewHolder holder, int position) {

        Trending show = showList.get(holder.getAdapterPosition());
        //TODO: Set the image of the show using Glide
        //holder.showImageView.setImageResource();
        holder.titleTextView.setText(show.getShow().getTitle());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return showList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ShowViewHolder extends RecyclerView.ViewHolder {
        private final ImageView showImageView;
        private final TextView titleTextView;

        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);
            showImageView = itemView.findViewById(R.id.show_poster_image_view);
            titleTextView = itemView.findViewById(R.id.show_title_text_view);
        }
    }
}

