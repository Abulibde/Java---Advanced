package catHouse.entities.cat;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    public BaseCat(String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        setPrice(price);
        kilograms = 0;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cat price cannot be below or equal to 0.");
        }

        this.price = price;
    }

    public void setBreed(String breed) {
        if (null == breed || breed.equals("\\s+")) {
            throw new IllegalArgumentException("Cat breed cannot be null or empty.");
        }

        this.breed = breed;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (null == name || name.equals("\\s+")) {
            throw new IllegalArgumentException("Cat name cannot be null or empty.");
        }

        this.name = name;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }


    protected void upgradeKilograms(int step) {
        this.kilograms = getKilograms() + step;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public abstract void eating();
}
