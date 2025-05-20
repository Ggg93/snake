package dev.gl.snake.controllers;

import dev.gl.snake.enums.Levels;
import dev.gl.snake.models.ScoreModel;
import dev.gl.snake.views.MainWindow;

/**
 *
 * @author gl
 */
public class ScoreController {
    
    private final ScoreModel model;
    private MainWindow mainWindow;
    private SnakeController snakeController;

    public ScoreController(int applesRequiredToNextLevel) {
        model = new ScoreModel(applesRequiredToNextLevel, this);
    }
    
    public void countEatenApple() {
        Levels achievedLevel = model.countEatenApple();
        updateMainWindowInfoPanel();
        
        if (achievedLevel != null) {
            snakeController.increaseSnakesSpeed(achievedLevel.getSpeed());
        }
    }
    
    private void updateMainWindowInfoPanel() {
        String score = model.getScore().toString();
        String level = model.getCurrentLevel().getLevel().toString();
        
        mainWindow.updateInfoPanel(score, level);
    }

    public void markGameAsWon() {
        mainWindow.showWinDialog();
    }
    
    public void clearScoreModel() {
        model.clearModel();
        updateMainWindowInfoPanel();
    }
    
    public Levels getCurrentLevel() {
        return model.getCurrentLevel();
    }

    public void setSnakeController(SnakeController snakeController) {
        this.snakeController = snakeController;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    
}
