package TicTacToe.src.Testing;

import java.util.Scanner;

import TicTacToe.src.Logic;
import TicTacToe.src.Players;
import TicTacToe.src.TicTacToeGame;

public class Testing {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    TicTacToeGame game = new TicTacToeGame();
    Logic logic = new Logic();

    while (true) {
      // after each move, show the board
      logic.display();

      Players currentplayer = game.GetcurrentPlayer(); // currentplayer will be changed after each move

      if (checkMove(currentplayer, logic)) {
        break;
      }
      game.togglePlayer();
    }
    sc.close();
  }

  // take the player input(rows and cols) and check if the move is valid
  public static boolean checkMove(Players currentplayer, Logic logic) {

    // first show the label or the player input info
    System.out.println(currentplayer.getName() + "'s turn. Enter row and colum (0,1 or 2)");
    System.out.print("\nrow: ");
    int i = sc.nextInt();
    System.out.print("column: ");
    int j = sc.nextInt();
    // make move and check for valid move
    if (logic.move(i, j, currentplayer.getSymbol())) {

      // check for a win
      if (logic.checkWin(currentplayer.getSymbol())) {
        System.out.println(currentplayer.getName() + "wins");
        return true;
      }

      // check for a draw
      if (logic.checkDraw()) {
        System.out.println("Draw!!");
        return true;
      }
    } else { // if player input invalid rows and cols
      // then call the function recursively
      return checkMove(currentplayer, logic);
    }
    return false; // continue the game if no win or draw
  }
}
