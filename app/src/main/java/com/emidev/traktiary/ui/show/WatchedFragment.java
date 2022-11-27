package com.emidev.traktiary.ui.show;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.emidev.traktiary.R;
import com.emidev.traktiary.TraktAPIClient;
import com.emidev.traktiary.TraktAPIInterface;
import com.emidev.traktiary.adapter.TrendingShowAdapter;
import com.emidev.traktiary.adapter.WatchedShowAdapter;
import com.emidev.traktiary.model.Trakt.Trending.Trending;
import com.emidev.traktiary.model.Trakt.Watched.Watched;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("Convert2Lambda")
public class WatchedFragment extends Fragment {

    private Integer page = 1;
    private final List<Watched> showsList = new ArrayList<>();
    private TraktAPIInterface traktApiInterface;
    private RecyclerView showRecyclerView;
    private WatchedShowAdapter trendingShowAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //retrofit request
        traktApiInterface = TraktAPIClient.getClient().create(TraktAPIInterface.class);

        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        showRecyclerView = view.findViewById(R.id.show_recycler_view);
        trendingShowAdapter = new WatchedShowAdapter(requireParentFragment(), showsList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity(), 2);

        showRecyclerView.setLayoutManager(layoutManager);
        showRecyclerView.setAdapter(trendingShowAdapter);

        request();

        showRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //if scrolled 50% of the screen
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1)) {
                    page++;
                    request();
                }
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                trendingShowAdapter.clear();
                showRecyclerView.setAdapter(trendingShowAdapter);
                request();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    public void request() {

        Call<List<Watched>> trendingShows = traktApiInterface.getWatchedShows(page);

        trendingShows.enqueue(new Callback<List<Watched>>() {
            @Override
            public void onResponse(@NonNull Call<List<Watched>> call, @NonNull Response<List<Watched>> response) {
                if(response.isSuccessful()) {
                    List<Watched> shows = response.body();
                    if(shows != null) {
                        int previousSize = trendingShowAdapter.getItemCount();
                        showsList.addAll(shows);
                        trendingShowAdapter.notifyItemRangeInserted(previousSize, shows.size());
                    }
                } else {
                    Log.d("HomeFragment", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Watched>> call, @NonNull Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}