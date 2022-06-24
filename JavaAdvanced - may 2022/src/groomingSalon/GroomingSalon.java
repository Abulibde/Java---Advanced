package groomingSalon;



import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name){
        return data.removeIf(pet->pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        return data.stream().
                filter(pet -> pet.getName().equals(name)
                        && pet.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" The grooming salon has the following clients:%n"));

        for (Pet pet : data) {
            sb.append(String.format("%s %s%n",pet.getName(),pet.getOwner()));
        }
        return sb.toString().trim();
    }
}
