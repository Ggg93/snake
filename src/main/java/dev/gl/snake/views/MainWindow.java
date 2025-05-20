package dev.gl.snake.views;

import dev.gl.snake.controllers.NewGameController;
import dev.gl.snake.controllers.SnakeController;
import dev.gl.snake.listeners.KeyboardArrowsListener;
import dev.gl.snake.listeners.StartButtonListener;
import dev.gl.snake.enums.MainWindowState;
import dev.gl.snake.enums.MovementDirection;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {

    private NewGameController newGameController;
    private MainWindowState mainWindowState;

    public MainWindow(NewGameController newGameController) {
        this.newGameController = newGameController;
        initComponents();
        newGameController.linkMainWindowToControllers(this);
        
        mainWindowState = MainWindowState.IDLE;

        newGameController.getBoardController().loadBoard(mainPanel);
        newGameController.getSnakeController().createNewSnake();

        initActionListeners();
        createKeyBindings();
        mainPanel.requestFocus(); // it helps detects key presses
        this.setLocationRelativeTo(null);
    }

    public void showWinDialog() {
        JOptionPane.showMessageDialog(this, "Congratulations!" + System.lineSeparator() + "You've won!", "VICTORY!", JOptionPane.OK_OPTION);
        newGameController.prepareNewGame(this);
    }

    public void showLosingDialog() {
        JOptionPane.showMessageDialog(this, "Sorry..." + System.lineSeparator() + "You've lost =(", "DEFEAT", JOptionPane.OK_OPTION);
        newGameController.prepareNewGame(this);
    }

    public void updateInfoPanel(String score, String level) {
        scoreTextField.setText(score);
        levelTextField.setText(level);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        controlsPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        leftInfoPanel = new javax.swing.JPanel();
        scoreLabel = new javax.swing.JLabel();
        scoreTextField = new javax.swing.JTextField();
        rightInfoPanel = new javax.swing.JPanel();
        levelLabel = new javax.swing.JLabel();
        levelTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake");
        setMinimumSize(new java.awt.Dimension(450, 500));
        setPreferredSize(new java.awt.Dimension(450, 500));
        getContentPane().setLayout(new java.awt.BorderLayout(2, 2));

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mainPanel.setLayout(new java.awt.GridLayout(25, 25));
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        controlsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        startButton.setText("Start!");
        controlsPanel.add(startButton);

        getContentPane().add(controlsPanel, java.awt.BorderLayout.SOUTH);

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        infoPanel.setLayout(new javax.swing.BoxLayout(infoPanel, javax.swing.BoxLayout.LINE_AXIS));

        scoreLabel.setText("Score: ");
        leftInfoPanel.add(scoreLabel);

        scoreTextField.setEditable(false);
        scoreTextField.setText("0    ");
        scoreTextField.setBorder(null);
        scoreTextField.setFocusable(false);
        leftInfoPanel.add(scoreTextField);

        infoPanel.add(leftInfoPanel);

        levelLabel.setText("Level: ");
        rightInfoPanel.add(levelLabel);

        levelTextField.setEditable(false);
        levelTextField.setText("0");
        levelTextField.setBorder(null);
        levelTextField.setFocusable(false);
        rightInfoPanel.add(levelTextField);

        infoPanel.add(rightInfoPanel);

        getContentPane().add(infoPanel, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initActionListeners() {
        startButton.addActionListener(new StartButtonListener(newGameController.getSnakeController(), this));
    }
    
    private void createKeyBindings() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "start");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "north");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "east");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "south");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "west");
        
        SnakeController snakeController = newGameController.getSnakeController();
        actionMap.put("start", (AbstractAction) startButton.getActionListeners()[0]);
        actionMap.put("north", new KeyboardArrowsListener(snakeController, MovementDirection.NORTH, this));
        actionMap.put("east", new KeyboardArrowsListener(snakeController, MovementDirection.EAST, this));
        actionMap.put("south", new KeyboardArrowsListener(snakeController, MovementDirection.SOUTH, this));
        actionMap.put("west", new KeyboardArrowsListener(snakeController, MovementDirection.WEST, this));
    }
    
    public void changeMainWindowState(MainWindowState newState) {
        mainWindowState = newState;
        
        switch (newState) {
            case PLAYING:
                startButton.setEnabled(false);
                break;
            case IDLE:
                startButton.setEnabled(true);
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel leftInfoPanel;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextField levelTextField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel rightInfoPanel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JTextField scoreTextField;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    public MainWindowState getMainWindowState() {
        return mainWindowState;
    }

}
