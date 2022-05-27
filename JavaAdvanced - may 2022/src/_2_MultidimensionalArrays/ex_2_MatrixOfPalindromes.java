package _2_MultidimensionalArrays;

/*
Write a program to generate the following matrix of palindromes of 3 letters
with r rows and c columns like the one in the examples below.
•	Rows define the first and the last letter: row 0 -> ‘a’, row 1 -> ‘b’, row 2 -> ‘c’, …
•	Columns + rows define the middle letter:
o	column 0, row 0 -> ‘a’, column 1, row 0 -> ‘b’, column 2, row 0 -> ‘c’, …
o	column 0, row 1 -> ‘b’, column 1, row 1 -> ‘c’, column 2, row 1 -> ‘d’, …

Input
•	The numbers r and c stay in the first line at the input.
•	 r and c are integers in the range [1…26].
•	 r + c ≤ 27

Examples
Input       	Output
4 6	            aaa aba aca ada aea afa
                bbb bcb bdb beb bfb bgb
                ccc cdc cec cfc cgc chc
                ddd ded dfd dgd dhd did

3 2         	aaa aba
                bbb bcb
                ccc cdc
 */

import java.util.Arrays;
import java.util.Scanner;

public class ex_2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char letter = (char) (row + 'a');
                char middleLetter = (char) (letter + col);
                matrix[row][col] = "" + letter + middleLetter + letter;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
