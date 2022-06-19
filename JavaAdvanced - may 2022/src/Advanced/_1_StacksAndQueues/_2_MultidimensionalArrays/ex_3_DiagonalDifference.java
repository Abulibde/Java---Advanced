package Advanced._1_StacksAndQueues._2_MultidimensionalArrays;


//Write a program that finds the difference between
// the sums of the square matrix diagonals (absolute value).

import java.util.Arrays;
import java.util.Scanner;

public class ex_3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        handleMatrix(scanner, size, matrix);

        int primaryDiag = 0;
        int secondaryDiag = 0;

        primaryDiag = sumPrimaryDiagonal(size, matrix, primaryDiag);
        secondaryDiag = sumSecondaryDiagonal(size, matrix, secondaryDiag);

        System.out.println(Math.abs(primaryDiag - secondaryDiag));


    }

    private static int sumSecondaryDiagonal(int size, int[][] matrix, int secondaryDiag) {
        for (int row = 0; row < size; row++) {
            secondaryDiag += matrix[row][size - 1 - row];
        }
        return secondaryDiag;
    }

    private static int sumPrimaryDiagonal(int size, int[][] matrix, int primaryDiag) {
        for (int count = 0; count < size; count++) {

            primaryDiag += matrix[count][count];

        }
        return primaryDiag;
    }

    private static void handleMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
