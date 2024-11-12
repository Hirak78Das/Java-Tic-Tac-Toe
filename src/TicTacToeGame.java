package TicTacToe.src;

import java.util.ArrayList;
import java.util.Scanner;

import TicTacToe.src.Players;

public class TicTacToeGame {
  private ArrayList<Players> players; // to store players so that we can toggle between them
  private int currentPlayerindex;

  public TicTacToeGame() {
    players = new ArrayList<>();
    System.out.println("\n    ~~~~~~~~~~~~~~~~~~LETS PLAY~~~~~~~~~~~~~~~~~~~~~~");
    System.out.print("\n\n                   Enter your name: ");
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();

    char symbol;
    while (true) {
      System.out.print("\n               choose between 'X' or '0' : ");
      symbol = sc.next().charAt(0);
      System.out.println("\n\n");
      if (symbol == 'X' || symbol == '0') {
        break;
      } else {
        System.out.println("   Please enter the below mentioned symbols only  :");
      }
    }
    if (symbol == 'X') {
      players.add(new Players('X', name));
      players.add(new Players('0', "AI"));
    } else {
      players.add(new Players('0', name));
      players.add(new Players('X', "AI"));
    }
    currentPlayerindex = 0; // start with the first player

    // ~~~~~~~~~~~~~~~~~~~~~~~~ IMPORTANT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // sc.close();
    /*
     * if you close it here, then you can't use scanner again in main() function
     * furthur after this constructor get executed, hence close once and only in the
     * main() function.
     */
  }

  // get the current player
  public Players GetcurrentPlayer() {
    return players.get(currentPlayerindex);
  }

  // method to toggle player after each move
  public void togglePlayer() {
    currentPlayerindex = 1 - currentPlayerindex; // toggles between o and 1
  }
}
