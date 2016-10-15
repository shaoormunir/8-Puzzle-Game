package com.example.shaoo.assignment2.UI;

import android.graphics.Canvas;

/**
 * Created by shaoo on 15-Oct-16.
 */

public class Cell {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean empty;
    private CellState state;

    public Cell(int x, int y, Boolean isEmpty) {
        this.x = x;
        this.y = y;
        this.empty = true;

        state = new CellState();
        empty = true;
    }

    public void draw(Canvas canvas) {
        state.draw(canvas, x, y, width, height);
    }

    public void setDimensions(int width, int height) {

        this.height = height;
        this.width = width;

    }

    public void changeState(int number) {
        state = new CellFilledState(number);
    }

    public int returnNumber()
    {
        if(!empty)
        {
            return ((CellFilledState) state).getNumber();
        }
        else
            return 0;
    }
}
