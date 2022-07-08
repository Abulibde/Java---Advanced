package OOP._2_Encapsulation.ex_3_ShoppingSpree;

/*
Create two classes: class Person and class Product. Each person should have
a name, money, and a bag of products. Each product should have a name and cost.
The name cannot be an empty string. Be careful about white space in the name.
Money and cost cannot be a negative number.

Person
-	name: String
-	money:  double
-	products:  List<Product>
+ 	Person (String,  double)
-	setName (String): void
-	setMoney (double): void
+	buyProduct (Product): void
+	getName(): String

Product
-	name: String
-	cost: double
+ 	Product (String,  double)
-	setCost (double): void
-	setName (String): void
+	getName(): String
+	getCost (): double

Create a program in which each command corresponds to a person buying a product.
If the person can afford a product add it to his bag. If a person doesn’t have enough money,
print an appropriate exception message:
"{Person name} can't afford {Product name}"

In the first two lines, you are given all people and all products.
After all, purchases print every person in the order of appearance and all products
that he has bought also in order of appearance. If nothing is bought, print:
"{Person name} - Nothing bought".

Read commands till you find the line with the "END" command. In case of invalid input
(negative money exception message: "Money cannot be negative") or empty name:
(empty name exception message "Name cannot be empty") break the program with
an appropriate message. See the examples below:

Examples
Input	                                                Output
Peter=11;George=4
Bread=10;Milk=2
Peter Bread
George Milk
George Milk
Peter Milk
END	                                                    Peter bought Bread
                                                        George bought Milk
                                                        George bought Milk
                                                        Peter can't afford Milk
                                                        Peter - Bread
                                                        George - Milk, Milk

Hint
Judge does not work with isBlank() method. You can use trim().isEmpty().

 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] lineOfPeople = scanner.nextLine().split(";");
        getAllPeople(people, lineOfPeople);

        String[] lineOfProducts = scanner.nextLine().split(";");
        getAllProducts(products, lineOfProducts);

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandParts = command.split(" ");

            String buyerName = commandParts[0];
            String productName = commandParts[1];

            Person buyer = people.get(buyerName);
            Product productToBuy = products.get(productName);

            try {
                buyer.buyProduct(productToBuy);
                System.out.println(buyerName + " bought " + productName);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        people.values().forEach(person -> System.out.println(person.toString()));


    }

    private static void getAllPeople(Map<String, Person> people, String[] lineOfPeople) {
        for (String personOnTheLine : lineOfPeople) {
            String[] personInfo = personOnTheLine.split("=");
            String personName = personInfo[0];
            double personMoney = Double.parseDouble(personInfo[1]);

            try {
                Person person = new Person(personName, personMoney);
                people.put(personName, person);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getAllProducts(Map<String, Product> products, String[] lineOfProducts) {
        for (String productOnTheLine : lineOfProducts) {
            String[] productInfo = productOnTheLine.split("=");
            String productName = productInfo[0];
            double productCost = Double.parseDouble(productInfo[1]);

            try {
                Product product = new Product(productName, productCost);
                products.put(productName, product);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
