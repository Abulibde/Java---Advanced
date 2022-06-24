package ExamPreparation.April2022;

/*
You have forged many swords, so now you start selling them. There are lots of customers who want to buy your blades, but you do not want to bargain for every single sword and decide to sell them to the king. The king sends an army officer to pick swords for his army. Your armory is huge, so you need to guide the army officer though.
You will be given an integer n for the size of the armory with a square shape. On the next n lines, you will receive the rows of the armory. The army officer will be placed in a random position, marked with the letter 'A'. On random positions, there will be swords, marked with a single digit (the price of the sword). There may also be mirrors, the count will be either 0 or 2 and they are marked with the letter - 'M'. All of the empty positions will be marked with '-'.
Each turn, you will tell the army officer which direction he should move. Move commands will be: "up", "down", "left", "right". If the army officer moves to a sword, he buys the sword for a price equal to the digit there and the sword disappears. If the army officer moves to a mirror, he teleports on the position of the other mirror, and then both mirrors disappear. If you guide the army officer out of the armory, he leaves with the swords that he has bought. In advance, you negotiate with the king, that he'll buy at least 65 gold coins worth of blades.
The program ends when the army officer buys blades for at least 65 gold coins, or you guide him out of the armory.
Input
•	On the first line, you are given the integer n – the size of the matrix (armory).
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a move command.
Output
•	On the first line:
o	If the army officer leaves the armory, print: "I do not need more swords!"
o	If the army officer fulfills the initial deal, print: "Very nice swords, I will come back for more!"
•	On the second line print the profit you’ve made: "The king paid {amount} gold coins."
•	At the end print the final state of the matrix (armory).
Constraints
•	The size of the square matrix (armory) will be between [2…10].
•	There will always be 0 or 2 mirrors, marked with the letter - 'M'.
•	The army officer’s position will be marked as 'A'.
•	There will be always two output scenarios: the army officer leaves or bays swords worth at least 65 gold coins.
 
Examples
Input	                                                        Output
4
A9--
-M--
----
M---
right
down
left	                                                        I do not need more swords!
                                                                The king paid 9 gold coins.
                                                                ----
                                                                ----
                                                                ----
                                                                ----


	Comments
	The first command is "right". The army officer moves to a sword, and buys it.
-А--
-M--
----
M---

Nex command is "down" the army officer steps on the mirror and teleports to the bottom left corner of the armory.
----
----
----
А---
The last command is "left". The army officer leaves the armory.

 */

import java.util.Scanner;

public class _2_Armory {
    static int row = 0;
    static int col = 0;
    static int m1row = 0;
    static int m1col = 0;
    static int m2row = 0;
    static int m2col = 0;
    static boolean IsInField = true;
    static int goldCoins = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.split("");
        }


        boolean hasMirror = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j].equals("A")) {
                    row = i;
                    col = j;
                }

                if (matrix[i][j].equals("M")) {
                    if (!hasMirror) {
                        m1row = i;
                        m1col = j;
                        hasMirror = true;

                    } else {
                        m2row = i;
                        m2col = j;
                    }

                }
            }

        }


        while (goldCoins < 65) {
            String command = scanner.nextLine();


            //move the mouse
            if (command.equals("up")) {
                move(matrix, -1, 0);
            } else if (command.equals("down")) {
                move(matrix, 1, 0);
            } else if (command.equals("left")) {
                move(matrix, 0, -1);
            } else if (command.equals("right")) {
                move(matrix, 0, 1);
            }

            //chek out of bounds
            if (!IsInField) {
                break;
            }

        }

        if (!IsInField) {
            System.out.println("I do not need more swords!");
        }else{
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.println("The king paid " + goldCoins + " gold coins.");

        printMatrix(matrix);




    }


    public static void move(String[][] matrix, int rowMutator, int colMutator) {

        //get next position
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        //leave last position
        matrix[row][col] = "-";

        //check the borders
        if (!isInBounds(matrix, nextRow, nextCol)) {
            IsInField = false;
            return;
        }

        //buy swords or teleport via mirrors
        if (matrix[nextRow][nextCol].matches("\\d")) {
            int swordPrice = Integer.parseInt(matrix[nextRow][nextCol]);
            goldCoins += swordPrice;

        } else if (matrix[nextRow][nextCol].equals("M")) {
            matrix[nextRow][nextCol] = "-";

            if (nextRow == m1row && nextCol == m1col) {
                nextRow = m2row;
                nextCol = m2col;

            } else {
                nextRow = m1row;
                nextCol = m1col;
            }
        }

        //implement the movement
        matrix[nextRow][nextCol] = "A";
        row = nextRow;
        col = nextCol;
    }

    //check borders
    private static boolean isInBounds(String[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    //print the matrix
    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
