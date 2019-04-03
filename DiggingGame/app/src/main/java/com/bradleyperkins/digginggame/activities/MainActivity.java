package com.bradleyperkins.digginggame.activities;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// MainActivity.Java

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bradleyperkins.digginggame.fragments.MenuFragment;
import com.bradleyperkins.digginggame.R;

public class MainActivity extends AppCompatActivity implements MenuFragment.StartGameListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            MenuFragment frag = new MenuFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, frag, MenuFragment.TAG)
                    .commit();
        }

    }

    @Override
    public void startGame() {
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void viewCredits() {
        Intent myIntent = new Intent(this, CreditsActivity.class);
        startActivity(myIntent);
    }
}
