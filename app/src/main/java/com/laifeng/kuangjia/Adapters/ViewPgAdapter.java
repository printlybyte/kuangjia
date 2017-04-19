package com.laifeng.kuangjia.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuguodong on 2017/4/19.
 */

public class ViewPgAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList=new ArrayList<>();

    public ViewPgAdapter(FragmentManager fm, List<Fragment>  mList) {
        super(fm);
        this.mList=mList;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
