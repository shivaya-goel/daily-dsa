package Backtracking;

import java.util.Collections;
import java.util.Scanner;

public class Sudoku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
//        String input = sc.next();
        String input = "600000020050000401000498000480930600060080030005026084000319000809000040010000006";
        int index = 0;
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                matrix[i][j] = input.charAt(index) - '0';
                index++;
            }
        }
        System.out.println("Input Sudoku : ");
        print(matrix);
        sudoku(0,0,matrix);
        System.out.println("Output Sudoku : ");
        print(matrix); // "634571928958263471721498365487935612162784539395126784246319857879652143513847296"
    }

    static boolean sudoku(int row, int col, int[][] matrix) {
        if(col == 9) {
            row++;
            col = 0;
        }
        if(row == 9) {
            return true;
        }

        if(matrix[row][col]!=0) {
            return sudoku(row, col+1, matrix);
        }

        for(int i=1;i<=9;i++) {
            if(isValid(i,row,col,matrix)) {
                matrix[row][col] = i;
                if(sudoku(row, col+1, matrix)) {
                    return true;
                }
                matrix[row][col] = 0;
            }
        }
        return false;
    }

    static void print(int[][] matrix) {
        for(int[] row: matrix) {
            for (int val : row) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

    static boolean isValid(int val, int row, int col, int[][] matrix) {
        for (int i=0;i<9;i++) {
            if (matrix[row][i]==val) {
                return false;
            }
        }

        for (int i=0;i<9;i++) {
            if (matrix[i][col]==val) {
                return false;
            }
        }

        int r = (row/3)*3;
        int c = (col/3)*3;
        for (int i=r;i<r+3;i++) {
            for (int j=c;j<c+3;j++) {
                if (matrix[i][j]==val) {
                    return false;
                }
            }
        }
        return true;
    }



}