public class Board {
    private Cell[][] cells;
    private int size;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        // Board Initialization
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean makeMove(int row, int col, Symbol symbol) {
        if (row<0 || row>this.size || col<0 || col>this.size) return false;

        cells[row][col] = new Cell(row, col);
        cells[row][col].setSymbol(symbol);
        return true;
    }

    public void print() {
        for (int i=0; i<this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.cells[i][j].getSymbol() + " ");
            }
            System.out.println();
        }

    }

    public boolean isGameDraw() {
        for (int i=0; i<this.size; i++) {
            for (int j=0; j<this.size; j++) {
                if (this.cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
