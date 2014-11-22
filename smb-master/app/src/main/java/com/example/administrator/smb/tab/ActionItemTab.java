package com.example.administrator.smb.tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import com.example.administrator.smb.ContactActivity;
import com.example.administrator.smb.DialerActivity;
import com.example.administrator.smb.R;
import com.example.administrator.smb.RecentActivity;

/**
 * Created by Administrator on 2014/11/22.
 */
public class ActionItemTab extends TabActivity {

    //这里的几个tab按顺序  0 1 2  和下面addTab的顺序保持一致
    private final static int TAB_INDEX_RECENT = 0;
    private final static int TAB_INDEX_CONTACTS = 1;
    private final static int TAB_INDEX_DIALER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_content);

        final TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("recent").setIndicator("recent")
                .setContent(new Intent(this, RecentActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("contacts").setIndicator("contacts")
                .setContent(new Intent(this, ContactActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("dialer").setIndicator("dialer")
                .setContent(new Intent(this, DialerActivity.class)));
        getTabWidget().setVisibility(View.GONE);
    }

    @Override//这里创建最下面的导航栏的图标
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tab_menu, menu);
        return true;
    }

    @Override//这里刷新导航栏的图标   当前被选中的图标应该是高亮的
    public boolean onPrepareOptionsMenu(Menu menu) {
        for(int i = 0; i<menu.size(); i++){
            refreshTabIcon(menu.getItem(i), getTabHost().getCurrentTab());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private void refreshTabIcon(MenuItem item, int currentTab){
        if(item.getGroupId() == R.id.tab_group){
            switch(item.getItemId()){
                case R.id.tab_menu_recent:
                    item.setIcon(currentTab == TAB_INDEX_RECENT?
                            R.drawable.ic_tab_selected_recent:R.drawable.ic_tab_unselected_recent);
                    break;
                case R.id.tab_menu_contacts:
                    item.setIcon(currentTab == TAB_INDEX_CONTACTS?
                            R.drawable.ic_tab_selected_contacts:R.drawable.ic_tab_unselected_contacts);
                    break;
                case R.id.tab_menu_dialer:
                    item.setIcon(currentTab == TAB_INDEX_DIALER?
                            R.drawable.ic_tab_selected_dialer:R.drawable.ic_tab_unselected_dialer);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getGroupId() == R.id.tab_group){
            switch(item.getItemId()){
                case R.id.tab_menu_recent:
                    getTabHost().setCurrentTab(TAB_INDEX_RECENT);
                    break;
                case R.id.tab_menu_contacts:
                    getTabHost().setCurrentTab(TAB_INDEX_CONTACTS);
                    break;
                case R.id.tab_menu_dialer:
                    getTabHost().setCurrentTab(TAB_INDEX_DIALER);
                    break;
                default:
                    break;
            }
            invalidateOptionsMenu();
        }
        return super.onOptionsItemSelected(item);
    }
}
