import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    public Game() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;

        Player Suraj = new Player(0);
        Player Ganesh = new Player(0);
        players.offer(Suraj);
        players.offer(Ganesh);
    }

    public void startGame() {
        while (winner==null) {
            Player player = findPlayerTurn();
            System.out.println("Player turn is " + player.getId() + ", current position is: " + player.position);

            int diceNumber = dice.rollDice();
            int newPlayerPosition = player.getPosition() + diceNumber;
            newPlayerPosition = movementCheck(newPlayerPosition);
            player.setPosition(newPlayerPosition);

            System.out.println("Player's " + player.getId() + " current position is " + player.getPosition());
            if (newPlayerPosition>(board.cells.length*(board.cells.length-1))) {
                winner = player;
            }
        }

        System.out.println("Winner is " + winner.getId());
    }

    private Player findPlayerTurn() {
        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }

    private int movementCheck(int position) {
        if (position>(board.cells.length*board.cells[0].length)-1) {
            return position;
        }

        Cell cell = board.getCell(position);
        if (cell.getGameObject()!=null && cell.gameObject.start==position) {
            String string = cell.gameObject.start>cell.gameObject.end ? "Snake" : "Ladder";
            System.out.println("Jump done by: " + string);
            return cell.gameObject.end;
        }

        return position;
    }
}
