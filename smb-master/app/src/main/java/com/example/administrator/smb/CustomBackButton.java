package com.example.administrator.smb;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Administrator on 2014/11/20.
 */
public class CustomBackButton extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar bar = getActionBar();

        SmartBarUtils.setBackIcon(bar, getResources().getDrawable(R.drawable.ic_back));
    }
}
