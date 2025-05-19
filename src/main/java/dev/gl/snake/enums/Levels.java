package dev.gl.snake.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gl
 */
public enum Levels {
    ONE(1, 800, 10),
    TWO(2, 750, 15),
    THREE(3, 700, 20),
    FOUR(4, 650, 25),
    FIVE(5, 600, 30),
    SIX(6, 550, 35),
    SEVEN(7, 500, 40),
    EIGHT(8, 450, 45),
    NINE(9, 400, 50),
    TEN(10, 350, 55),
    ELEVEN(11, 300, 60),
    TWELVE(12, 350, 65),
    THIRTEEN(13, 300, 70),
    FOURTEEN(14, 250, 75),
    FIFTHEEN(15, 200, 80);

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
