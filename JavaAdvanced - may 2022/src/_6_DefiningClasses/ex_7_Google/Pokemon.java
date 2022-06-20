package _6_DefiningClasses.ex_7_Google;

public class Pokemon {

    private String name;
    private String element;

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
    }

    @Override
    public String toString() {
        return this.name + " " + this.element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
