package OOP._4_InterfacesAndAbstraction.ex_3_BirthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> thingsWithBirthday = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"End".equals(line)) {

            String[] inputInfo = line.split(" ");

            String typeOfInfo = inputInfo[0];
            switch (typeOfInfo) {
                case "Citizen":
                    String citizenName = inputInfo[1];
                    int citizenAge = Integer.parseInt(inputInfo[2]);
                    String citizenId = inputInfo[3];
                    String citizenBirthDate = inputInfo[4];

                    Birthable citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                    thingsWithBirthday.add(citizen);

                    break;

                case "Pet":
                    String petName = inputInfo[1];
                    String petBirthDate = inputInfo[2];

                    Birthable pet = new Pet(petName,petBirthDate);
                    thingsWithBirthday.add(pet);

                    break;

                case "Robot":
                    //toDo: create a robot
                    break;
            }


            line = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : thingsWithBirthday) {
            if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }


}
