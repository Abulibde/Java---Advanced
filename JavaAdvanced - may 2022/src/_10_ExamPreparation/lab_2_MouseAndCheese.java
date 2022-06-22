package _10_ExamPreparation;

/*
You will be given an integer n for the size of the mouse territory with a square shape. On the next n lines, you will receive the rows of the territory. The mouse will be placed in a random position, marked with the letter 'M'. On random positions, there will be cheese, marked with 'c'. There may also be a bonus on the territory. There will always be only one bonus. It will be marked with the letter - 'B'. All of the empty positions will be marked with '-'.
Each turn, you will be given a command for the mouse’s movement.
The commands will be: "up", "down", "left", "right", "end".
If the mouse moves to cheese, it eats the cheese and increases the cheese it has eaten by one.
If it goes to a bonus, the mouse gets a bonus one move forward and then the bonus disappears. If the mouse goes out she can't return and the program ends. If the mouse receives "end" command the program ends. The mouse needs at least 5 eaten cheeses.
Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines hold the values for every row.
•	On each of the next lines, until you receive "end" command,  you will receive a move command.
Output
•	On the first line:
o	If the mouse goes out of its territory print: "Where is the mouse?".
•	On the second line:
o	 If the mouse couldn’t eat enough cheeses print: "The mouse couldn't eat the cheeses, she needed {needed} cheeses more.".
o	If the mouse has successfully eaten enough cheeses print: "Great job, the mouse is fed {eaten cheeses} cheeses!".
•	At the end print the matrix.
Constraints
•	The size of the square matrix will be between [2…10].
•	There will always be only one bonus, marked with 'B.
•	The mouse position will be marked with 'M'.
•	There won't be a case where a bonus moves the mouse out of its territory. 
Examples
Input	                                        Output	                                                                    Comments
3
M--
ccc
---
right
right
down
down
left
end	                                            The mouse couldn't eat the cheeses, she needed 4 cheeses more.
                                                ---
                                                cc-
                                                -M-	                                                                        1) right     2) right     3) down     5) down
                                                                                                                            -M-          --M          ---          ---
                                                                                                                             ccc          ccc          ccM              cc-
                                                                                                                             ---          ---          ---         --M

                                                                                                                            6) left
                                                                                                                             ---
                                                                                                                             cc-
                                                                                                                             -M-

 */

import java.util.Scanner;

public class lab_2_MouseAndCheese {
    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        //do the field
        char[][] field = new char[size][size];
        createField(scanner, size, field);

        //read commands
        String command = scanner.nextLine();
        while (!command.equals("end")) {


            //move the mouse
            if (command.equals("up")) {
                moveMouse(field, -1, 0);
            } else if (command.equals("down")) {
                moveMouse(field, 1, 0);
            } else if (command.equals("left")) {
                moveMouse(field, 0, -1);
            } else if (command.equals("right")) {
                moveMouse(field, 0, 1);
            }

            //out of bounds
            if (!mouseIsInField) {
                System.out.println("Where is the mouse?");
                break;
            }


            command = scanner.nextLine();
        }


        //check eaten cheese
        if (eatenCheese >= 5) {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " +
                    (5 - eatenCheese) + " cheeses more.");
        }

        //print final field
        printField(field);


    }

    //print field
    private static void printField(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
        boolean bonusHit = false;

        //get next position
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        //check the borders
        if (!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        //feed the mouse
        if (field[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (field[nextRow][nextCol] == 'B') {
            bonusHit = true;
        }

        //implement the movement
        field[row][col] = '-';
        field[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        //use the bonus
        if (bonusHit) {
            moveMouse(field, rowMutator, colMutator);
        }


    }

    //check borders
    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }


    //do the matrix
    private static void createField(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            //find initial position of the mouse
            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }
    }
}
