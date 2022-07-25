package zoo.entities.animals;

public abstract class BaseAnimal implements Animal {
    private String name;
    private String kind;
    private double price;
    private double kg;

    public BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        setKg(kg);
        setPrice(price);
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Animal price cannot be below or equal to 0.");
        } else {
            this.price = price;
        }
    }

    private void setKind(String kind) {

        if (kind == null || kind.equals("\\s+")) {
            throw new NullPointerException("Animal kind cannot be null or empty.");
        } else {
            this.kind = kind;
        }
    }

    private void setName(String name) {
        if (name == null || name.equals("\\s+")) {
            throw new NullPointerException("Animal name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public double getPrice() {
        return price;
    }


    public abstract void eat();
}
