package com.example.administrator.smb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.smb.tab.ActionBarTab;
import com.example.administrator.smb.tab.ActionBarTabAndTabHost;
import com.example.administrator.smb.tab.ActionItemTab;

/**
 * Created by Administrator on 2014/11/22.
 */
public class Tabs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tabs_layout);

        getActionBar().setTitle("SmartBar Tab");
    }

    public void onClick(View v){
        Intent intent = new Intent();
        switch(v.getId()){
            case R.id.btn_action_item_tab:
                intent.setClass(this, ActionItemTab.class);
                break;
            case R.id.btn_action_bar_tab:
                intent.setClass(this, ActionBarTab.class);
                break;
            case R.id.btn_action_bar_tab_and_tabhost:
                intent.setClass(this, ActionBarTabAndTabHost.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
