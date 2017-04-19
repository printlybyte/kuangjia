package com.laifeng.kuangjia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.laifeng.kuangjia.Adapters.ViewPgAdapter;
import com.laifeng.kuangjia.fragments.BlankFragment_tab;
import com.laifeng.kuangjia.fragments.BlankFragment_tab2;
import com.laifeng.kuangjia.fragments.BlankFragment_tab3;
import com.laifeng.kuangjia.fragments.BlankFragment_tab4;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLinear, mLinear2, mLinear3, mLinear4;
    private ImageView mImg, mImg2, mImg3, mImg4;
    private TextView mTlt, mTlt2, mTlt3, mTlt4, mTlt_txt;
    private List<Fragment> mFragment = new ArrayList<>();
    private List<LinearLayout> mLinearList = new ArrayList<>();
    private BlankFragment_tab blankFragment_tab;
    private BlankFragment_tab2 blankFragment_tab2;
    private BlankFragment_tab3 blankFragment_tab3;
    private BlankFragment_tab4 blankFragment_tab4;
    private ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        blankFragment_tab=new BlankFragment_tab();
        blankFragment_tab2=new BlankFragment_tab2();
        blankFragment_tab3=new BlankFragment_tab3();
        blankFragment_tab4=new BlankFragment_tab4();
        mFragment.add(blankFragment_tab);
        mFragment.add(blankFragment_tab2);
        mFragment.add(blankFragment_tab3);
        mFragment.add(blankFragment_tab4);
        mLinearList.add(mLinear);
        mLinearList.add(mLinear2);
        mLinearList.add(mLinear3);
        mLinearList.add(mLinear4);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTlt_txt = (TextView) findViewById(R.id.include_title);
        mLinear = (LinearLayout) findViewById(R.id.line1);
        mLinear2 = (LinearLayout) findViewById(R.id.line2);
        mLinear3 = (LinearLayout) findViewById(R.id.line3);
        mLinear4 = (LinearLayout) findViewById(R.id.line4);
        mImg = (ImageView) findViewById(R.id.img1);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg3 = (ImageView) findViewById(R.id.img3);
        mImg4 = (ImageView) findViewById(R.id.img4);
        mTlt = (TextView) findViewById(R.id.tlt1);
        mTlt2 = (TextView) findViewById(R.id.tlt2);
        mTlt3 = (TextView) findViewById(R.id.tlt3);
        mTlt4 = (TextView) findViewById(R.id.tlt4);
        mLinear.setOnClickListener(this);
        mLinear2.setOnClickListener(this);
        mLinear3.setOnClickListener(this);
        mLinear4.setOnClickListener(this);
        setBottombar(0);

        ViewPgAdapter adapter = new ViewPgAdapter(getSupportFragmentManager(), mFragment);
        mViewpager.setAdapter(adapter);
        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setBottombar(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.line1:
                setBottombar(0);


                break;
            case R.id.line2:
                setBottombar(1);
                break;
            case R.id.line3:
                setBottombar(2);
                break;
            case R.id.line4:
                setBottombar(3);
                break;
        }
    }




    public void setBottombar(int num) {
        mImg.setImageResource(R.mipmap.message_select);
        mImg2.setImageResource(R.mipmap.message_select);
        mImg3.setImageResource(R.mipmap.message_select);
        mImg4.setImageResource(R.mipmap.message_select);
        mTlt.setTextColor(getResources().getColor(R.color.colorPrimary));
        mTlt2.setTextColor(getResources().getColor(R.color.colorPrimary));
        mTlt3.setTextColor(getResources().getColor(R.color.colorPrimary));
        mTlt4.setTextColor(getResources().getColor(R.color.colorPrimary));
        switch (num) {
            case 0:
                mTlt_txt.setText("首页1");
                mImg.setImageResource(R.mipmap.my_normal);
                mTlt.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                mTlt_txt.setText("首页2");
                mImg2.setImageResource(R.mipmap.my_normal);
                mTlt2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                mTlt_txt.setText("首页3");
                mImg3.setImageResource(R.mipmap.my_normal);
                mTlt3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                mTlt_txt.setText("首页4");
                mImg4.setImageResource(R.mipmap.my_normal);
                mTlt4.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }

    }
}
