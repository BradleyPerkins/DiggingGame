package com.bradleyperkins.digginggame;

// Date 11/13/18
// Bradley Perkins
// MDF3 - 1811
// GameSurface.Java

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.bradleyperkins.digginggame.objects.GameData;
import com.bradleyperkins.digginggame.objects.HoleData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

// PerkinsBradley_CE
public class GameSurface  extends SurfaceView implements SurfaceHolder.Callback{

    private ArrayList<GameData> gameDataList;
    private ArrayList<GameData> inventoryItemsList;
    private ArrayList<HoleData> holeLocations;

    private int count = 0;
    private Canvas mCanvas;
    private Bitmap mBackground;
    private Paint mBlankPaint;
    private Paint mBlankHole;

    private Rect mDimensions;
    private Rect mHoleDimensions;

    private Bitmap hole;

    private int screenWidth;
    private int screenHeight;

    private int holeHeight;
    private int holeWidth;


    public GameSurface(Context context) {
        super(context);
    }

    public GameSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameSurface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameSurface(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //////////////////////////////


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        gameDataList = new ArrayList<>();
        inventoryItemsList = new ArrayList<>();
        holeLocations = new ArrayList<>();

        try {
            readGameData(gameDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        count = gameDataList.size();

        setWillNotDraw(false);
        getHolder().addCallback(this);
        mBackground = BitmapFactory.decodeResource(getResources(), R.drawable.field);
        hole = BitmapFactory.decodeResource(getResources(), R.drawable.hole);

        //get hole height and width
        holeHeight = hole.getHeight();
        holeWidth = hole.getWidth();

        mBlankPaint = new Paint();
        mBlankHole = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Background
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(mBackground, null, mDimensions, mBlankPaint);


        //place /update all holes
        if (holeLocations != null){
            for (int i=0; i<holeLocations.size(); i++){
                canvas.drawBitmap(holeLocations.get(i).getHole(), holeLocations.get(i).getxPos() - holeWidth/2,
                        holeLocations.get(i).getyPos() - holeHeight/2, holeLocations.get(i).getHoleBlank());
            }
        }


        //Counter
        @SuppressLint("DrawAllocation") Paint textPaint = new Paint();
        textPaint.setTextSize(48);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.WHITE);
        float centerText = (canvas.getWidth() / 2) - textPaint.getStrokeWidth();

        canvas.drawText("Treasures Found:  " + count, centerText,80, textPaint);

    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas canvas = surfaceHolder.lockCanvas();

        screenHeight = canvas.getHeight();
        screenWidth = canvas.getWidth();

        // Retrieve the dimensions and hold onto them for later.
        mDimensions = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        mHoleDimensions = new Rect(0, 0, holeWidth, holeHeight);

        // Release the canvas and post a draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        touchPos(x, y);

        invalidate();
        return super.onTouchEvent(event);
    }


    //Read and store the data to the ArrayList
    private void readGameData(ArrayList<GameData> gameDataList) throws IOException {

        Random random = new Random();
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        InputStream is = getResources().openRawResource(R.raw.items);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line;
        while ((line = reader.readLine()) != null){
            //Random x, y positions within screen
            int yPos = random.nextInt(height);
            int xPos = random.nextInt(width);

            String [] data = line.split(",");
            GameData gameData = new GameData(data[0], Integer.parseInt(data[1]), xPos, yPos);

            //Add data to arraylist
            gameDataList.add(gameData);
        }

    }

    //Touch method to setup the hole and possible treasure that is taken
    public void touchPos(int posX, int posY) {
        if (gameDataList.size() == 0){
            return;
        }

        HoleData holeData = new HoleData(hole, posX, posY, mBlankHole);
        holeLocations.add(holeData);

        int xMax = posX + 50;
        int xMin = posX - 50;
        int yMax = posY + 50;
        int yMin = posY - 50;

        for (int i = 0; i < gameDataList.size() -1; i++) {
            if (Math.abs(gameDataList.get(i).getxPos()) >= xMin && Math.abs(gameDataList.get(i).getxPos()) <= xMax &&
                    Math.abs(gameDataList.get(i).getyPos()) >= yMin && Math.abs(gameDataList.get(i).getyPos()) <= yMax) {

                //Remove from arrayList
                gameDataList.remove(i);

                //Save file
                InventoryStorage.saveItem(getContext(), gameDataList.get(i));

                //update TextView
                count = gameDataList.size();
                Toast.makeText(getContext(), gameDataList.get(i).getName() + " Found", Toast.LENGTH_SHORT).show();

            }
        }

    }


}
