package com.example.administrator.smb;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2014/11/20.
 */
public class ActionMenuItem extends Activity {

    private static final int SETTING_ID = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(hasSmartBar()){
            getWindow().setUiOptions(ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW);
        }else{
            getWindow().setUiOptions(0);//不设置sb
        }
        getActionBar().setTitle("hasSmartBar?");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(0, SETTING_ID, 0, "set");
        item.setIcon(R.drawable.mz_ic_sb_back);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    private boolean hasSmartBar(){
        try{
            Method method = Class.forName("android.os.Build").getMethod("hasSmartBar");//魅族修改了Build在里面添加了hasSmartBar这个函数
            return ((Boolean)method.invoke(null)).booleanValue();
        }catch(Exception e){
        }
        return false;
    }
}
