package com.bradleyperkins.digginggame.activities;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// InventoryActivity.Java

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bradleyperkins.digginggame.R;
import com.bradleyperkins.digginggame.fragments.InventoryFragment;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);



        if(savedInstanceState == null) {
            InventoryFragment fragment = InventoryFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.inventory_fragment_container, fragment, InventoryFragment.TAG)
                    .commit();
        }

    }

}
