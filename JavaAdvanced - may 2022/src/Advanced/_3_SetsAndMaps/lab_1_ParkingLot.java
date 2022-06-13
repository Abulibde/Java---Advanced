package Advanced._3_SetsAndMaps;

/*
Write a program that:
o	Records car numbers for every car that enters the parking lot.
o	Removes car number when the car is out.
When the parking lot is empty, print "Parking Lot is Empty".

Input
The input will be a string in the format "{direction, carNumber}".
The input ends with the string "END".

Output
Print the output with all car numbers, which are in the parking lot.

Examples
Input	                    Output
IN, CA2844AA                CA2844AA
IN, CA1234TA                CA9876HH
OUT, CA2844AA               CA2822UU
IN, CA9999TT
IN, CA2866HI
OUT, CA1234TA
IN, CA2844AA
OUT, CA2866HI
IN, CA9876HH
IN, CA2822UU
END	CA9999TT
 */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class lab_1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String[] input = scanner.nextLine().split(", ");

        while (!input[0].equals("END")) {

            String direction = input[0];
            String id = input[1];

            if (direction.equals("IN")) {
                parking.add(id);
            } else {
                parking.remove(id);
            }

            input = scanner.nextLine().split(", ");
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.forEach(car -> System.out.println(car));
        }
    }
}
