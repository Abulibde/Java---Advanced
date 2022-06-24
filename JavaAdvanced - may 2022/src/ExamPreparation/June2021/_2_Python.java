package ExamPreparation.June2021;

import java.util.Scanner;

public class _2_Python {
    static int length = 1;
    static int row = 0;
    static int col = 0;
    static int food = 0;
    static boolean enemy = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split(" ");

            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];

                if (matrix[i][j].equals("s")) {
                    row = i;
                    col = j;
                }

                if (matrix[i][j].equals("f")) {
                    food++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("up")) {
                move(matrix, -1, 0);
            } else if (command.equals("down")) {
                move(matrix, 1, 0);
            } else if (command.equals("left")) {
                move(matrix, 0, -1);
            } else if (command.equals("right")) {
                move(matrix, 0, 1);
            }

            if (food == 0) {
                break;
            }
            if (enemy) {
                break;
            }
        }

        String gameOver;

        if (food == 0) {
            gameOver = "You win! Final python length is " + length;
        } else if (enemy) {
            gameOver = "You lose! Killed by an enemy!";
        } else {
            gameOver = "You lose! There is still " + food + " food to be eaten.";
        }

        System.out.println(gameOver);


    }

    public static void move(String[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        matrix[row][col] = "*";

        if (nextRow < 0) {
            nextRow = matrix.length + nextRow;
        } else if (nextRow > matrix.length - 1) {
            nextRow = nextRow - matrix.length;
        }

        if (nextCol < 0) {
            nextCol = matrix.length + nextCol;
        } else if (nextCol > matrix.length - 1) {
            nextCol = nextCol - matrix.length;
        }
        row = nextRow;
        col = nextCol;

        if (matrix[row][col].equals("f")) {
            length++;
            food--;
        } else if (matrix[row][col].equals("e")) {
            enemy = true;
        }


    }
}
