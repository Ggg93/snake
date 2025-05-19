package dev.gl.snake.controllers;

import dev.gl.snake.enums.Levels;
import dev.gl.snake.models.ScoreModel;
import dev.gl.snake.views.MainWindow;

/**
 *
 * @author gl
 */
public class ScoreController {
    private final MainWindow mainWindow;
    private final ScoreModel model;

    public ScoreController(MainWindow mainWindow, int applesRequiredToNextLevel) {
        
        this.mainWindow = mainWindow;
        model = new ScoreModel(applesRequiredToNextLevel, mainWindow);
    }
    
    public void countEatenApple() {
        model.countEatenApple();
        updateMainWindowInfoPanel();
    }
    
    private void updateMainWindowInfoPanel() {
        String score = model.getScore().toString();
        String level = model.getCurrentLevel().getLevel().toString();
        
        mainWindow.updateInfoPanel(score, level);
    }
    
    public Levels getCurrentLevel() {
        return model.getCurrentLevel();
    }
    
    
}
