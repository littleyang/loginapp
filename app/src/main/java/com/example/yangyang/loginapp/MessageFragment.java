package com.example.yangyang.loginapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangyang on 14-9-25.
 */
public class MessageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View messageViewLayout = inflater.inflate(R.layout.messages,container,false);
        return messageViewLayout;
    }
}
