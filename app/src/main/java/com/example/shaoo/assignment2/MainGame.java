package com.example.shaoo.assignment2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaoo.assignment2.UI.*;

import java.util.Objects;

import static android.R.attr.path;

public class MainGame extends AppCompatActivity {

    GameView.GameViewActionListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        createListener();
        drawBoard();
    }

    private void createListener() {
        listener = new GameView.GameViewActionListener() {
            @Override
            public void showMessage(String message) {
                setMessage(message);
            }
        };
    }

    private void drawBoard() {
        ViewGroup view = (ViewGroup) findViewById(R.id.game);


        View gameView = new GameView(this, null, listener);
        view.addView(gameView);
    }

    public void setMessage(String message) {
        if (Objects.equals(message, "create_new_game")) {
            newGame(null);
            return;
        }
        TextView view = (TextView) findViewById(R.id.moves);
        view.setText(message);
    }

    public void newGame(View view) {

        if (view != null) {

            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            ViewGroup n_view = (ViewGroup) findViewById(R.id.game);


                            View gameView = new GameView(MainGame.this, null, listener);
                            n_view.addView(gameView);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure that you want to start a new game? You will lose your current progress").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();

        } else {
            ViewGroup n_view = (ViewGroup) findViewById(R.id.game);


            View gameView = new GameView(this, null, listener);
            n_view.addView(gameView);
        }
    }
}

