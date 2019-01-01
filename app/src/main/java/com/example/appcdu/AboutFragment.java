package com.example.appcdu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kockr on 3-5-2015.
 */
public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = super.onCreateView(inflater, container, savedInstanceState);
        View view =  inflater.inflate(R.layout.about, container, false);
        view.setBackgroundColor(getResources().getColor(android.R.color.white));
        ((TextView) view.findViewById(R.id.clientid)).setText("The PSX client id used for this session:" + MainActivity.id);
        ((TextView) view.findViewById(R.id.version)).setText("The PSX version this client connnects to:" + MainActivity.version);
        return view;
    }
}
