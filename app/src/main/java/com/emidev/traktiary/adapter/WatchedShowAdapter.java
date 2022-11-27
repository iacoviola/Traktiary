package com.emidev.traktiary.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.emidev.traktiary.R;
import com.emidev.traktiary.TMDBAPIClient;
import com.emidev.traktiary.TMDBAPIInterface;
import com.emidev.traktiary.model.TMDB.TMDBShow;
import com.emidev.traktiary.model.Trakt.Trending.Trending;
import com.emidev.traktiary.model.Trakt.Watched.Watched;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WatchedShowAdapter extends RecyclerView.Adapter<WatchedShowAdapter.ShowViewHolder> {

    private final Fragment fragment;
    private final List<Watched> showList;

    // Constructor
    public WatchedShowAdapter(Fragment fragment, List<Watched> showList) {
        this.fragment = fragment;
        this.showList = showList;
    }

    @NonNull
    @Override
    public WatchedShowAdapter.ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_show, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchedShowAdapter.ShowViewHolder holder, int position) {

        Watched show = showList.get(holder.getAdapterPosition());

        TMDBAPIInterface tmdbApiInterface = TMDBAPIClient.getClient().create(TMDBAPIInterface.class);

        tmdbApiInterface.getTMDBShow(show.getShow().getIds().getTmdb()).enqueue(new Callback<TMDBShow>() {
            @Override
            public void onResponse(@NonNull Call<TMDBShow> call, @NonNull Response<TMDBShow> response) {
                if(response.isSuccessful()) {
                    TMDBShow TMDBshow = response.body();

                    if (TMDBshow != null) {
                        Glide.with(fragment)
                                .load("https://image.tmdb.org/t/p/w500" + TMDBshow.getPosterPath())
                                .placeholder(R.drawable.ic_baseline_movie_24)
                                .into(holder.showImageView);
                    } else {
                        Glide.with(fragment)
                                .load(R.drawable.ic_baseline_movie_24)
                                .into(holder.showImageView);
                    }
                } else {
                    Log.d("TMDB", "onResponse: " + response.message());
                }


            }

            @Override
            public void onFailure(@NonNull Call<TMDBShow> call, @NonNull Throwable t) {
                call.cancel();
            }
        });

        holder.titleTextView.setText(show.getShow().getTitle());
        holder.watchersTextView.setTextSize(13);
        holder.watchersTextView.setText(String.valueOf(show.getWatcher_count()));
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return showList.size();
    }

    public void clear() {
        showList.clear();
        notifyItemRangeRemoved(0, showList.size());

    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ShowViewHolder extends RecyclerView.ViewHolder {
        private final ImageView showImageView;
        private final TextView titleTextView;
        private final TextView watchersTextView;

        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);
            showImageView = itemView.findViewById(R.id.show_poster_image_view);
            titleTextView = itemView.findViewById(R.id.show_title_text_view);
            watchersTextView = itemView.findViewById(R.id.show_watchers_text_view);
        }
    }
}

