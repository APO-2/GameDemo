package com.example.gamedemo.screens;

import com.example.gamedemo.model.Avatar;
import com.example.gamedemo.model.Box;
import com.example.gamedemo.model.Bullet;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ScreeA extends BaseScreen{

    private Avatar avatar;

    private ArrayList<Box> boxes;

    private ArrayList<Bullet> bullets;

    public ScreeA(Canvas canvas) {
        super(canvas);
        avatar = new Avatar(canvas);
    }

    @Override
    public void paint() {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        avatar.paint();

    }

    @Override
    public void onKeyPressed(KeyEvent event) {
        avatar.onKeyPressed(event);
    }

    @Override
    public void onKeyReleased(KeyEvent event) {
        avatar.onKeyReleased(event);
    }
}
