package com.example.administrator.smb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/11/22.
 */
public class DialerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        TextView text = (TextView)findViewById(android.R.id.text1);
        text.setText("Dialer");
    }

    @Override
    protected void onResume() {
        getParent().getActionBar().setTitle("Dialer title");
        super.onResume();
    }
}
