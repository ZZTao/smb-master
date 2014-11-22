package com.example.administrator.smb.tab;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TabHost;

import com.example.administrator.smb.ContactActivity;
import com.example.administrator.smb.DialerActivity;
import com.example.administrator.smb.R;
import com.example.administrator.smb.RecentActivity;
import com.example.administrator.smb.SmartBarUtils;

/**
 * Created by Administrator on 2014/11/22.
 */
public class ActionBarTabAndTabHost extends TabActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean findMethod = findActionBarTabsShowAtBottom();
        if(!findMethod){
            getWindow().setUiOptions(0);
        }

        setContentView(R.layout.tab_content);

        final TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("recent").setIndicator(null, getResources().getDrawable(R.drawable.ic_tab_recent))
            .setContent(new Intent(this, RecentActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("contacts").setIndicator(null, getResources().getDrawable(R.drawable.ic_tab_contacts))
            .setContent(new Intent(this, ContactActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("dialer").setIndicator(null, getResources().getDrawable(R.drawable.ic_tab_dialer))
            .setContent(new Intent(this, DialerActivity.class)));
        if(findMethod){
            getTabWidget().setVisibility(View.GONE);

            final ActionBar bar = getActionBar();
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            bar.addTab(bar.newTab().setIcon(R.drawable.ic_tab_recent).setTabListener(this));
            bar.addTab(bar.newTab().setIcon(R.drawable.ic_tab_contacts).setTabListener(this));
            bar.addTab(bar.newTab().setIcon(R.drawable.ic_tab_dialer).setTabListener(this));
            SmartBarUtils.setActionBarTabsShowAtBottom(bar,true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    private boolean findActionBarTabsShowAtBottom(){
        try{
            Class.forName("android.app.ActionBar")
                    .getMethod("setTabsShowAtBottom", new Class[]{boolean.class});
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(tab!=null){
            getTabHost().setCurrentTab(tab.getPosition());
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
