package com.example.administrator.smb;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/11/22.
 */
public class CustomTabOnTopActivity extends FragmentActivity implements OnPageChangeListener {

    private int mActionBarOptions;
    private ViewPager mViewPager;

    private View mCustomView;
    private ImageView mScroll1;
    private ImageView mScroll2;
    private ImageView mScroll3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_tab_on_top_content);

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setPageMargin(8);
        mViewPager.setPageMarginDrawable(android.R.drawable.divider_horizontal_bright);

        mCustomView = LayoutInflater.from(this).inflate(R.layout.custom_tab_view, null);
        getParent().getActionBar().setCustomView(mCustomView);

        mScroll1 = (ImageView)mCustomView.findViewById(R.id.scroll_1);
        mScroll2 = (ImageView)mCustomView.findViewById(R.id.scroll_2);
        mScroll3 = (ImageView)mCustomView.findViewById(R.id.scroll_3);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ActionBar bar = getParent().getActionBar();
        mActionBarOptions = bar.getDisplayOptions();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM + mActionBarOptions);
        setCurrentScroll(mViewPager.getCurrentItem());
    }

    private void setCurrentScroll(int selecttion){
        if(mScroll1!=null&&mScroll2!=null&&mScroll3!=null){
            mScroll1.setVisibility(selecttion==0?View.VISIBLE:View.INVISIBLE);
            mScroll2.setVisibility(selecttion==1?View.VISIBLE:View.INVISIBLE);
            mScroll3.setVisibility(selecttion==2?View.VISIBLE:View.INVISIBLE);
        }
    }

    @Override
    protected void onPause() {
       super.onPause();
        getParent().getActionBar().setDisplayOptions(mActionBarOptions, ActionBar.DISPLAY_SHOW_CUSTOM|mActionBarOptions);
    }

    public void onTabClick(View view){
        switch(view.getId()){
            case R.id.tab_text_1:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.tab_text_2:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.tab_text_3:
                mViewPager.setCurrentItem(2, false);
                break;
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return CountingFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public static class CountingFragment extends Fragment{
        int mNum;

        static CountingFragment newInstance(int num){
            CountingFragment f = new CountingFragment();
            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments()!=null?getArguments().getInt("num"):1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.text_content, container, false);
            TextView text = (TextView)v.findViewById(android.R.id.text1);
            text.setText("Fragment "+ mNum);
            return v;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentScroll(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
