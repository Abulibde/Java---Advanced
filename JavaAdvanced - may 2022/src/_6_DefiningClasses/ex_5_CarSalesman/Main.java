package _6_DefiningClasses.ex_5_CarSalesman;

/*
Define two classes Car and Engine. A Car has a model, engine, weight, and color.
 An Engine has a model, power, displacement, and efficiency. A Car's weight, color,
 Engine displacements, and efficiency are optional.
On the first line, you will read a number N which will specify how many lines
of engines you will receive, on each of the next N lines you will receive information
about an Engine in the following format "{Model} {Power} {Displacement} {Efficiency}".
After the lines with engines, on the next line, you will receive a number M – specifying
the number of Cars that will follow, on each of the next M lines the information about
a Car will follow in the following format "{Model} {Engine} {Weight} {Color}", where the engine
in the format will be the model of an existing Engine. When creating the object for a Car,
you should keep a reference to the real engine in it, instead of just the engine's model,
note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in
the format defined below. If any of the optional fields have not been given print "n/a" in its place instead of:

{CarModel}:
{EngineModel}:
Power: {EnginePower}
Displacement: {EngineDisplacement}
Efficiency: {EngineEfficiency}
Weight: {CarWeight}
Color: {CarColor}

Optional
Override the class ToString() methods to have a reusable way of displaying the objects.
 

Examples
Input	                                                                        Output
2
V8-101 220 50
V4-33 140 28 B
3
FordFocus V4-33 1300 Silver
FordMustang V8-101
VolkswagenGolf V4-33 Orange	                                                    FordFocus:
                                                                                V4-33:
                                                                                Power: 140
                                                                                Displacement: 28
                                                                                Efficiency: B
                                                                                Weight: 1300
                                                                                Color: Silver
                                                                                FordMustang:
                                                                                V8-101:
                                                                                Power: 220
                                                                                Displacement: 50
                                                                                Efficiency: n/a
                                                                                Weight: n/a
                                                                                Color: n/a
                                                                                VolkswagenGolf:
                                                                                V4-33:
                                                                                Power: 140
                                                                                Displacement: 28
                                                                                Efficiency: B
                                                                                Weight: n/a
                                                                                Color: Orange

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> mapEngine = new HashMap<>();

        int countEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countEngines; i++) {

            String[] engineInfo = scanner.nextLine().split(" ");

            String engineModel = engineInfo[0];
            String power = engineInfo[1];
            mapEngine.put(engineModel, null);

            switch (engineInfo.length) {
                case 2:
                    Engine engine = new Engine(engineModel, power);
                    mapEngine.put(engineModel, engine);
                    break;
                case 3:
                    String disEFF = engineInfo[2];
                    engine = new Engine(engineModel, power, disEFF);
                    mapEngine.put(engineModel, engine);
                    break;
                case 4:
                    String displacement = engineInfo[2];
                    String efficiency = engineInfo[3];
                    engine = new Engine(engineModel, power, displacement, efficiency);
                    mapEngine.put(engineModel, engine);
                    break;
            }
        }

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            //"{Model} {Engine} {Weight} {Color}",
            String[] infoCar = scanner.nextLine().split(" ");
            String modelCar = infoCar[0];
            String engineModel = infoCar[1];

            switch (infoCar.length) {
                case 2:
                    Car car = new Car(modelCar, mapEngine.get(engineModel));
                    cars.add(car);
                    break;
                case 3:
                    String weightOrColor = infoCar[2];
                    car = new Car(modelCar,mapEngine.get(engineModel),weightOrColor);
                    cars.add(car);
                    break;
                case 4:
                    String weight = infoCar[2];
                    String color = infoCar[3];
                    car = new Car(modelCar,mapEngine.get(engineModel),weight,color);
                    cars.add(car);
                    break;
            }
        }
        cars.forEach(System.out::println);


    }
}
