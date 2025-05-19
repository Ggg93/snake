package dev.gl.snake.models;

import dev.gl.snake.enums.Levels;
import dev.gl.snake.views.MainWindow;

/**
 *
 * @author gl
 */
public class ScoreModel {

    private MainWindow parent;
    private Levels currentLevel;
    private Integer score;
    private Integer eatenApplesOnCurrentLevel;
    private final Integer applesRequiredToNextLevel;

    public ScoreModel(Integer applesRequiredToNextLevel, MainWindow parent) {
        this.applesRequiredToNextLevel = applesRequiredToNextLevel;
        this.parent = parent;
        
        currentLevel = Levels.ONE;
        score = 0;
        eatenApplesOnCurrentLevel = 0;
        
    }

    public void countEatenApple() {
        score += currentLevel.getRewardPoints();
        eatenApplesOnCurrentLevel++;

        if (eatenApplesOnCurrentLevel.equals(applesRequiredToNextLevel)) {
            Levels nextLevel = Levels.getNextLevel(currentLevel);
            if (nextLevel == null) {
                parent.showWinDialog();
            } else {
                currentLevel = nextLevel;
                eatenApplesOnCurrentLevel = 0;
            }
        }
    }

    public Levels getCurrentLevel() {
        return currentLevel;
    }

    public Integer getScore() {
        return score;
    }

}
