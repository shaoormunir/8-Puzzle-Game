package com.example.shaoo.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaoo.assignment2.UI.*;

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

    private void createListener(){
        listener = new GameView.GameViewActionListener() {
            @Override
            public void showMessage(String message) {
                setMessage(message);
            }
        };
    }

    private void drawBoard(){
        ViewGroup view = (ViewGroup) findViewById(R.id.game);

        Toast.makeText(MainGame.this, "Drawing the board.", Toast.LENGTH_SHORT).show();

        View gameView = new GameView(this,null,listener);
        view.addView(gameView);
    }

    public void setMessage(String message){
        TextView view = (TextView) findViewById(R.id.message);
        view.setText(Html.fromHtml(message));
    }
}

