import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int numberOfCells, int numberOfSnakes, int numberOfLadders) {
        initializeBoard(numberOfCells);
        addLaddersAndSnakes(numberOfSnakes, numberOfLadders);
    }

    public void initializeBoard(int numberOfCells) {
        cells = new Cell[numberOfCells][numberOfCells];
        for (int i=0; i<numberOfCells; i++) {
            for (int j=0; j<numberOfCells; j++) {
                Cell cell = new Cell();
                this.cells[i][j] = cell;
            }
        }
    }

    public void addLaddersAndSnakes(int numberOfSnakes, int numberOfLadders) {
        while (numberOfSnakes>0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if (snakeTail>=snakeHead) {
                continue;
            }

            GameObject gameObject = new GameObject(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setGameObject(gameObject);
            numberOfSnakes--;
        }

        while (numberOfLadders>0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if (ladderTail<=ladderHead) {
                continue;
            }

            GameObject gameObject = new GameObject(ladderHead, ladderTail);
            Cell cell = getCell(ladderHead);
            cell.setGameObject(gameObject);
            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition) {
        int objectHead = playerPosition/cells.length;
        int objectTail = playerPosition%cells.length;
        return cells[objectHead][objectTail];
    }
}
