package com.foldapp.hcattiaux.foldapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foldapp.hcattiaux.foldapp.R;

public class tab1Donnees extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = layoutInflater.inflate(R.layout.tab1_carac,container,false);
        return rootView;
    }

    public static tab1Donnees newInstance() {
        return new tab1Donnees();
    }

}
