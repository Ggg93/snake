package dev.gl.snake.controllers;

import dev.gl.snake.enums.MainWindowState;
import dev.gl.snake.views.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class StartButtonListener extends AbstractAction {

    private SnakeController snakeController;
    private MainWindow mainWindow;

    public StartButtonListener(SnakeController snakeController, MainWindow mainWindow) {
        this.snakeController = snakeController;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (mainWindow.getMainWindowState() == MainWindowState.IDLE) {
            snakeController.startMovement();
            mainWindow.changeMainWindowState(MainWindowState.PLAYING);
        }
        
    }

}
