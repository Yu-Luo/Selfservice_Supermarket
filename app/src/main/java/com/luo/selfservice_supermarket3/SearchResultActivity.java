package com.luo.selfservice_supermarket3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

public class SearchResultActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        initView();
        mTextMessage = (TextView) findViewById(R.id.message);
        pager = (ViewPager) findViewById(R.id.viewpager_search);
        pager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        tabs.setShouldExpand(true);
        tabs.setUnderlineHeight(0);
        tabs.setTextSize(38);
    }

    private void initView() {
    }

    class myPagerAdapter extends FragmentPagerAdapter {
        String[] title = { "                  超市                 ", "                 商品                   "};
        Fragment_search01 fragment1;
        Fragment_search02 fragment2;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment1 = new Fragment_search01();
                    return fragment1;
                case 1:
                    fragment2 = new Fragment_search02();
                    return fragment2;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }

}
