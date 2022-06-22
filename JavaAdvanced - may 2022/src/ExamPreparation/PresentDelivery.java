package ExamPreparation;

import java.util.Scanner;

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

        //read commands
        String commend = scanner.nextLine();
        boolean outOfBounds = false;
        boolean outOfPresents = false;
        while (!commend.equals("Christmas morning")) {

            //check the borders
            outOfBounds = checkOutOfBounds(neighborhoodSize, santaPosition, commend, outOfBounds);
            if (outOfBounds) {
                System.out.println("Santa ran out of presents!");
                return;
            }

            //move santa
            moveSanta(santaPosition, commend);

            //check the current position
            char currentHouse = neighborhood[santaPosition[0]][santaPosition[1]];
            switch (currentHouse) {
                //nice kid
                case 'V':
                    presentCount--;
                    if (presentCount <= 0) {
                        outOfPresents = true;
                        break;
                    }
                    neighborhood[santaPosition[0]][santaPosition[1]] = '-';
                    break;

                //bad kid
                case 'X':
                    neighborhood[santaPosition[0]][santaPosition[1]] = '-';
                    break;

                //cookies
                case 'C':
                    commend = "up";
                    outOfBounds = checkOutOfBounds(neighborhoodSize, santaPosition, commend, outOfBounds);
                    if (!outOfBounds){

                    }

                    neighborhood[santaPosition[0]][santaPosition[1]] = '-';
                    break;
            }


            commend = scanner.nextLine();
        }

        System.out.println();

    }

    private static void moveSanta(int[] santaPosition, String command) {
        switch (command) {
            case "up":
                santaPosition[0] -= 1;
                break;
            case "down":
                santaPosition[0] += 1;
                break;
            case "left":
                santaPosition[1] -= 1;
                break;
            case "right":
                santaPosition[1] += 1;
                break;
        }
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
