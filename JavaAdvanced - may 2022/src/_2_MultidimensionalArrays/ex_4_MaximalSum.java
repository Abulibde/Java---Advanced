package _2_MultidimensionalArrays;

/*
Write a program that reads a rectangular integer matrix of size N x M
and finds in it the square 3 x 3 that has a maximal sum of its elements.

Input
•	On the first line, you will receive the rows N and columns M.
•	On the next N lines, you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below.

Examples
Input	            Output
4 5
1 5 5 2 4
2 1 4 14 3
3 7 11 2 8
4 8 12 16 4
	                Sum = 75
                    1 4 14
                    7 11 2
                    8 12 16
 */

import java.util.Arrays;
import java.util.Scanner;

public class ex_4_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        handleMatrix(scanner, rows, matrix);

        int maxElement = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentElement = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentElement > maxElement) {
                    maxElement = currentElement;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxElement);
        printBestMatrix(matrix, startRow, startCol);


        System.out.println();
    }

    private static void printBestMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void handleMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
