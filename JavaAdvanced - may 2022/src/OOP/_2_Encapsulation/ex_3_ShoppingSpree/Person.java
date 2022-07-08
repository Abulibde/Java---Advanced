package OOP._2_Encapsulation.ex_3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {

        if (money >= product.getCost()) {
            products.add(product);
            money -= product.getCost();

        } else {
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " - ");

        String productInfo = products
                .stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        if (productInfo.isEmpty()) {
            sb.append("Nothing bought");
        }

        sb.append(productInfo);

        return sb.toString();
    }

    public String getName() {
        return name;
    }
}
