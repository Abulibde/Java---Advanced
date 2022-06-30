package TheRealExam;

import java.util.Scanner;

public class StickyFingers {
    static int row = 0;
    static int col = 0;
    static int stolenMoney = 0;
    static boolean caughtByPolice = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] lineOfCommands = scanner.nextLine().split(",");

        String[][] matrix = new String[size][size];

        handleMatrix(scanner, size, matrix);

        for (String command : lineOfCommands) {
            if (command.equals("up")) {
                move(matrix, -1, 0);

            } else if (command.equals("down")) {
                move(matrix, 1, 0);

            } else if (command.equals("left")) {
                move(matrix, 0, -1);

            } else if (command.equals("right")) {
                move(matrix, 0, 1);
            }

            if (caughtByPolice) {
                break;
            }
        }


        if (!caughtByPolice) {
            System.out.println("Your last theft has finished successfully with " + stolenMoney + "$ in your pocket.");
        }

        showTheTown(matrix);
    }

    private static void showTheTown(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void move(String[][] matrix, int rowUpgrade, int colUpgrade) {

        int nRow = row + rowUpgrade;
        int nCol = col + colUpgrade;

        if (!isInTown(matrix, nRow, nCol)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }

        matrix[row][col] = "+";

        if (matrix[nRow][nCol].equals("$")) {
            int moneyInTheHouse = nRow * nCol;
            stolenMoney += moneyInTheHouse;
            System.out.println("You successfully stole " + moneyInTheHouse + "$.");
        } else if (matrix[nRow][nCol].equals("P")) {
            System.out.println("You got caught with " + stolenMoney + "$, and you are going to jail.");
            matrix[nRow][nCol] = "#";
            caughtByPolice = true;
            return;
        }

        row = nRow;
        col = nCol;
        matrix[row][col] = "D";


    }


    private static boolean isInTown(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void handleMatrix(Scanner scanner, int size, String[][] matrix) {
        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split(" ");

            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];

                if (matrix[i][j].equals("D")) {
                    row = i;
                    col = j;
                }
            }
        }
    }
}
