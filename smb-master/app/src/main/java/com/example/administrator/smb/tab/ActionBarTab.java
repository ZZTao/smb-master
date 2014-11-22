package com.example.administrator.smb.tab;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.administrator.smb.R;
import com.example.administrator.smb.SmartBarUtils;

/**
 * Created by Administrator on 2014/11/22.
 */
public class ActionBarTab extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar bar = getActionBar();
        bar.addTab(bar.newTab().setIcon(R.drawable.ic_tab_recent)
                .setTabListener(new MyTabListener<RecentFragment>(this, "recent", RecentFragment.class)));
        bar.addTab(bar.newTab().setIcon(R.drawable.ic_tab_contacts)
                .setTabListener(new MyTabListener<ContactFragment>(this, "contacts", ContactFragment.class)));
        bar.addTab(bar.newTab().setIcon(R.drawable.ic_tab_dialer)
                .setTabListener(new MyTabListener<DialerFragment>(this, "contacts", DialerFragment.class)));
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        SmartBarUtils.setActionBarTabsShowAtBottom(bar, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    public static class MyTabListener<T extends Fragment> implements ActionBar.TabListener{

        private final Activity mActivity;
        private final String mTag;
        private final Class<T> mClass;
        private final Bundle mArgs;
        private Fragment mFragment;

        public MyTabListener(Activity activity, String tag, Class<T> clz){
            this(activity, tag, clz, null);
        }

        public MyTabListener(Activity activity, String tag, Class<T> clz, Bundle args){
            mActivity = activity;
            mTag = tag;
            mClass = clz;
            mArgs = args;

            mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);
            if(mFragment!=null&&!mFragment.isDetached()){
                FragmentTransaction ft = mActivity.getFragmentManager().beginTransaction();
                ft.detach(mFragment);
                ft.commit();
            }
        }
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            if(mFragment == null){
                mFragment = Fragment.instantiate(mActivity, mClass.getName(), mArgs);
                ft.add(android.R.id.content, mFragment, mTag);
            }else{
                ft.attach(mFragment);
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            if(mFragment!=null){
                ft.detach(mFragment);
            }
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(mActivity, "Reselected!", Toast.LENGTH_SHORT).show();
        }
    }
}
