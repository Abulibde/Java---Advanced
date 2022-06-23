package _10_ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ex_2_Bomb {

    private static int row = 0;
    private static int col = 0;
    private static int bombs = 0;
    private static boolean bombsLeft = true;
    private static boolean isEnd = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] commandsLine = scanner.nextLine().split(",");

        char[][] field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            field[i] = line.toCharArray();

            //find initial position of the mouse
            if (line.contains("s")) {
                row = i;
                col = line.indexOf("s");
            }
        }
        bombFinder(field);


        for (int i = 0; i < commandsLine.length; i++) {
            String command = commandsLine[i];

            if (command.equals("up")) {
                move(field, -1, 0);
            } else if (command.equals("down")) {
                move(field, 1, 0);
            } else if (command.equals("left")) {
                move(field, 0, -1);
            } else if (command.equals("right")) {
                move(field, 0, 1);
            }

            if (isEnd || !bombsLeft) {
                break;
            }
        }


        if (!bombsLeft) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isEnd){
            System.out.println("END! " + bombs + " bombs left on the field");
        }else{
            System.out.println(bombs + " bombs left on the field. Sapper position: (" + row + "," + col + ")");
        }


    }

    private static void move(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        if (!isInBounds(field, nextRow, nextCol)) {
            return;
        }

        if (field[nextRow][nextCol] == 'e') {
            isEnd = true;
            return;
        } else if (field[nextRow][nextCol] == 'B') {
            System.out.println("You found a bomb!");

            field[nextRow][nextCol] = '+';

            bombs--;
        }

        if (bombs == 0) {
            bombsLeft = false;
        }

        row = nextRow;
        col = nextCol;

    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static void bombFinder(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 'B') {
                    bombs++;
                }
            }

        }
    }
}
