package dev.gl.snake.controllers;

import dev.gl.snake.views.MainWindow;

/**
 *
 * @author gl
 */
public class NewGameController {
    private final BoardController boardController;
    private final SnakeController snakeController;
    private final ScoreController scoreController;

    public NewGameController(int squareSideLength, Integer initialSnakeLength, int applesRequiredToNextLevel) {
        this.boardController = new BoardController(squareSideLength);
        this.snakeController = new SnakeController(initialSnakeLength);
        this.scoreController = new ScoreController(applesRequiredToNextLevel);
        
        scoreController.setSnakeController(snakeController);
        boardController.setSnakeController(snakeController);
        boardController.setScoreController(scoreController);
        snakeController.setBoardController(boardController);
        snakeController.setScoreController(scoreController);
    }
    
    public void linkMainWindowToControllers(MainWindow mw) {
        scoreController.setMainWindow(mw);
        boardController.setMainWindow(mw);
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public SnakeController getSnakeController() {
        return snakeController;
    }

    public ScoreController getScoreController() {
        return scoreController;
    }
    
}
