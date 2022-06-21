package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentCount = Integer.parseInt(scanner.nextLine());
        int neighborhoodSize = Integer.parseInt(scanner.nextLine());

        //createNeighborhood
        char[][] neighborhood = new char[neighborhoodSize][neighborhoodSize];
        createNeighborhood(scanner, neighborhoodSize, neighborhood);

        //where is Santa
        int[] santaPosition = new int[2];
        findSanta(neighborhoodSize, neighborhood, santaPosition);

        String command = scanner.nextLine();
        boolean outOfBounds = false;
        while (!command.equals("Christmas morning")) {

            outOfBounds = checkOutOfBounds(neighborhoodSize, santaPosition, command, outOfBounds);
            if (outOfBounds) {
                break;
            }



            command = scanner.nextLine();
        }

        System.out.println();

    }

    private static boolean checkOutOfBounds(int neighborhoodSize, int[] santaPosition, String command, boolean outOfBounds) {
        switch (command) {
            case "up":
                if (santaPosition[0] == 0) {
                    return outOfBounds = true;
                }
                break;

            case "down":
                if (santaPosition[0] == neighborhoodSize - 1) {
                    return outOfBounds = true;
                }
                break;

            case "left":
                if (santaPosition[1] == 0) {
                    return outOfBounds = true;
                }
                break;

            case "right":
                if (santaPosition[1] == neighborhoodSize - 1) {
                    return outOfBounds = true;
                }
                break;

        }
        return outOfBounds;
    }

    private static void findSanta(int neighborhoodSize, char[][] neighborhood, int[] santaPosition) {
        for (int row = 0; row < neighborhoodSize; row++) {
            for (int col = 0; col < neighborhoodSize; col++) {
                if (neighborhood[row][col] == 'S') {
                    santaPosition[0] = row;
                    santaPosition[1] = col;
                }
            }
        }
    }

    private static void createNeighborhood(Scanner scanner, int neighborhoodSize, char[][] neighborhood) {
        for (int row = 0; row < neighborhoodSize; row++) {
            neighborhood[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
    }

}
