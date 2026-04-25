import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Player> players = List.of(new Player("Suraj", Symbol.X), new Player("Mansi", Symbol.O));
        Board board = new Board(3);
        Game game = Game.getInstance(board, players);

        while (game.getGameStatus()==GameStatus.IN_PROGRESS) {
            System.out.println("Enter row and columns: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            game.play(row, col);
        }

        scanner.close();
    }
}