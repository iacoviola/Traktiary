package com.emidev.traktiary.ui.show;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ShowCollectionAdapter extends FragmentStateAdapter {

    public ShowCollectionAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TrendingFragment();
            case 1:
                return new PopularFragment();
            case 2:
                return new WatchedFragment();
            default:
                throw new IllegalArgumentException("Invalid position");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
