package Advanced._2_MultidimensionalArrays;

/*
Write a program, which reads a string matrix from the console and performs certain operations
with its elements. User input is provided in a similar way as in the problems above – first,
you read the dimensions and then the data.
Your program should then receive commands in the format: "swap row1 col1 row2c col2"
where row1, row2, col1, col2 are coordinates in the matrix. For a command to be valid,
it should start with the "swap" keyword along with four valid coordinates (no more, no less).
You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2])
and print the matrix at each step (this you'll be able to check if the operation was performed correctly).
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates
entered or the given coordinates do not exist), print "Invalid input!" and move on to the next command.
Your program should finish when the string "END" is entered.

Examples
Input	                    Output
2 3                         5 2 3
1 2 3                       4 1 6
4 5 6                       Invalid input!
swap 0 0 1 1                5 4 3
swap 10 9 8 7               2 1 6
swap 0 1 1 0
END
 */

import java.util.Scanner;

public class ex_5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] metrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            metrix[row] = scanner.nextLine().split("\\s+");
        }

        String[] line = scanner.nextLine().split("\\s+");
        while (!line[0].equals("END")) {
            if (line.length != 5) {
                System.out.println("Invalid input!");
                line = scanner.nextLine().split("\\s+");
                continue;
            }

            String command = line[0];
            int firstElementRow = Integer.parseInt(line[1]);
            int firstElementCol = Integer.parseInt(line[2]);
            int secondElementRow = Integer.parseInt(line[3]);
            int secondElementCol = Integer.parseInt(line[4]);

            String firstElement = "";
            String secondElement = "";

            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
            } else {
                if (0 <= firstElementRow && firstElementRow < rows
                        && 0 <= firstElementCol && firstElementCol < cols
                        && 0 <= secondElementRow && secondElementRow < rows
                        && 0 <= secondElementCol && secondElementCol < cols) {

                    swapElements(metrix, firstElementRow, firstElementCol, secondElementRow, secondElementCol);

                    printCurrentMetrix(rows, cols, metrix);


                } else {
                    System.out.println("Invalid input!");
                }
            }


            line = scanner.nextLine().split("\\s+");
        }
    }

    private static void printCurrentMetrix(int rows, int cols, String[][] metrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(metrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void swapElements(String[][] metrix, int firstElementRow, int firstElementCol, int secondElementRow, int secondElementCol) {
        String firstElement;
        String secondElement;
        firstElement = metrix[firstElementRow][firstElementCol];
        secondElement = metrix[secondElementRow][secondElementCol];

        metrix[firstElementRow][firstElementCol] = secondElement;
        metrix[secondElementRow][secondElementCol] = firstElement;
    }
}
