package com.bradleyperkins.digginggame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.bradleyperkins.digginggame.objects.GameData;
import com.bradleyperkins.digginggame.InventoryStorage;
import com.bradleyperkins.digginggame.R;
import com.bradleyperkins.digginggame.fragments.GameFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ArrayList<GameData> gameDataList;
    private ArrayList<GameData> inventoryItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Clears out Inventory on Start of New Game
        gameDataList = new ArrayList<>();
        inventoryItemsList = InventoryStorage.loadInventory(this);
        inventoryItemsList.clear();
        InventoryStorage.saveInventory(this, inventoryItemsList);
        inventoryItemsList = InventoryStorage.loadInventory(this);

        try {
            readGameData(gameDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(savedInstanceState == null) {
            GameFragment fragment = GameFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.game_fragment_container, fragment, GameFragment.TAG)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inventory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_add) {
            Intent myIntent = new Intent(this, InventoryActivity.class);
            startActivity(myIntent);
        }

        return true;
    }


    private void readGameData(ArrayList<GameData> gameDataList) throws IOException {
        //get screen dims
        //create random x, and random y
        //assign x and y to arraylist item
        Random random = new Random();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        InputStream is = getResources().openRawResource(R.raw.items);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line;
        while ((line = reader.readLine()) != null){
            //Random x, y positions within screen
            int yPos = random.nextInt(height + 1);
            int xPos = random.nextInt(width + 1);

            String [] data = line.split(",");
            GameData gameData = new GameData(data[0], Integer.parseInt(data[1]), xPos, yPos);

            gameDataList.add(gameData);
        }
    }

}
