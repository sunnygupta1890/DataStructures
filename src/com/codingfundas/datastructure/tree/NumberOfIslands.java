package com.codingfundas.datastructure.tree;

/**
 * Created by sunngupt on 8/8/18.
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 * https://github.com/NeverDoubtTheWorm/Pramp/tree/master/Island_Count
 *
 *
 */
public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid = {{'1', '1', '1', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '1', '0', '1'}};

        char[][] grid1 = {{'0',  '1',  '0',  '1',  '0'},
                {'0',  '0',  '1',  '1',  '1'},
                {'1',  '0',  '0',  '1',  '0'},
                {'0' , '1' , '1',  '0',  '0'},
                {'1',  '0',  '1',  '0',  '1'}};

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.print("Total Number of islands " + numberOfIslands.numIslands(grid1));

    }

    public int numIslands(char[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;
        //call method numIslands for each unvisited one
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    Count count1 = new Count();
                    numIslands(grid, visited, i, j, count1);
                    System.out.println("Found island with size: " + count1.count);
                    count++;
                }
            }
        }
        return count;
    }

    public void numIslands(char[][] grid, int[][] visited, int row, int col, Count count) {

        if (visited[row][col] == 1 || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = 1;
        count.count++;

        //move right
        if (isValidCol(grid, col + 1) && grid[row][col + 1] == '1' && visited[row][col + 1] == 0)
            numIslands(grid, visited, row, col + 1, count);

        //move down
        if (isValidRow(grid, row + 1) && grid[row + 1][col] == '1' && visited[row + 1][col] == 0)
            numIslands(grid, visited, row + 1, col, count);

        //move left
        if (isValidCol(grid, col - 1) && grid[row][col - 1] == '1' && visited[row][col - 1] == 0)
            numIslands(grid, visited, row, col - 1, count);

        //move up
        if (isValidRow(grid, row - 1) && grid[row - 1][col] == '1' && visited[row - 1][col] == 0)
            numIslands(grid, visited, row - 1, col, count);

        return;
    }

    private boolean isValidRow(char[][] grid, int row) {
        if (row >= 0 && row < grid.length) {
            return true;
        }
        return false;
    }

    private boolean isValidCol(char[][] grid, int col) {
        if (col >= 0 && col < grid[0].length) {
            return true;
        }
        return false;
    }

    class Count {
        int count = 0;
    }
}
