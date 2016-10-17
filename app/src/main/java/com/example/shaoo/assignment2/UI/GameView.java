package com.example.shaoo.assignment2.UI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaoo.assignment2.MainGame;
import com.example.shaoo.assignment2.R;

/**
 * Created by Shaoor Munir on 15-Oct-16.
 */

public class GameView extends View {

    int moves;
    private GameViewActionListener listener;
    GameBoard board;
    Context context;

    public GameView(Context context, GameViewActionListener listener) {
        super(context);
        this.moves = 0;
        this.listener = listener;
        String text = "Tap a movable box to start the game. ";
        listener.showMessage(text);
        board = new GameBoard(context);
    }

    public GameView(Context context, AttributeSet attrs, GameViewActionListener listener) {
        super(context, attrs);

        String text = "Tap a movable box to start the game.";
        listener.showMessage(text);
        this.context = context;
        this.listener = listener;
        this.moves = 0;
        board = new GameBoard(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Toast.makeText(, "In the draw function of Gameview.", Toast.LENGTH_SHORT).show();

        board.setDimensions(this.getWidth(), this.getHeight());
        board.draw(canvas);

    }

    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                moveBox(x, y);
                break;
            default:
                return false;
        }


        return true;
    }

    private void moveBox(float x, float y) {
        if (board.updateBoard(x, y))
        {
            this.moves++;
            String text = "Moves: " + String.valueOf(this.moves);
            listener.showMessage(text);
            check_game_over();

        }
        this.invalidate();
    }

    public void check_game_over()
    {
        if(board.check_game_state())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Congratulations! You won the game in "+ String.valueOf(this.moves) + " moves")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            listener.showMessage("create_new_game");
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
    public interface GameViewActionListener {
        void showMessage(String message);
    }
}

