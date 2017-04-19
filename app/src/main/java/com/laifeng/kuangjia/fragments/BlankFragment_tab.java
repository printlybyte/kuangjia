package com.laifeng.kuangjia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.laifeng.kuangjia.Adapters.Lunbo_Adapter;
import com.laifeng.kuangjia.MainActivity_test;
import com.laifeng.kuangjia.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment_tab extends Fragment implements View.OnClickListener {
    private LinearLayout linearLayout;
    private View view;
    private Banner mBanner;

    //图片轮播
    List<Integer> mImage_list = new ArrayList<>();
    List<String> mString_list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank_fragment_tab, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        linearLayout = (LinearLayout) view.findViewById(R.id.linear_home_test);
        linearLayout.setOnClickListener(this);
        mBanner = (Banner) view.findViewById(R.id.banner);
        addData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_home_test:
                Intent intent = new Intent(getActivity(), MainActivity_test.class);
                startActivity(intent);
                break;
        }
    }

    //设置banner数据
    private void addData() {
        mImage_list.add(R.mipmap.ic_launcher);
        mImage_list.add(R.mipmap.ic_launcher);
        mImage_list.add(R.mipmap.ic_launcher);
        mImage_list.add(R.mipmap.ic_launcher);
        mString_list.add("1");
        mString_list.add("2");
        mString_list.add("3");
        mString_list.add("4");
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new Lunbo_Adapter());
        //设置图片集合
        mBanner.setImages(mImage_list);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mString_list);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
    }
}

