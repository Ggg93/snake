package dev.gl.snake.controllers;

import dev.gl.snake.views.BoardCell;
import dev.gl.snake.views.BoardPosition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.random.RandomGenerator;
import javax.swing.JPanel;

/**
 *
 * @author gl
 */
public class BoardController {

    private final Map<BoardPosition, BoardCell> cells;
    private Map<Integer, Map<Integer, BoardPosition>> positions; // key - row, value - Map<column, BoardBosition>
    private int squareSideLength;
    private SnakeController snakeController;
    private BoardPosition applePosition;

    public BoardController(int squareSideLength, Map<BoardPosition, BoardCell> cells) {
        this.squareSideLength = squareSideLength;
        this.cells = cells;

        positions = new HashMap<>();
    }

    public void loadBoard(JPanel mainPanel) {

        for (int c = 0; c < squareSideLength; c++) {
            for (int r = 0; r < squareSideLength; r++) {
                BoardCell cell = new BoardCell(r, c);
                mainPanel.add(cell);

                BoardPosition position = cell.getBoardPosition();

                cells.put(position, cell);

                Map<Integer, BoardPosition> rowMap = positions.getOrDefault(r, new HashMap<>());
                rowMap.put(c, position);
                positions.put(r, rowMap);
            }
        }
    }

    public void setSnakeOnBoard(int snakeLength) {
        snakeController.initSnakeModel(snakeLength, getMiddleOfBoard());
    }

    public void setSnakeController(SnakeController snakeController) {
        this.snakeController = snakeController;
    }
    
    public void setAppleOnBoard() {
        Set<BoardPosition> occupiedCells = snakeController.getOccupiedCells();
        Boolean isCellFree = false;
        
        BoardPosition pos = null;
        RandomGenerator generator = RandomGenerator.getDefault();
        while (!isCellFree) {
            Integer x = generator.nextInt(0, squareSideLength);
            Integer y = generator.nextInt(0, squareSideLength);
            pos = new BoardPosition(x, y);
            isCellFree = !occupiedCells.contains(pos);
        }
        
        applePosition = pos;
        cells.get(pos).setApple();
    }
    
    public void updateSnakePositionOnBoard() {
        List<BoardPosition> snakePosition = snakeController.getSnakePosition();
        for (int i = 0; i < snakePosition.size(); i++) {
            BoardPosition pos = snakePosition.get(i);
            BoardCell cell = cells.get(pos);
            if (i == 0) {
                cell.setSnakeHead();
            } else {
                cell.setSnakeBody();
            }
        }
        
    }

    private BoardPosition getMiddleOfBoard() {
        int x = squareSideLength / 2;
        int y = squareSideLength / 2;
        return getBoardPositionByCoordinates(x, y);
    }

    private BoardPosition getBoardPositionByCoordinates(int x, int y) {
        BoardPosition pos = positions.get(y).get(x);
        Logger.getLogger(this.getClass().getName()).fine("pos = " + pos);
        return pos;
    }

}
