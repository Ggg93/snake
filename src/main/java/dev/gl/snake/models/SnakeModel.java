package dev.gl.snake.models;

import dev.gl.snake.enums.MovementDirection;
import dev.gl.snake.utils.BoardPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gl
 */
public class SnakeModel {
    
    private List<BoardPosition> location = new ArrayList<>();
    private MovementDirection direction;

    public SnakeModel(int initialLength, BoardPosition startPosition) {
        
        location.add(startPosition);
        initialLength--;
        
        while (initialLength > 0) {
            int x = startPosition.getX();
            int y = location.getLast().getY() + 1;
            location.add(new BoardPosition(x, y));
            
            initialLength--;
        }
        
        direction = MovementDirection.NORTH;
    }

    public List<BoardPosition> getLocation() {
        return location;
    }

    public void setDirection(MovementDirection direction) {
        this.direction = direction;
    }

    public MovementDirection getDirection() {
        return direction;
    }
    
}
