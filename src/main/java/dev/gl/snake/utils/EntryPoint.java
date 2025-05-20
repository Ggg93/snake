package dev.gl.snake.utils;

import dev.gl.snake.controllers.NewGameController;
import dev.gl.snake.views.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author gl
 */
public class EntryPoint {
    
    public static void main(String[] args) {
        try {
            NewGameController newGameController = new NewGameController(25, 3, 5);
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            SwingUtilities.invokeLater(() -> {
                MainWindow mw = new MainWindow(newGameController);
                mw.setVisible(true);
            });
        } catch (Exception ex) {
            Logger.getLogger(EntryPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
