package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;

        List<String[]> solutions = new ArrayList<>();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        nQueens(n, 0, matrix, solutions);

        print(solutions);
    }

    private static void print(List<String[]> solutions) {
        for (String[] row : solutions) {
            for(String s: row) {
                System.out.print(s);
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }

    private static void nQueens(int n, int row, char[][] matrix, List<String[]> solutions) {

        if (row == n) {
            solutions.add(buildSolution(matrix));
            return;
        }

        for (int i=0;i<n;i++) {
            if (isSafe(matrix, row, i)){
                matrix[row][i] = 'Q';
                nQueens(n, row + 1, matrix, solutions);
                matrix[row][i] = '.';
            }
        }
        return;
    }

    private static String[] buildSolution(char[][] board) {
        int n = board.length;
        String[] solution = new String[n];
        for (int i = 0; i < n; i++) {
            solution[i] = new String(board[i]);
        }
        return solution;
    }

    private static boolean isSafe(char[][] matrix, int row, int col) {

        int n = matrix.length;
        for(int i=0;i<row;i++) {
            if(matrix[i][col] == 'Q') {
                return false;
            }
        }

        for(int i=row,j=col;i>=0&&j>=0;i--,j--) {
            if(matrix[i][j] == 'Q')
                return false;
        }

        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(matrix[i][j] == 'Q')
                return false;
        }

        return true;
    }


}
