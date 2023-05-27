package com.codingfundas.datastructure.problems;

public class SolveSudoku {
  public void solveSudoku(char[][] board) {
    int hello = Integer.MIN_VALUE;
    while (findNext(board) != null) {
      Custom c = findNext(board);
      int i = c.x;
      int j = c.y;
      solveSudoku(board, c.x, c.y);
    }
  }

  public static void main(String[] args) {
    char[][] board = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    SolveSudoku solveSudoku = new SolveSudoku();
    solveSudoku.solveSudoku(board);
  }

  private boolean solveSudoku(char[][] board, int i, int j) {
    for (int p = 1; p <= 9; p++) {
      if (validateRow(i, j, (char) ('0' + p), board)
          && validateColumn(j, i, (char) ('0' + p), board)
          && validateBox(i, j, (char) ('0' + p), board)) {
        board[i][j] = (char) ('0' + p);
        Custom c = findNext(board);
        if (c == null) {
          return true;
        }
        int m = c.x;
        int n = c.y;
        boolean res = solveSudoku(board, m, n);
        if (res) {
          return true;
        } else {
          board[i][j] = '.';
        }
      }
    }
    return false;
  }

  private boolean validateRow(int i, int j, char val, char[][] board) {
    for (int m = 0; m < 9; m++) {
      if (m == j) {
        continue;
      }
      if (board[i][m] == val) {
        return false;
      }
    }
    return true;
  }

  private boolean validateColumn(int j, int i, char val, char[][] board) {
    for (int m = 0; m < 9; m++) {
      if (m == i) {
        continue;
      }
      if (board[m][j] == val) {
        return false;
      }
    }
    return true;
  }

  private boolean validateBox(int m, int n, char val, char[][] board) {
    // [0,0][0,1][0,2]   [0,3][0,4][0,5]
    // [1,0][1,1][1,2]   [1,3][1,4][1,5]
    // [2,0][2,1][2,2]   [2,3][2,4][2,5]

    int startRow = (m / 3) * 3;
    int startCol = (n / 3) * 3;

    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        if (i == m && j == n) {
          continue;
        }
        if (board[i][j] == val) {
          return false;
        }
      }
    }
    return true;
  }

  public Custom findNext(char[][] board) {
    int i = 0;
    int j = 0;
    while (i < 9) {
      while (j < 9) {
        if (board[i][j] == '.') {
          return new Custom(i, j);
        }
        j++;
      }
      i++;
    }
    return null;
  }

  class Custom {
    int x;
    int y;

    public Custom(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
