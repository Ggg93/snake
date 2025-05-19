package dev.gl.snake.controllers;

import dev.gl.snake.enums.MovementDirection;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ChangingDirectionListener extends AbstractAction {
    
    private SnakeController snakeController;
    private MovementDirection direction;

    public ChangingDirectionListener(SnakeController snakeController, MovementDirection direction) {
        super();
        this.snakeController = snakeController;
        this.direction = direction;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        snakeController.changeSnakeDirection(direction);
    }
    
    
}
