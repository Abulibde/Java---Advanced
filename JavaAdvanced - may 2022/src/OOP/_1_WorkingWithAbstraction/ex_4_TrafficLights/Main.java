package OOP._1_WorkingWithAbstraction.ex_4_TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> colors = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String color : colors) {

            TrafficLight trafficLight = new TrafficLight(Colors.valueOf(color));
            trafficLights.add(trafficLight);

        }

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getCurrentColor()+" ");
            }
            System.out.println();
        }



    }
}
