package dev.gl.snake.views;

import java.awt.Color;

/**
 *
 * @author gl
 */
public class BoardCell extends javax.swing.JPanel {
    private static final Color SNAKE_HEAD = new Color(34, 34, 34);
    private static final Color SNAKE_BODY = new Color(99, 99, 99);
    private static final Color APPLE = new Color(255, 8, 0);

    private final BoardPosition boardPosition;

    public BoardCell(int x, int y) {
        boardPosition = new BoardPosition(x, y);
        initComponents();
    }

    public BoardPosition getBoardPosition() {
        return boardPosition;
    }
    
    public void setSnakeHead() {
        setBackground(SNAKE_HEAD);
    }
    
    public void setSnakeBody() {
        setBackground(SNAKE_BODY);
    }
    
    public void setApple() {
        setBackground(APPLE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
