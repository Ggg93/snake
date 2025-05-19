package dev.gl.snake.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gl
 */
public enum Levels {
    ONE(1, 600, 10),
    TWO(2, 550, 15),
    THREE(3, 500, 20),
    FOUR(4, 450, 25),
    FIVE(5, 400, 30),
    SIX(6, 350, 35),
    SEVEN(7, 300, 40),
    EIGHT(8, 275, 45),
    NINE(9, 250, 50),
    TEN(10, 225, 55),
    ELEVEN(11, 200, 60),
    TWELVE(12, 175, 65),
    THIRTEEN(13, 150, 70),
    FOURTEEN(14, 125, 75),
    FIFTHEEN(15, 100, 80);

    private final Integer level;
    private final int speed; // in ms
    private final int rewardPoints;
    private static final Map<Integer, Levels> levels;

    static {
        levels = new HashMap<>();
        for (Levels lvl : values()) {
            levels.put(lvl.level, lvl);
        }
    }

    private Levels(int level, int speed, int rewardPoints) {
        this.level = level;
        this.speed = speed;
        this.rewardPoints = rewardPoints;
    }
    
    public static Levels getNextLevel(Levels currentLevel) {
        int lvl = currentLevel.getLevel();
        return levels.get(++lvl);
    }

    public int getSpeed() {
        return speed;
    }

    public Integer getLevel() {
        return level;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public static Map<Integer, Levels> getLevels() {
        return levels;
    }

    @Override
    public String toString() {
        return "Levels{"
                + "name=" + name()
                + ", level=" + level
                + ", speed=" + speed
                + ", rewardPoints=" + rewardPoints
                + '}';
    }

}
