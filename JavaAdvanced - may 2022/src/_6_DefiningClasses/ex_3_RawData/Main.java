package _6_DefiningClasses.ex_3_RawData;

/*
You are the owner of a courier company and you want to make a system for tracking your
cars and their cargo. Define a class Car that holds information about
the model, engine, cargo, and a collection of exactly 4 tires.
The engine, cargo, and tire should be separate classes, create a constructor
that receives all information about the Car and creates and initializes its inner
components (engine, cargo, and tires).
On the first line of the input you will receive a number N - the number of cars you have,
on each of the next N lines you will receive information about a car in the format:
"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure}
{Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}",
where the speed, power, weight and tire age are integers, tire pressure is a double.
After the N lines, you will receive a single line with one of 2 commands "fragile" or "flamable",
if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1
if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
The cars should be printed in order of appearing in the input.


Examples
Input	                                                                                        Output
2
ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
Citroen2CV 190 165 1200 fragile 0.9 3 0.85 2 0.95 2 1.1 1
fragile	                                                                                        Citroen2CV

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        //"{Model} {EngineSpeed} {EnginePower} {CargoWeight}
        // {CargoType} {Tire1Pressure} {Tire1Age} {Tire2Pressure}
        // {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}",
        for (int i = 0; i < countOfCars; i++) {
            String[] line = scanner.nextLine().split(" ");
            String model = line[0];

            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < line.length; j += 2) {
                double tirePressure = Double.parseDouble(line[j]);
                int tireAge = Integer.parseInt(line[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();
        if (cargoType.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(cargoType))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure()<1))
                    .forEach(car-> System.out.println(car.getModel()));
        } else {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(cargoType))
                    .filter(car -> car.getEngine().getPower()>250)
                    .forEach(car-> System.out.println(car.getModel()));

        }


    }
}
