package com.example.administrator.smb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content);
    }
    public void onClick(View v) {
        Intent intent = new Intent();
        switch(v.getId()){
            case R.id.btn_has_smartbar:
                intent.setClass(this, ActionMenuItem.class);
                break;
            case R.id.btn_action_bar_style:
                intent.setClass(this, ActionBarStyle.class);
                break;
            case R.id.btn_custom_back:
                intent.setClass(this, CustomBackButton.class);
                break;
            case R.id.btn_action_bar_top:
                intent.setClass(this, ActionBarTop.class);
                break;
            case R.id.btn_action_mode_top:
                intent.setClass(this, ActionModeTop.class);
                break;
            case R.id.btn_action_item:
                intent.setClass(this, ActionBarList.class);
                break;
            case R.id.btn_tabs:
                intent.setClass(this, Tabs.class);
                break;
            case R.id.btn_customtab_on_top:
                intent.setClass(this, ActionBarCustomTabOnTop.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
