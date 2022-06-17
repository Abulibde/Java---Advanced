package _6_DefiningClasses.ex_3_SpeedRacing;

/*
Your task is to implement a program that keeps track of cars and their fuel
and supports methods for moving the cars. Define a class Car that keeps track
of a car information Model, fuel amount, fuel cost for 1 kilometer, and distance
traveled. A Car Model is unique - there will never be 2 cars with the same model.
 On the first line of the input, you will receive a number N - the number of cars
 you need to track, on each of the next N lines you will receive information for
 a car in the following format "{Model} {FuelAmount} {FuelCostFor1km}", all cars start at 0 kilometers traveled.
After the N lines, until the command "End" is received, you will receive commands
in the following format "Drive {CarModel} {amountOfKm}", implement a method in the
Car class to calculate whether a car can move that distance or not. If yes, the car
fuel amount should be reduced by the amount of used fuel and its distance traveled
should be increased by the amount of kilometers traveled, otherwise the car should not
move (Its fuel amount and distance traveled should stay the same) and you should print on
the console "Insufficient fuel for the drive". After the "End" command is received,
print each car in order of appearing in input and its current fuel amount and distance
traveled in the format "{Model} {fuelAmount} {distanceTraveled}", where the fuel amount
should be printed to two decimal places after the separator.


Examples
Input	                                                    Output
2
AudiA4 23 0.3
BMW-M2 45 0.42
Drive BMW-M2 56
Drive AudiA4 5
Drive AudiA4 13
End	                                                        AudiA4 17.60 18
                                                            BMW-M2 21.48 56

 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {

            String[] line = scanner.nextLine().split(" ");
            String model = line[0];
            double fuelAmount = Double.parseDouble(line[1]);
            double consumption = Double.parseDouble(line[2]);

            Car car = new Car(model, fuelAmount, consumption);
            cars.put(model, car);
        }

        String[] comandParts = scanner.nextLine().split(" ");
        while (!comandParts[0].equals("End")) {
            String model = comandParts[1];
            int kilometers = Integer.parseInt(comandParts[2]);

            Car currentCar = cars.get(model);

            if (!currentCar.hasEnoughFuel(kilometers)) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                currentCar.drive(kilometers);
            }

            comandParts = scanner.nextLine().split(" ");
        }

        cars.values().stream().forEach(System.out::println);
    }
}
