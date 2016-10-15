package com.example.shaoo.assignment2.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.shaoo.assignment2.MainGame;

/**
 * Created by shaoo on 15-Oct-16.
 */

public class GameView extends View {

    boolean isOver;
    private GameViewActionListener listener;
    GameBoard board;

    public GameView(Context context, GameViewActionListener listener) {
        super(context);
        this.listener = listener;
        board = new GameBoard();
    }

    public GameView(Context context, AttributeSet attrs, GameViewActionListener listener) {
        super(context, attrs);
        this.listener = listener;
        board = new GameBoard();

    }

    @Override
    protected void onDraw(Canvas canvas) {
       // Toast.makeText(, "In the draw function of Gameview.", Toast.LENGTH_SHORT).show();

        board.setDimensions(this.getWidth(), this.getHeight());
        board.draw(canvas);

    }

    public interface GameViewActionListener {
        public void showMessage (String message);
    }
}

