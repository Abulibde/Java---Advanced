package Advanced._2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class lab_1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = firstSize[0];
        int columns = firstSize[1];

        int[][] firstMatrix = new int[rows][columns];

        extracted(scanner, rows, columns, firstMatrix);


        System.out.println();

    }

    private static void extracted(Scanner scanner, int rows, int columns, int[][] firstMatrix) {
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
          for (int colmn = 0; colmn < columns; colmn++) {
                firstMatrix[row][colmn]=currentRow[colmn];
            }
        }
    }
}
