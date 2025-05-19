package dev.gl.snake.controllers;

import dev.gl.snake.enums.MovementDirection;
import dev.gl.snake.models.SnakeModel;
import dev.gl.snake.models.SnakeMovementModel;
import dev.gl.snake.views.BoardPosition;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author gl
 */
public class SnakeController {
    private SnakeModel snakeModel;
    
    public void initSnakeModel(int initialLength, BoardPosition startPosition) {
        snakeModel = new SnakeModel(initialLength, startPosition);
    }
    
    public List<BoardPosition> getSnakePosition() {
        return snakeModel.getLocation();
    }
    
    public Set<BoardPosition> getOccupiedCells() {
        return new HashSet<>(snakeModel.getLocation());
    }
    
    public void changeSnakeDirection(MovementDirection direction) {
        System.out.println("new direction: " + direction);
        snakeModel.setDirection(direction);
    }
    
    public void startMovement(ScoreController scoreController) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new SnakeMovementModel(scoreController, this));
        System.out.println("Snake started!");
    }

    public void move() {
        System.out.println("Move!");
    }
    
}
