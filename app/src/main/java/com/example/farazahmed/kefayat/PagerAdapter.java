package com.example.farazahmed.kefayat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by FarazAhmed on 4/13/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numoftags = 0;
    public PagerAdapter(FragmentManager fm , int numoftags)
    {
      super(fm);
        this.numoftags = numoftags;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 :
                OverviewFragment overviewFragment = new OverviewFragment();
                return  overviewFragment;

            case 1 :
                FeaturesFragment featuresFragment = new FeaturesFragment();
                return featuresFragment;

            case 2 :
                SpecificationsFragment specificationsFragment = new SpecificationsFragment();
                return  specificationsFragment;

            case 3 :
                AvailibilityFragment availibilityFragment = new AvailibilityFragment();
                return availibilityFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numoftags;
    }
}
