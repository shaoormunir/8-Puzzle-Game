package com.example.shaoo.assignment2.UI;

import android.graphics.Canvas;

/**
 * Created by shaoo on 15-Oct-16.
 */

public class CellFilledState extends CellState {
    int number;

    public CellFilledState(int number) {
        this.number = number;
    }

    public void draw(Canvas canvas, int x, int y, int width, int height){
        super.draw(canvas, x, y, width, height);

        paint.setStrokeWidth(2);

        paint.setTextSize(25);

        canvas.drawText(String.valueOf(number), x*width + width/2, y*height + height/2, paint);
    }

    public int getNumber()
    {
        return this.number;
    }
}
