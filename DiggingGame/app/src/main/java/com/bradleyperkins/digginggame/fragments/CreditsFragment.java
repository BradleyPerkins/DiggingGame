package com.bradleyperkins.digginggame.fragments;


// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// CreditsFragment.Java

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bradleyperkins.digginggame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditsFragment extends Fragment {

    public static final String TAG = "CreditFragment.TAG";

    public CreditsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_credits, container, false);
    }

}
