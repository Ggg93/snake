package dev.gl.snake.views;

import dev.gl.snake.controllers.BoardController;
import dev.gl.snake.controllers.ScoreController;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {

    private BoardController boardController;
    private ScoreController scoreController;
    private Map<BoardPosition, BoardCell> cells = new HashMap<>();

    public MainWindow() {
        initComponents();
        boardController = new BoardController(25, cells);
        boardController.loadBoard(mainPanel);
        boardController.setSnakeOnBoard(3);
        boardController.updateSnakePositionOnBoard();
        boardController.setAppleOnBoard();
        
        scoreController = new ScoreController(this, 5);
        this.setLocationRelativeTo(null);
    }
    
    public void showWinDialog() {
        JOptionPane.showMessageDialog(this, "Congratulations!" + System.lineSeparator() + "You've won!", "VICTORY!", JOptionPane.OK_OPTION);
        // clear the board and get ready for the next game...
    }
    
    public void showLosingDialog() {
        JOptionPane.showMessageDialog(this, "Sorry..." + System.lineSeparator() + "You've lost =(", "DEFEAT", JOptionPane.OK_OPTION);
        // clear the board and get ready for the next game...
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
        scoreTextField.setText("0");
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

}
