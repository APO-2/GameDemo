package com.example.gamedemo.model;

import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Avatar {

    private Canvas canvas;
    private GraphicsContext graphicsContext;

    private double posX;
    private double posY;

    private ArrayList<Image> idleImages;
    private ArrayList<Image> runImages;
    private ArrayList<Image> attackImages;

    private int state;
    private int frame;

    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean isAttacking;

    public Avatar(Canvas canvas){
        this.state = 0;
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.posX = 100;
        this.posY = 100;

        idleImages = new ArrayList<>();
        runImages = new ArrayList<>();
        attackImages = new ArrayList<>();

        for(int i = 0; i <= 3; i++){
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/idle/adventurer-idle-2-0"+i+".png"));
            idleImages.add(image);
        }

        for(int i = 0; i <= 5; i++){
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/run/adventurer-run-0"+i+".png"));
            runImages.add(image);
        }

        for(int i = 0; i <= 4; i++){
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/attack/adventurer-attack1-0"+i+".png"));
            attackImages.add(image);
        }
    }

    public void paint(){
        onMove();
        if (state == 0){
            graphicsContext.drawImage(idleImages.get(frame%3), posX, posY);
            frame++;
        }
        else if(state == 1) {
            graphicsContext.drawImage(runImages.get(frame%5), posX, posY);
            frame++;
        }
        else if (state == 2) {
            graphicsContext.drawImage(attackImages.get(frame%4), posX, posY);
            frame++;
        }
    }

    public void onKeyPressed(KeyEvent event){
        state = 1;
        switch (event.getCode()){
            case W:
                upPressed = true;
                break;
            case S:
                downPressed = true;
                break;
            case D:
                rightPressed = true;
                break;
            case A:
                leftPressed = true;
                break;
        }
    }

    public void onKeyReleased(KeyEvent event){
        state = 0;
        switch (event.getCode()){
            case W:
                upPressed = false;
                break;
            case S:
                downPressed = false;
                break;
            case D:
                rightPressed = false;
                break;
            case A:
                leftPressed = false;
                break;
        }
    }

    public void onMove(){
        if (upPressed){
            posY -= 10;
        }
        if (downPressed){
            posY += 10;
        }
        if (leftPressed){
            posX -= 10;
        }
        if (rightPressed){
            posX += 10;
        }
    }
}
