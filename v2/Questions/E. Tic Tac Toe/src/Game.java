import java.util.List;

public class Game {
    private static Game instance;
    private Board board;
    private List<Player> players;
    private GameStrategy gameStrategy;
    private int currentIndex;
    private GameStatus gameStatus;

    private Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentIndex = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.gameStrategy = new DefaultStrategy();
    }

    public static Game getInstance(Board board, List<Player> players) {
        if (instance==null) {
            instance = new Game(board, players);
        }
        return instance;
    }

    public void play(int row, int col) {
        Player currentPlayer = this.players.get(this.currentIndex);

        boolean move = board.makeMove(row, col, currentPlayer.getSymbol());
        if (!move) {
            System.out.println("Please enter the correct input");
            return;
        }

        board.print();

        boolean result = this.gameStrategy.checkWinner(board, currentPlayer.getSymbol());
        if (result) {
            System.out.println(currentPlayer.getName() + " won the game!");
            this.gameStatus = GameStatus.OVER;
            return;
        }

        boolean isGameDraw = board.isGameDraw();
        if (isGameDraw) {
            System.out.println("Game is draw!");
            this.gameStatus = GameStatus.DRAW;
            return;
        }

        this.currentIndex = (this.currentIndex + 1) % this.players.size();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
