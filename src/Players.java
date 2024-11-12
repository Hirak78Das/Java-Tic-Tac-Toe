package TicTacToe.src;

public class Players {
  private char symbol; // 'X' or '0'
  private String name;

  public Players(char symbol, String name) {
    this.symbol = symbol;
    this.name = name;
  }

  public char getSymbol() { // need this while making moves to check if the symbol is correct
    return symbol;
  }

  public String getName() {
    return name;
  }
}
