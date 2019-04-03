package com.bradleyperkins.digginggame.objects;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// GameData.Java


import java.io.Serializable;

public class GameData  implements Serializable {

    private String name;
    private int value;
    private int xPos;
    private int yPos;

    public GameData(String name, int value, int xPos, int yPos) {
        this.name = name;
        this.value = value;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }


}
