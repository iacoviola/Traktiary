package com.emidev.traktiary.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.emidev.traktiary.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MovieFragment extends Fragment {

    ViewPager2 viewPager;
    MovieCollectionAdapter showCollectionAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        showCollectionAdapter = new MovieCollectionAdapter(this);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(showCollectionAdapter);

        ImageButton menuButton = view.findViewById(R.id.menu_image_button);

        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.container);

        menuButton.setOnClickListener(v -> drawerLayout.open());

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Trending");
                    break;
                case 1:
                    tab.setText("Popular");
                    break;
                case 2:
                    tab.setText("Most Watched");
                    break;
            }
        }).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}