package ExamPreparation.August2021;

import java.util.Scanner;

public class _2_FormulaOne {

    static int row = 0;
    static int col = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = line[i];

                if (matrix[i][j].equals("P")) {
                    row = i;
                    col = j;
                }
            }

        }


    }
}
