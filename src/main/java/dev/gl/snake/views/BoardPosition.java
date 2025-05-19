package dev.gl.snake.views;

/**
 *
 * @author gl
 */
public class BoardPosition {

    private final int x;
    private final int y;

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "BoardPosition{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoardPosition other = (BoardPosition) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

}
