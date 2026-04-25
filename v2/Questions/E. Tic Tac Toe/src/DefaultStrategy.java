public class DefaultStrategy implements GameStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {
        Cell[][] grid = board.getCells();
        int n = grid.length;

        // Rows & Columns
        for (int i = 0; i < n; i++) {
            boolean rowWin = true, colWin = true;

            for (int j = 0; j < n; j++) {
                if (grid[i][j].getSymbol() != symbol) rowWin = false;
                if (grid[j][i].getSymbol() != symbol) colWin = false;
            }

            if (rowWin || colWin) return true;
        }

        // Diagonals
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < n; i++) {
            if (grid[i][i].getSymbol() != symbol) diag1 = false;
            if (grid[i][n - i - 1].getSymbol() != symbol) diag2 = false;
        }

        return diag1 || diag2;
    }
}

