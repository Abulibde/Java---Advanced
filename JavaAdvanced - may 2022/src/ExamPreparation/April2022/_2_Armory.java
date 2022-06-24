package ExamPreparation.April2022;

import java.util.Scanner;

public class _2_Armory {
    static int row = 0;
    static int col = 0;
    static int m1row = 0;
    static int m1col = 0;
    static int m2row = 0;
    static int m2col = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }


        boolean hasMirror = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] == 'A') {
                    row = i;
                    col = j;
                }

                if (matrix[i][j] == 'M') {
                    if (!hasMirror) {
                        m1row = i;
                        m1col = j;
                        hasMirror = true;
                    }

                } else {
                    m2row = i;
                    m2col = j;
                }
            }

        }

        System.out.println();
    }
}
