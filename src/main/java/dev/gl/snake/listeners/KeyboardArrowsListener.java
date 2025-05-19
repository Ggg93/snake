package dev.gl.snake.listeners;

import dev.gl.snake.controllers.SnakeController;
import dev.gl.snake.enums.MovementDirection;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class KeyboardArrowsListener extends AbstractAction {
    
    private SnakeController snakeController;
    private MovementDirection direction;

    public KeyboardArrowsListener(SnakeController snakeController, MovementDirection direction) {
        super();
        this.snakeController = snakeController;
        this.direction = direction;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        snakeController.changeSnakeDirection(direction);
    }
    
    
}
