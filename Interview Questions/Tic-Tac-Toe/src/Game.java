import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


//  1. get first player
//  2. print the board
//  3. check the empty space (if empty then proceed ahead or show game tied)
//  4. enter rows and columns
//  5. check if the position is empty (If not then ask to enter the empty position then starts the procedure again or continue.)
//  6. check if the user is winner (winner logic)
//  7. repeat the steps again

public class Game {
    Deque<Player> players;
    Board board;

    public void initializeGame() {
        players = new LinkedList<>();

        PieceType cross = new PieceTypeX();
        PieceType zero = new PieceTypeO();

        Player ganesh = new Player("Ganesh", cross);
        Player suraj = new Player("Suraj", zero);

        players.add(ganesh);
        players.add(suraj);

        board = new Board(3);
    }

    public void startGame() {
        boolean noWinner = true;
        while (noWinner) {
            //  1. get first player
            Player player = players.removeFirst();

            //  2. print the board
            board.printBoard();

            //  3. check the empty space (if empty then proceed ahead or show game tied)
            ArrayList<Pair> emptySpace = board.emptySpace();
            if (emptySpace.isEmpty()) {
                noWinner = false;
                System.out.println("No space available, the game tied.");
                continue;
            }

            //  4. enter rows and columns
            System.out.println("Player: " + player.getName() + " Please enter rows & columns player:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] values = input.split(",");
            int row = Integer.valueOf(values[0]);
            int column = Integer.valueOf(values[1]);

            //  5. check if the position is empty (If not then ask to enter the empty position then starts the procedure again or continue.)
            boolean availablePosition = board.emptyPosition(row, column);
            if (!availablePosition) {
                System.out.println("This position is already taken. Please try again.");
                players.addFirst(player);
                continue;
            }

            boolean pieceAdded = board.addPiece(player.getPieceType(), row, column);
            if (!pieceAdded) {
                System.out.println("This position is already taken. Please try again.");
                players.addFirst(player);
                continue;
            }
            players.addLast(player);

            boolean winner = isWinner(player.getPieceType(), row, column);
            if (winner) {
                System.out.println("Player " + player.getName() + " won.");
                return;
            }
        }
    }

    private boolean isWinner(PieceType pieceType, int row, int column) {
        boolean rowWinner = true;
        boolean columnWinner = true;
        boolean diagonalWinner = true;
        boolean antiDiagonalWinner = true;

        for (int i = 0; i<board.getSize(); i++) {
            if (board.boardValue(row, i)==null || board.boardValue(row, i)!=pieceType) {
                rowWinner = false;
            }
        }

        for (int i = 0; i<board.getSize(); i++) {
            if (board.boardValue(i, column)==null || board.boardValue(i, column)!=pieceType) {
                columnWinner = false;
            }
        }

        for (int i=0,j=0; i<board.getSize() && j<board.getSize(); i++, j++) {
            if (board.boardValue(i,j)==null || board.boardValue(i,j)!=pieceType) {
                diagonalWinner = false;
            }
        }

        for (int i=0,j=board.getSize()-1; i<board.getSize() && j>=0; i++, j--) {
            if (board.boardValue(j,i)==null || board.boardValue(j,i)!=pieceType) {
                antiDiagonalWinner = false;
            }
        }

        return rowWinner || columnWinner || diagonalWinner || antiDiagonalWinner;
    }
}
