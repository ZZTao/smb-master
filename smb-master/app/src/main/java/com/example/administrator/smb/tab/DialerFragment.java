package com.example.administrator.smb.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.smb.R;

/**
 * Created by Administrator on 2014/11/21.
 */
public class DialerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.text_content, container, false);
        TextView text = (TextView)fragmentView.findViewById(android.R.id.text1);
        text.setText("Dialer");
        return fragmentView;
    }
}
