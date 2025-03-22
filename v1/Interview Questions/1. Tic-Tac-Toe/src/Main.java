//  Design Tic Tac Toe
//  Objects: Piece, Player, Board

//  1. get first player
//  2. print the board
//  3. check the empty space (if empty then proceed ahead or show game tied)
//  4. enter rows and columns
//  5. check if the position is empty (If not then ask to enter the empty position then starts the procedure again or continue.)
//  6. check if the user is winner (winner logic)
//  7. repeat the steps again

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
        game.startGame();
    }
}