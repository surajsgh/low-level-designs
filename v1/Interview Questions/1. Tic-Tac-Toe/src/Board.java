import java.util.ArrayList;

public class Board {
    int size;

    PieceType[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PieceType[size][size];
    }

    public int getSize() {
        return size;
    }

    public PieceType boardValue(int row, int column) {
        return board[row][column];
    }

    public void printBoard() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j]!=null) {
                    System.out.print(board[i][j].getPiece().name() + " ");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public ArrayList<Pair> emptySpace() {
        ArrayList<Pair> list = new ArrayList<>();
        boolean empty = false;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j]==null) {
                    list.add(new Pair(i, j));
                }
            }
        }
        return list;
    }

    public boolean emptyPosition(int row, int column) {
        return board[row][column]==null;
    }

    public boolean addPiece(PieceType pieceType, int row, int column) {
        if (board[row][column]==null) {
            board[row][column] = pieceType;
            return true;
        }
        return false;
    }
}
