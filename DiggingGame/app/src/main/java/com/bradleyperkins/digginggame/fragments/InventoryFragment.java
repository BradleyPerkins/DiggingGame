package com.bradleyperkins.digginggame.fragments;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// InventoryFragment.Java

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bradleyperkins.digginggame.objects.GameData;
import com.bradleyperkins.digginggame.InventoryStorage;
import com.bradleyperkins.digginggame.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {

    public static final String TAG = "InventoryFragment.TAG";

    private ArrayList<GameData> inventoryItemsList;

    //items with multiple
    private int gold = 0;
    private int potion = 0;
    private int hiPotion = 0;
    private int xPotion = 0;
    private int ether = 0;
    private int hiEther = 0;

    //items with a single value
    private TextView goldTV, potionTV, hiPotionTV, xPotionTV, etherTV, hiEtherTV, elixarTV, ribbonTV, chantageTV, ontachi,
    rustySwordTV, masamuneTV, excaliburTV, goujianTV, unnamedTV, swordOfMercyTV, tizonaTV, busterSwordTV, leatherGlovesTV,
    leatherHelmTV, leatherBootsTV, leatherBodyTV, steelGlovesTV, steelHelmTV, steelBootsTV, steelBodyTV, genjiGlovesTV,
    genjiHelmTV, genjiBootsTV, genjiBodyTV, yueGloveTV, yueHelmTV, yueBootsTV, yueBodyTV, holyGlovesTV, holyHelmTV, holyBootsTV,
    holyBodyTV, rubberBootsTV, featherBootsTV, hermesSandelsTV, protectRingTV, shellRingTV, diamondRingTV, empyrealRingTV,
    reraiseRingTV, silenceRingTV, capeTV, leatherCloakTV, elvenCloakTV, invisCloakTV, undeadCloackTV;


    public InventoryFragment() {
        // Required empty public constructor
    }

    public static InventoryFragment newInstance() {

        InventoryFragment fragment = new InventoryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Load Inventory
        inventoryItemsList = InventoryStorage.loadInventory(getContext());

        //Check Inventory Data
        checkData();

        //Setup TextViews Resources
        setUpTextViews();

        //Set Text for all TextViews
        setTextForTextViews();
    }

    //Method for Setting Text
    @SuppressLint("SetTextI18n")
    private void setTextForTextViews() {
        //goldTV, potionTV, hiPotionTV, xPotionTV, etherTV, hiEtherTV,
        goldTV.setText("Gold - " + gold);
        potionTV.setText("Potion - " + potion);
        hiPotionTV.setText("Hi-Potion - " + hiPotion);
        xPotionTV.setText("X-Potion - " + xPotion);
        etherTV.setText("Ether - " + ether);
        hiEtherTV.setText("Hi-Ether - " + hiEther);

        //All other textViews
        for (int i=0; i<inventoryItemsList.size(); i++) {
            String item = inventoryItemsList.get(i).getName().trim();

            if (!item.equals("Gold") && !item.equals("Potion") && !item.equals("Hi-Potion")
                    && !item.equals("X-Potion") && !item.equals("Ether") && !item.equals("Hi-Ether")) {

                Log.d(TAG, "ELSE: " + inventoryItemsList.get(i).getName());
                switch (item){
                    case "Elixar":
                        elixarTV.setText("Elixar - " + 1);
                        break;
                    case "Ribbon":
                        ribbonTV.setText("Ribbon - " + 1);
                        break;
                    case "Chantage":
                        chantageTV.setText("Chantage - " + 1);
                        break;
                    case "Ontachi":
                        ontachi.setText("Ontachi - " + 1);
                        break;
                    case "Rusty Sword":
                        rustySwordTV.setText("Rusty Sword - " + 1);
                        break;
                    case "Masamune":
                        masamuneTV.setText("Masamune - " + 1);
                        break;
                    case "Excalibur":
                        excaliburTV.setText("Excalibur - " + 1);
                        break;
                    case "Goujian":
                        goujianTV.setText("Goujian - " + 1);
                        break;
                    case "Unnamed":
                        unnamedTV.setText("Unnamed - " + 1);
                        break;
                    case "Sword of Mercy":
                        swordOfMercyTV.setText("Sword of Mercy - " + 1);
                        break;
                    case "Tizona":
                        tizonaTV.setText("Tizona - " + 1);
                        break;
                    case "Buster Sword":
                        busterSwordTV.setText("Buster Sword - " + 1);
                        break;
                    case "Leather Gloves":
                        leatherGlovesTV.setText("Leather Gloves - " + 1);
                        break;
                    case "Leather Helm":
                        leatherHelmTV.setText("Leather Helm - " + 1);
                        break;
                    case "Leather Boots":
                        leatherBootsTV.setText("Leather Boots - " + 1);
                        break;
                    case "Leather Body":
                        leatherBodyTV.setText("Leather Body - " + 1);
                        break;
                    case "Steel Gloves":
                        steelGlovesTV.setText("Steel Gloves - " + 1);
                        break;
                    case "Steel Helm":
                        steelHelmTV.setText("Steel Helm - " + 1);
                        break;
                    case "Steel Boots":
                        steelBootsTV.setText("Steel Boots - " + 1);
                        break;
                    case "Steel Body":
                        steelBodyTV.setText("Steel Body - " + 1);
                        break;
                    case "Genji Gloves":
                        genjiGlovesTV.setText("Genji Gloves - " + 1);
                        break;
                    case "Genji Helm":
                        genjiHelmTV.setText("Genji Helm - " + 1);
                        break;
                    case "Genji Boots":
                        genjiBootsTV.setText("Genji Boots - " + 1);
                        break;
                    case "Genji Body":
                        genjiBodyTV.setText("Genji Body - " + 1);
                        break;
                    case "Yue Gloves":
                        yueGloveTV.setText("Yue Gloves - " + 1);
                        break;
                    case "Yue Helm":
                        yueHelmTV.setText("Yue Helm - " + 1);
                        break;
                    case "Yue Boots":
                        yueBootsTV.setText("Yue Boots - " + 1);
                        break;
                    case "Yue Body":
                        yueBodyTV.setText("Yue Body - " + 1);
                        break;
                    case "Holy Gloves":
                        holyGlovesTV.setText("Holy Gloves - " + 1);
                        break;
                    case "Holy Helm":
                        holyHelmTV.setText("Holy Helm - " + 1);
                        break;
                    case "Holy Boots":
                        holyBootsTV.setText("Holy Boots - " + 1);
                        break;
                    case "Holy Body":
                        holyBodyTV.setText("Holy Body - " + 1);
                        break;
                    case "Rubber Boots":
                        rubberBootsTV.setText("Rubber Boots - " + 1);
                        break;
                    case "Feather Boots":
                        featherBootsTV.setText("Feather Boots - " + 1);
                        break;
                    case "Hermes Sandals":
                        hermesSandelsTV.setText("Hermes Sandals - " + 1);
                        break;
                    case "Protect Ring":
                        protectRingTV.setText("Protect Ring - " + 1);
                        break;
                    case "Shell Ring":
                        shellRingTV.setText("Shell Ring - " + 1);
                        break;
                    case "Diamond Ring":
                        diamondRingTV.setText("Diamond Ring - " + 1);
                        break;
                    case "Empyreal Ring":
                        empyrealRingTV.setText("Empyreal Ring - " + 1);
                        break;
                    case "Reraise Ring":
                        reraiseRingTV.setText("Reraise Ring - " + 1);
                        break;
                    case "Silence Ring":
                        silenceRingTV.setText("Silence Ring - " + 1);
                        break;
                    case "Cape":
                        capeTV.setText("Cape - " + 1);
                        break;
                    case "Leather Cloak":
                        leatherCloakTV.setText("Leather Cloak - " + 1);
                        break;
                    case "Elven Cloak":
                        elvenCloakTV.setText("Elven Cloak - " + 1);
                        break;
                    case "Invis Cloak":
                        invisCloakTV.setText("Invis Cloak - " + 1);
                        break;
                    case "Undead Cloak":
                        undeadCloackTV.setText("Undead Cloak - " + 1);
                        break;
                }

            }
        }

    }

    //Method for Checking Data, Gold , potions, ect...
    private void checkData(){

        //Pull all the gold
        for (int i=0; i<inventoryItemsList.size(); i++){
            String item = inventoryItemsList.get(i).getName().trim();
            if (item.equals("Gold")){
                gold = gold + inventoryItemsList.get(i).getValue();
            }
            if (item.equals("Potion")){
                //potion = potion + inventoryItemsList.get(i).getValue();
                potion = potion + 1;
            }
            if (item.equals("Hi-Potion")){
                //hiPotion = hiPotion + inventoryItemsList.get(i).getValue();
                hiPotion = hiPotion + 1;
            }
            if (item.equals("X-Potion")){
                //xPotion = xPotion + inventoryItemsList.get(i).getValue();
                xPotion = xPotion + 1;
            }
            if (item.equals("Ether")){
                ether = ether + 1;
            }
            if (item.equals("Hi-Ether")) {
                //hiEther = hiEther + inventoryItemsList.get(i).getValue();
                hiEther = hiEther + 1;
            }
        }

        Log.d(TAG, "Gold____: " + gold);
        Log.d(TAG, "Potion____: " + potion);
        Log.d(TAG, "Hi-Potion____: " + hiPotion);
        Log.d(TAG, "X-Potion____: " + xPotion);
        Log.d(TAG, "Ether____: " + ether);
        Log.d(TAG, "Hi-Ether____: " + hiEther);

    }

    //Method for setting textView res
    private void setUpTextViews() {
        goldTV = getView().findViewById(R.id.gold_tv);
        potionTV = getView().findViewById(R.id.potion_tv);
        hiPotionTV = getView().findViewById(R.id.hi_potion_tv);
        xPotionTV = getView().findViewById(R.id.x_potion_tv);
        etherTV = getView().findViewById(R.id.ether_tv);
        hiEtherTV = getView().findViewById(R.id.hi_ether_tv);
        elixarTV = getView().findViewById(R.id.elixer_tv);
        ribbonTV = getView().findViewById(R.id.ribbon_tv);
        chantageTV = getView().findViewById(R.id.chantage_tv);
        ontachi = getView().findViewById(R.id.ontachi_tv);
        rustySwordTV = getView().findViewById(R.id.rusty_sword_tv);
        masamuneTV = getView().findViewById(R.id.masamune_tv);
        excaliburTV = getView().findViewById(R.id.excalibur_tv);
        goujianTV = getView().findViewById(R.id.goujian_tv);
        unnamedTV = getView().findViewById(R.id.unnamed_tv);
        swordOfMercyTV = getView().findViewById(R.id.sword_of_mercy_tv);
        tizonaTV = getView().findViewById(R.id.tizona_tv);
        busterSwordTV = getView().findViewById(R.id.buster_sword_tv);
        leatherGlovesTV = getView().findViewById(R.id.leather_gloves_tv);
        leatherHelmTV = getView().findViewById(R.id.leather_helm_tv);
        leatherBootsTV = getView().findViewById(R.id.leather_boots_tv);
        leatherBodyTV = getView().findViewById(R.id.leather_body_tv);
        steelGlovesTV = getView().findViewById(R.id.steel_gloves_tv);
        steelHelmTV = getView().findViewById(R.id.steel_helm_tv);
        steelBootsTV = getView().findViewById(R.id.steel_boots_tv);
        steelBodyTV = getView().findViewById(R.id.steel_body_tv);
        genjiGlovesTV = getView().findViewById(R.id.genji_gloves_tv);
        genjiHelmTV = getView().findViewById(R.id.genji_helm_tv);
        genjiBootsTV = getView().findViewById(R.id.genji_boots_tv);
        genjiBodyTV = getView().findViewById(R.id.genji_body_tv);
        yueGloveTV = getView().findViewById(R.id.yue_gloves_tv);
        yueHelmTV = getView().findViewById(R.id.yue_helm_tv);
        yueBootsTV = getView().findViewById(R.id.yue_boots_tv);
        yueBodyTV = getView().findViewById(R.id.yue_body_tv);
        holyGlovesTV = getView().findViewById(R.id.holy_gloves_tv);
        holyHelmTV = getView().findViewById(R.id.holy_helm_tv);
        holyBootsTV = getView().findViewById(R.id.holy_boots_tv);
        holyBodyTV = getView().findViewById(R.id.holy_body_tv);
        rubberBootsTV = getView().findViewById(R.id.rubber_boots_tv);
        featherBootsTV = getView().findViewById(R.id.feather_boots_tv);
        hermesSandelsTV = getView().findViewById(R.id.hermes_sandels_tv);
        protectRingTV = getView().findViewById(R.id.protect_ring_tv);
        shellRingTV = getView().findViewById(R.id.shell_ring_tv);
        diamondRingTV = getView().findViewById(R.id.diamond_ring_tv);
        empyrealRingTV = getView().findViewById(R.id.empyreal_ring_tv);
        reraiseRingTV = getView().findViewById(R.id.reraise_ring_tv);
        silenceRingTV = getView().findViewById(R.id.silence_ring_tv);
        capeTV  = getView().findViewById(R.id.cape_tv);
        leatherCloakTV = getView().findViewById(R.id.leather_cloak_tv);
        elvenCloakTV  = getView().findViewById(R.id.elven_cloak_tv);
        invisCloakTV = getView().findViewById(R.id.invis_cloak_tv);
        undeadCloackTV = getView().findViewById(R.id.undead_cloak_tv);
    }
}

