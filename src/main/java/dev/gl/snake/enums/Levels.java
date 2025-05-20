package dev.gl.snake.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gl
 */
public enum Levels {
    ONE(1, 500, 10),
    TWO(2, 450, 15),
    THREE(3, 400, 20),
    FOUR(4, 350, 25),
    FIVE(5, 300, 30),
    SIX(6, 275, 35),
    SEVEN(7, 250, 40),
    EIGHT(8, 225, 45),
    NINE(9, 200, 50),
    TEN(10, 175, 55),
    ELEVEN(11, 150, 60),
    TWELVE(12, 125, 65),
    THIRTEEN(13, 100, 70),
    FOURTEEN(14, 75, 75),
    FIFTHEEN(15, 50, 80);

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
