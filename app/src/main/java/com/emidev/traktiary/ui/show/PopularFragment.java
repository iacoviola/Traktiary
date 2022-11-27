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

import com.emidev.traktiary.R;
import com.emidev.traktiary.TraktAPIClient;
import com.emidev.traktiary.TraktAPIInterface;
import com.emidev.traktiary.adapter.PopularShowAdapter;
import com.emidev.traktiary.adapter.TrendingShowAdapter;
import com.emidev.traktiary.model.Trakt.Trending.Show;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //inflate
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        //retrofit request
        TraktAPIInterface traktApiInterface = TraktAPIClient.getClient().create(TraktAPIInterface.class);

        Call<List<Show>> trendingShows = traktApiInterface.getPopularShows();

        trendingShows.enqueue(new Callback<List<Show>>() {
            @Override
            public void onResponse(@NonNull Call<List<Show>> call, @NonNull Response<List<Show>> response) {
                if(response.isSuccessful()) {
                    List<Show> shows = response.body();

                    PopularShowAdapter trendingShowAdapter = new PopularShowAdapter(requireParentFragment(), shows);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity(), 2);
                    RecyclerView showRecyclerView = view.findViewById(R.id.show_recycler_view);
                    showRecyclerView.setLayoutManager(layoutManager);
                    showRecyclerView.setAdapter(trendingShowAdapter);
                } else {
                    Log.d("HomeFragment", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Show>> call, @NonNull Throwable t) {
                call.cancel();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}