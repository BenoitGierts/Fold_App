package com.foldapp.hcattiaux.foldapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foldapp.hcattiaux.foldapp.R;

public class tab5Autres extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = layoutInflater.inflate(R.layout.tab5_autres,container,false);
        return rootView;

    }

    public static tab5Autres newInstance() {
        return new tab5Autres();
    }

}
