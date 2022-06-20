package _6_DefiningClasses.ex_7_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new HashMap<>();

        String[] info = scanner.nextLine().split("\\s+");
        while (!info[0].equals("End")) {
            String personName = info[0];
            personMap.putIfAbsent(personName, new Person(personName));
            String object = info[1];

            switch (object) {
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String element = info[3];
                    Pokemon pokemon = new Pokemon(pokemonName, element);
                    personMap.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = info[2];
                    String parenBirthday = info[3];
                    personMap.get(personName).getParents().add(new Parent(parentName, parenBirthday));
                    break;
                case "children":
                    String childName = info[2];
                    String childBirthday = info[3];
                    personMap.get(personName).getChildren().add(new Child(childName, childBirthday));
                    break;
                case "car":
                    String carModel = info[2];
                    String speed = info[3];
                    personMap.get(personName).setCar(new Car(carModel, speed));
                    break;
            }

            info = scanner.nextLine().split("\\s+");
        }

        String customer = scanner.nextLine();

        System.out.println(personMap.get(customer));
    }
}
