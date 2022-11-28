package com.emidev.traktiary.ui.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.emidev.traktiary.ui.app.PopularFragment;
import com.emidev.traktiary.ui.app.TrendingFragment;
import com.emidev.traktiary.ui.app.WatchedFragment;

public class ShowCollectionAdapter extends FragmentStateAdapter {

    private final Bundle bundle;

    public ShowCollectionAdapter(@NonNull Fragment fragment) {
        super(fragment);
        bundle = new Bundle();
        bundle.putBoolean("isMovie", false);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                TrendingFragment tFrag = new TrendingFragment();
                tFrag.setArguments(bundle);
                return tFrag;
            case 1:
                PopularFragment pFrag = new PopularFragment();
                pFrag.setArguments(bundle);
                return pFrag;
            case 2:
                WatchedFragment wFrag = new WatchedFragment();
                wFrag.setArguments(bundle);
                return wFrag;
            default:
                throw new IllegalArgumentException("Invalid position");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
