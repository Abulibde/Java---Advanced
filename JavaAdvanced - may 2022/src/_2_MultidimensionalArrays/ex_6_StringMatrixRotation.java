package _2_MultidimensionalArrays;

/*
You are given a sequence of text lines. Assume these text lines form a matrix of characters
(pad the missing positions with spaces to build a rectangular matrix).
Write a program to rotate the matrix by 90, 180, 270, 360,… degrees. Print the result at the
console as a sequence of strings after receiving the "END" command.

Input
The input is read from the console:
•	The first line holds the command in the format "Rotate(X)" where X is the degrees of the requested rotation.
•	The next lines contain the lines of the matrix for rotation.
•	The input ends with the command "END".
The input data will always be valid and in the format described. There is no need to check it explicitly.

Output
Print at the console the rotated matrix as a sequence of text lines.
Constraints
•	The rotation degree is a positive integer in the range [0…90000], where degrees are multiple of 90.
•	The number of matrix lines is in the range [1…1 000].
•	The matrix lines are strings of length 1 … 1 000.
•	Allowed working time: 200ms/16MB.

Examples
Input	                    Output
Rotate(90)                  esh
hello                       xoe
softuni                     afl
exam                        mtl
END	                         uo
                             n
                             i
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ex_6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree = Integer.parseInt(scanner.nextLine().split("[()]")[1]);

        ArrayList<String> words = new ArrayList<>();

        int maxWordLength = Integer.MIN_VALUE;

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            words.add(input);
            if (input.length() > maxWordLength) {
                maxWordLength = input.length();
            }
            input = scanner.nextLine();
        }


        int rows = words.size();
        int cols = maxWordLength;
        char[][] matrix = new char[rows][cols];
        handleMatrix(words, rows, cols, matrix);


        int rotationDegree = degree % 360;

        switch (rotationDegree) {
            case 0:
                printWithoutRotation(rows, cols, matrix);
                break;
            case 90:
                printWithRightRotation(rows, cols, matrix);
                break;
            case 180:
                printOppositeRotation(rows, cols, matrix);
                break;
            case 270:
                printLeftRotation(rows, cols, matrix);
                break;
        }


    }

    private static void printLeftRotation(int rows, int cols, char[][] matrix) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printOppositeRotation(int rows, int cols, char[][] matrix) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printWithRightRotation(int rows, int cols, char[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printWithoutRotation(int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void handleMatrix(ArrayList<String> words, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String currentWord = words.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    matrix[row][col] = currentWord.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

}
