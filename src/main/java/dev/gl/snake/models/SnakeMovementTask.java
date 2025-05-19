package dev.gl.snake.models;

import dev.gl.snake.controllers.SnakeController;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gl
 */
public class SnakeMovementTask implements Runnable {

    private SnakeController snakeController;
    private int speed;

    public SnakeMovementTask(SnakeController snakeController, int initialSpeed) {
        this.snakeController = snakeController;
        this.speed = initialSpeed;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // moving
                snakeController.moveSnakeOnBoard();
                // sleeps before next step
                TimeUnit.MILLISECONDS.sleep(speed);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}
