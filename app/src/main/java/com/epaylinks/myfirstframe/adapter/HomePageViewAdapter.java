package com.epaylinks.myfirstframe.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */

public class HomePageViewAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments=new ArrayList<>();
    private List<String> strings=new ArrayList<>();

    public HomePageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment fragment,String title){
        fragments.add(fragment);
        strings.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
