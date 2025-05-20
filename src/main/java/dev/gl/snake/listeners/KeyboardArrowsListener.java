package dev.gl.snake.listeners;

import dev.gl.snake.controllers.SnakeController;
import dev.gl.snake.enums.MainWindowState;
import dev.gl.snake.enums.MovementDirection;
import dev.gl.snake.views.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class KeyboardArrowsListener extends AbstractAction {

    private SnakeController snakeController;
    private MovementDirection direction;
    private MainWindow mainWindow;

    public KeyboardArrowsListener(SnakeController snakeController, MovementDirection direction, MainWindow mainWindow) {
        super();
        this.snakeController = snakeController;
        this.direction = direction;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (mainWindow.getMainWindowState() == MainWindowState.PLAYING) {
            snakeController.changeSnakeDirection(direction);
        }
    }

}
