package dev.gl.snake.controllers;

import dev.gl.snake.enums.MovementDirection;
import static dev.gl.snake.enums.MovementDirection.EAST;
import dev.gl.snake.views.BoardCell;
import dev.gl.snake.utils.BoardPosition;
import dev.gl.snake.views.MainWindow;
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

    private MainWindow mainWindow;
    private final Map<BoardPosition, BoardCell> cells;
    private Map<Integer, Map<Integer, BoardPosition>> positions; // key - row, value - Map<column, BoardBosition>
    private int squareSideLength;
    private SnakeController snakeController;
    private ScoreController scoreController;
    private BoardPosition applePosition;

    public BoardController(int squareSideLength) {
        this.squareSideLength = squareSideLength;

        cells = new HashMap<>();
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

    public void moveSnake() {
//        System.out.println("move!");
        MovementDirection direction = snakeController.getDirection();

        List<BoardPosition> snakePosition = snakeController.getSnakePosition();
        BoardPosition head = snakePosition.getFirst();

        Integer x = head.getX();
        Integer y = head.getY();
        // calc next position
        switch (direction) {
            case NORTH:
                // north edge
                if (y.equals(0)) {
                    y = squareSideLength - 1;
                } else {
                    // regular step:
                    y--;
                }
                break;
            case SOUTH:
                // south edge
                if (y.equals(squareSideLength - 1)) {
                    y = 0;
                } else {
                    // regular step:
                    y++;
                }
                break;
            case EAST:
                // east edge
                if (x.equals(squareSideLength - 1)) {
                    x = 0;
                } else {
                    // regular step:
                    x++;
                }
                break;
            case WEST:
                if (x.equals(0)) {
                    x = squareSideLength - 1;
                } else {
                    // regular step:
                    x--;
                }
                break;
        }

        head = new BoardPosition(x, y);

        // pulls up its tail
        Boolean isEatingApple = head.equals(applePosition);
        if (!isEatingApple) {
            BoardPosition tail = snakeController.pullUpTail();

            // checks if it bites itself
            boolean doesSnakeBiteItself = snakeController.getOccupiedCells().contains(head);
            if (doesSnakeBiteItself) {
                mainWindow.showLosingDialog();
                return;
            }

            // clear cell where the tail was
            cells.get(tail).setEmpty();
        }

        // do next step
        cells.get(snakePosition.getFirst()).setSnakeBody();
        snakeController.makeNextStep(head);
        cells.get(head).setSnakeHead();

        if (isEatingApple) {
            scoreController.countEatenApple();
            setAppleOnBoard();
        }
    }

    public void setSnakeController(SnakeController snakeController) {
        this.snakeController = snakeController;
    }

    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }

    private void setAppleOnBoard() {
        // if apple position is changes, then clear old cell
        if (applePosition != null) {
            BoardCell previousApple = cells.get(applePosition);
            previousApple.setSnakeHead();
        }

        // now create new apple and show it on board
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

    public void placeNewSnakeOnBoard(List<BoardPosition> snakePosition) {
        // clean the field
        for (BoardCell cell : cells.values()) {
            cell.setEmpty();
        }
        
        // put new snake on board
        for (int i = 0; i < snakePosition.size(); i++) {
            BoardPosition pos = snakePosition.get(i);
            BoardCell cell = cells.get(pos);
            if (i == 0) {
                cell.setSnakeHead();
            } else {
                cell.setSnakeBody();
            }
        }
        
        // place apple on board
        applePosition = null;
        setAppleOnBoard();
    }

    public BoardPosition getMiddleOfBoard() {
        int x = squareSideLength / 2;
        int y = squareSideLength / 2;
        return getBoardPositionByCoordinates(x, y);
    }

    private BoardPosition getBoardPositionByCoordinates(int x, int y) {
        BoardPosition pos = positions.get(y).get(x);
        Logger.getLogger(this.getClass().getName()).fine("pos = " + pos);
        return pos;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    
}
