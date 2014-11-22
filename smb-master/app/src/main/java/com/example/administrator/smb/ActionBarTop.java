package com.example.administrator.smb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by Administrator on 2014/11/20.
 */
public class ActionBarTop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        CheckBox cb = new CheckBox(this);
        cb.setText("set actionbar top collspsable");
        cb.setGravity(Gravity.CENTER);
        setContentView(cb);

        SmartBarUtils.setActionBarViewCollapsable(getActionBar(), true);
        cb.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            //getActionBar().setDisplayOptions(0);
                            SmartBarUtils.setActionBarViewCollapsable(getActionBar(), false);
                        } else {
                           // getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
                            SmartBarUtils.setActionBarViewCollapsable(getActionBar(), true);
                        }
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void onSort(MenuItem item) {
    }
}
