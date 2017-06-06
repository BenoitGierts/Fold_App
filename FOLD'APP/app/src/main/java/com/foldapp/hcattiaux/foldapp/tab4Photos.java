package com.foldapp.hcattiaux.foldapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.foldapp.hcattiaux.foldapp.R;

public class tab4Photos extends Fragment {

    private boolean zoomOut =  false;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = layoutInflater.inflate(R.layout.tab4_photos,container,false);
        return rootView;

    }

    public static tab4Photos newInstance() {
        return new tab4Photos();
    }

}
