package _6_DefiningClasses.ex_7_Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String personName;
    private Company company;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private Car car;

    public Person(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        //"{personName}
        //	Company:
        //	{companyName} {companyDepartment} {salary}
        //	...
        //	Children:
        //	{childName} {childBirthday}
        //	{childName} {childBirthday}"
        return personName + "\n"
                + "Company:\n"
                + (company == null ? "" : company + "\n")
                + "Car:\n"
                + (car == null ? "" : this.car.getCarModel() + " " + this.car.getCarSpeed() + "\n")
                + "Pokemon:\n"
                + (pokemons.isEmpty() ? "" : this.pokemons.stream().map(Pokemon::toString).collect(Collectors.joining("\n")) + "\n")
                + "Parents:\n"
                + (parents.isEmpty() ? "" : this.parents.stream().map(Parent::toString).collect(Collectors.joining("\n")) + "\n")
                + "Children:\n"
                + (children.isEmpty() ? "" : this.children.stream().map(Child::toString).collect(Collectors.joining("\n")));


        /*String.format("%s%n" +
                "Company:%n" +
                "%s %s %.2f%n" +
                "Car:%n" +
                "%s %s%n" +
                "Pokemon:%n" +
                "")*/
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
