package com.example.administrator.smb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Administrator on 2014/11/22.
 */
public class ContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.text_content_contacts);
        EditText text = (EditText)findViewById(android.R.id.text1);
        text.setText("Contacts1");
    }

    @Override
    protected void onResume() {
        getParent().getActionBar().setTitle("Contacts title");
        super.onResume();
    }
}
