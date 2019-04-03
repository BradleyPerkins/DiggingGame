package com.bradleyperkins.digginggame.objects;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// HoleData.Java

import android.graphics.Bitmap;
import android.graphics.Paint;

public class HoleData {

    private Bitmap hole;
    private int xPos;
    private int yPos;
    private Paint holeBlank;

    public HoleData(Bitmap hole, int xPos, int yPos, Paint holeBlank) {
        this.hole = hole;
        this.xPos = xPos;
        this.yPos = yPos;
        this.holeBlank = holeBlank;
    }


    public Bitmap getHole() {
        return hole;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Paint getHoleBlank() {
        return holeBlank;
    }
}
