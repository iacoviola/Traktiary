package com.emidev.traktiary.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emidev.traktiary.APIClient;
import com.emidev.traktiary.APIInterface;
import com.emidev.traktiary.adapter.ShowAdapter;
import com.emidev.traktiary.databinding.FragmentHomeBinding;
import com.emidev.traktiary.model.Trending;

import java.util.List;

import retrofit2.Call;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        //retrofit request
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<List<Trending>> trendingShows = apiInterface.getTrendingShows();

        trendingShows.enqueue(new retrofit2.Callback<List<Trending>>() {
            @Override
            public void onResponse(@NonNull Call<List<Trending>> call, @NonNull retrofit2.Response<List<Trending>> response) {
                if(response.isSuccessful()) {
                    List<Trending> shows = response.body();

                    ShowAdapter showAdapter = new ShowAdapter(requireActivity(), shows);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity(), 3);
                    binding.showRecyclerView.setLayoutManager(layoutManager);
                    binding.showRecyclerView.setAdapter(showAdapter);
                } else {
                    Log.d("HomeFragment", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Trending>> call, @NonNull Throwable t) {
                call.cancel();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}