package com.example.shaoo.assignment2.UI;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.TextView;

import com.example.shaoo.assignment2.GameEngine.GameEngineMain;
import com.example.shaoo.assignment2.MainGame;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shaoo on 15-Oct-16.
 */

public class GameBoard {
    private final int size = 3;
    private int width;
    private int height;

    private Cell [] cells;

    private Boolean gameWon;
    private GameEngineMain engine;

    public GameBoard(){
        engine =  new GameEngineMain();
        cells = new Cell[engine.getCompleteSize()];
        this.init();

    }
    private int getCompleteSize() {
        return engine.getCompleteSize();
    }

    public void setDimensions(int w,int h){
        width = w;
        height = h;

        for(int i=0; i < getCompleteSize(); i++){
            cells[i].setDimensions(getCellWidth(), getCellHeight());
        }
    }

    private void init()
    {
        int count = 0;
        Boolean [] checkArray = new Boolean[10];
        Arrays.fill(checkArray, false);

        Random random = new Random();

        while(count < 9)
        {
            int cell = random.nextInt(10);

            if(!checkArray[cell])
            {
                if(count == 0)
                {
                    checkArray[cell] = true;
                }
                else {
                    cells[cell].changeState(count);
                    checkArray[cell] = true;
                    count ++;
                }
            }
        }

    }

    private int getCellWidth(){
        return width / size;
    }

    private int getCellHeight(){
        return height / size;
    }

    public void draw(Canvas canvas)
    {

        for(int i=0;i<engine.getCompleteSize();i++)
        {
            cells[i].draw(canvas);
        }
    }
}
