package _6_DefiningClasses.ex_5_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
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
                    mapEngine.put(engineModel,engine);
                    engines.add(engine);
                    break;
                case 3:
                    String disEFF = engineInfo[2];
                    engine = new Engine(engineModel, power, disEFF);
                    mapEngine.put(engineModel,engine);
                    engines.add(engine);
                    break;
                case 4:
                    String displacement = engineInfo[2];
                    String efficiency = engineInfo[3];
                    engine = new Engine(engineModel, power, displacement, efficiency);
                    mapEngine.put(engineModel,engine);
                    engines.add(engine);
                    break;
            }
          //  mapEngine.put(engineModel,engine);
        }
        System.out.println();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            //"{Model} {Engine} {Weight} {Color}",
            String[] infoCar = scanner.nextLine().split(" ");
            String modelCar = infoCar[0];
            String engineModel = infoCar[1];

            switch (infoCar.length) {
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }


    }
}
