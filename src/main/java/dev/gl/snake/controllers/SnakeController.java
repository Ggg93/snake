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
    
    public MovementDirection getDirection() {
        return snakeModel.getDirection();
    }
    
    public void startMovement(ScoreController scoreController, BoardController boardController) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new SnakeMovementModel(scoreController, boardController));
        System.out.println("Snake started!");
    }

    public BoardPosition pullUpTail() {
        BoardPosition tail = snakeModel.getLocation().removeLast();
        return tail;
    }

    public void makeNextStep(BoardPosition head) {
        snakeModel.getLocation().addFirst(head);
    }

}
