package com.bradleyperkins.digginggame;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// InventoryStorage.Java

import android.content.Context;

import com.bradleyperkins.digginggame.objects.GameData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// PerkinsBradley_CE
public class InventoryStorage {

    private static final String FILE_NAME = "inventory.dat";

    public static void saveItem(Context _context, GameData _item) {
        ArrayList<GameData> people = loadInventory(_context);
        people.add(_item);
        saveInventory(_context, people);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    public static void deletePerson(Context _context, GameData _item) {
        ArrayList<GameData> people = loadInventory(_context);
        while(people.remove(_item));
        saveInventory(_context, people);
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<GameData> loadInventory(Context _context) {
        ArrayList<GameData> items = null;

        try {
            FileInputStream fis = _context.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            items = (ArrayList<GameData>)ois.readObject();
            ois.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(items == null) {
            items = new ArrayList<>();
        }

        return items;
    }

    public static void saveInventory(Context _context, ArrayList<GameData> _items) {
        try {
            FileOutputStream fos = _context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(_items);
            oos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



}
