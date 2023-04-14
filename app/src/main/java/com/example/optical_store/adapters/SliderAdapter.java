package com.example.optical_store.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.optical_store.activities.OnBoardingActivity;

public class SliderAdapter extends PagerAdapter {
    public SliderAdapter(OnBoardingActivity onBoardingActivity) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
