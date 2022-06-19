package Advanced._1_StacksAndQueues._2_MultidimensionalArrays;

/*
Filling a matrix in the regular way (top to bottom and left to right) is boring.
Write two methods that fill a matrix of size N x N in two different patterns.
Both patterns are described below:

Examples
Input       	Output
3, A            1 4 7
                2 5 8
                3 6 9

3, B	        1 6 7
                2 5 8
                3 4 9

 */

import java.util.Scanner;

public class ex_1_FilTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[size][size];

        switch (method) {
            case "A":
                methodA(matrix);
                break;
            case "B":
                methodB(size, matrix);
                break;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }

    private static void methodB(int size, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    public static void methodA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }

        }
    }
}
