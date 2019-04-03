package com.bradleyperkins.digginggame.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bradleyperkins.digginggame.R;
import com.bradleyperkins.digginggame.fragments.CreditsFragment;
import com.bradleyperkins.digginggame.fragments.MenuFragment;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        if(savedInstanceState == null) {
            CreditsFragment frag = new CreditsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.credits_fragment_container, frag, MenuFragment.TAG)
                    .commit();
        }


    }
}
