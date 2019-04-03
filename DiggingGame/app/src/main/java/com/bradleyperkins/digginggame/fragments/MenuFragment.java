package com.bradleyperkins.digginggame.fragments;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// MenuFragment.Java

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bradleyperkins.digginggame.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public static final String TAG = "MenuFragment.TAG";

    public MenuFragment() {
    }

    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    private StartGameListener mListener;

    public interface StartGameListener {
        void startGame();
        void viewCredits();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button startBtn = getView().findViewById(R.id.play_btn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener == null){
                    return;
                }
                mListener.startGame();
            }
        });

        Button creditBtn = getView().findViewById(R.id.credits_btn);
        creditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener == null){
                    return;
                }
                mListener.viewCredits();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StartGameListener){
            mListener = (StartGameListener) context;
        }
    }
}
