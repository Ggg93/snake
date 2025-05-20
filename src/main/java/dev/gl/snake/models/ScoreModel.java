package dev.gl.snake.models;

import dev.gl.snake.controllers.ScoreController;
import dev.gl.snake.enums.Levels;

/**
 *
 * @author gl
 */
public class ScoreModel {

    private ScoreController controller;
    private Levels currentLevel;
    private Integer score;
    private Integer eatenApplesOnCurrentLevel;
    private final Integer applesRequiredToNextLevel;

    public ScoreModel(Integer applesRequiredToNextLevel, ScoreController controller) {
        this.applesRequiredToNextLevel = applesRequiredToNextLevel;
        this.controller = controller;
        
        clearModel();
    }

    /**
     * 
     * @return new Level if achieved it. Otherwise returns null.
     */
    public Levels countEatenApple() {
        score += currentLevel.getRewardPoints();
        eatenApplesOnCurrentLevel++;

        Levels achievedLevel = null;
        if (eatenApplesOnCurrentLevel.equals(applesRequiredToNextLevel)) {
            Levels nextLevel = Levels.getNextLevel(currentLevel);
            if (nextLevel != null) {
                currentLevel = nextLevel;
                achievedLevel = currentLevel;
                eatenApplesOnCurrentLevel = 0;
            } else {
                controller.markGameAsWon();
            }
        }
        
        return achievedLevel;
    }

    public Levels getCurrentLevel() {
        return currentLevel;
    }

    public Integer getScore() {
        return score;
    }

    public void clearModel() {
        currentLevel = Levels.ONE;
        score = 0;
        eatenApplesOnCurrentLevel = 0;
    }

}
