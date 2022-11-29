package com.emidev.traktiary.ui.show;

import android.os.Bundle;
import android.util.Log;
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

public class ShowFragment extends Fragment {
    ViewPager2 viewPager;
    ShowCollectionAdapter showCollectionAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton menuButton = view.findViewById(R.id.menu_image_button);

        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.container);

        menuButton.setOnClickListener(v -> drawerLayout.open());

        showCollectionAdapter = new ShowCollectionAdapter(this);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(showCollectionAdapter);

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

}
