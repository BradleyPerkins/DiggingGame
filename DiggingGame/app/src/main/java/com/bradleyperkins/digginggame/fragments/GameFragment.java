package com.bradleyperkins.digginggame.fragments;


// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// GameFragment.Java

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bradleyperkins.digginggame.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    public static final String TAG = "GameFragment.TAG";

    public GameFragment() {
    }

    public static GameFragment newInstance() {
        GameFragment fragment = new GameFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
