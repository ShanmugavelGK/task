package com.gkshanmugavel.mobile.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gkshanmugavel.mobile.fragments.PopularFragment;
import com.gkshanmugavel.mobile.R;

public class PagesAdapter extends FragmentPagerAdapter {

    private Context mContext;

    final static int FRAGMENT_COUNT = 3;

    public PagesAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PopularFragment();
        } else if (position == 1) {
            return new PopularFragment();
        } else {
            return new PopularFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.popular);
            case 1:
                return mContext.getString(R.string.near_by);
            case 2:
                return mContext.getString(R.string.search);
            default:
                return null;
        }
    }
}
