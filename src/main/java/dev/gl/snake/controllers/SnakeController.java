package dev.gl.snake.controllers;

import dev.gl.snake.enums.MovementDirection;
import dev.gl.snake.models.SnakeModel;
import dev.gl.snake.models.SnakeMovementTask;
import dev.gl.snake.utils.BoardPosition;
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
    private SnakeMovementTask movementProcess;
    private Integer initialSnakeLength;
    
    private BoardController boardController;
    private ScoreController scoreController;

    public SnakeController(Integer initialSnakeLength) {
        this.initialSnakeLength = initialSnakeLength;
    }
    
    public void createNewSnake() {
        snakeModel = new SnakeModel(initialSnakeLength, boardController.getMiddleOfBoard());
        boardController.placeNewSnakeOnBoard(snakeModel.getLocation());
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
    
    public void startMovement() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        movementProcess = new SnakeMovementTask(this, 
                scoreController.getCurrentLevel().getSpeed());
        service.execute(movementProcess);
    }

    public BoardPosition pullUpTail() {
        BoardPosition tail = snakeModel.getLocation().removeLast();
        return tail;
    }

    public void makeNextStep(BoardPosition head) {
        snakeModel.getLocation().addFirst(head);
    }
    
    public void increaseSnakesSpeed(Integer speed) {
        movementProcess.setSpeed(speed);
    }
    
    public void moveSnakeOnBoard() {
        boardController.moveSnake();
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }
    
}
