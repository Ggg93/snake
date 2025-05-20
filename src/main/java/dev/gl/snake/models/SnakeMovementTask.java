package dev.gl.snake.models;

import dev.gl.snake.controllers.SnakeController;
import dev.gl.snake.enums.MovementDirection;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gl
 */
public class SnakeMovementTask implements Runnable {

    private SnakeController snakeController;
    private int speed;
    private MovementDirection nextDirection;

    public SnakeMovementTask(SnakeController snakeController, int initialSpeed) {
        this.snakeController = snakeController;
        this.speed = initialSpeed;
    }
    
    public void setNewDirection(MovementDirection nextDirection) {
        this.nextDirection = nextDirection;
    }
    
    public void stop() {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // moving
                snakeController.moveSnakeOnBoard(nextDirection);
                nextDirection = null;
                // sleeps before next step
                TimeUnit.MILLISECONDS.sleep(speed);
            }
        } catch (Exception ignored) {
            System.out.println("Task interrupted.");
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}
