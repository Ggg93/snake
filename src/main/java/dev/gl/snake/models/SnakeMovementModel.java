package dev.gl.snake.models;

import dev.gl.snake.controllers.ScoreController;
import dev.gl.snake.controllers.SnakeController;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gl
 */
public class SnakeMovementModel implements Runnable {

    private ScoreController scoreController;
    private SnakeController snakeController;

    public SnakeMovementModel(ScoreController scoreController, SnakeController snakeController) {
        this.scoreController = scoreController;
        this.snakeController = snakeController;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // moving
                snakeController.move();
                // sleeps before next step
                TimeUnit.MILLISECONDS.sleep(scoreController.getCurrentLevel().getSpeed());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

}
