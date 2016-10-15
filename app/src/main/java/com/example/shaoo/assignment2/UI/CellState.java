package com.example.shaoo.assignment2.UI;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by shaoo on 15-Oct-16.
 */

public class CellState {

    protected Paint paint;

    public CellState() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

    }

    public void draw(Canvas canvas, int x, int y, int width, int height){
        Rect rect = new Rect(x*width,y*height,((x+1)*width - 1),((y+1)*height - 1));
        canvas.drawRect(rect, paint);
    }
}
