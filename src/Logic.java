package TicTacToe.src;

import java.util.Arrays;
import java.util.Scanner;

import TicTacToe.src.Players;
import TicTacToe.src.TicTacToeGame;

public class Logic {
  private char[][] board;

  public Logic() {
    // fill the board with - to denote a cell is empty
    board = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  // display the board
  public void display() {
    for (int i = 0; i < 3; i++) {
      System.out.print("                         ");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + "   ");
      }
      System.out.println();
    }
    System.out.println("\n");
  }

  // make move and check if it is valid
  public boolean move(int row, int col, char Symbol) {
    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
      board[row][col] = Symbol;
      return true;
    }
    System.out.println("invalid move. Try again!!");
    return false;
  }

  // check for a win
  public boolean checkWin(char symbol) {
    // check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
        return true;
      }
    }
    // check cols
    for (int j = 0; j < 3; j++) {
      if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
        return true;
      }
    }
    // check diagonals
    if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
      return true;
    }
    if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
      return true;
    }
    return false;
  }

  // check for a draw
  public boolean checkDraw() {
    for (int i = 0; i <= 2; i++) {
      for (int j = 0; j <= 2; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }
}
