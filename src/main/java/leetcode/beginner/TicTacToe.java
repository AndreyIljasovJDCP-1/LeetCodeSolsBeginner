package leetcode.beginner;

public class TicTacToe {
  public static void main(String[] args) {
    System.out.println(
        tictactoe(
            new int[][] {
              {0, 1},
              {2, 0},
              {1, 2},
              {1, 1},
              {2, 2},
              {0, 2}
            }));
  }

  public static String tictactoe(int[][] moves) {
    int y = 0;
    int x = 0;
    char[][] table = new char[3][3];

    for (int i = 0; i < moves.length; i++) {
      if ((i & 1) == 0) {
        x = moves[i][0];
        y = moves[i][1];
        table[x][y] = 'X';

      } else {
        x = moves[i][0];
        y = moves[i][1];
        table[x][y] = '0';
      }
    }
    return checkLines('X', table)
        ? "A"
        : checkLines('0', table)
            ? "B" : moves.length < 9 ? "Pending" : "Draw";
  }

  private static boolean checkLines(char check, char[][] table) {
    boolean line;
    for (int i = 0; i < 3; i++) {
      line = true;
      for (int j = 0; j < 3; j++) {
        if (table[i][j] != check) {
          line = false;
          break;
        }
      }
      if (line) return true;
    }

    for (int i = 0; i < 3; i++) {
      line = true;
      for (int j = 0; j < 3; j++) {
        if (table[j][i] != check) {
          line = false;
          break;
        }
      }
      if (line) return true;
    }
    line = true;
    for (int i = 0; i < 3; i++) {
      if (table[i][i] != check) {
        line = false;
        break;
      }
    }
    if (line) return true;
    line = true;
    for (int i = 0; i < 3; i++) {
      if (table[2 - i][i] != check) {
        line = false;
        break;
      }
    }

    return line;
  }
}
