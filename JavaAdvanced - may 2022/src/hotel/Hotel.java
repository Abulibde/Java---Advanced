package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List<Person> roster;
    String name;
    int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }


    //•	Method add(Person person) - adds an entity to the roster if there is room for it
    public void add(Person person) {
        if (capacity - (getCount()) > 0) {
            this.roster.add(person);
        }
    }

    //Method remove(String name) - removes a person by given name, if such exists, and returns boolean
    public boolean remove(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }

    //•	Getter getCount() – returns the number of people.
    public int getCount() {
        return this.roster.size();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"The people in the hotel {name} are:
    //{Person1}
    //{Person2}
    //(…)"

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n",this.name));

        for (Person person : roster) {
            sb.append(String.format("%s%n",person.toString()));
        }
        return sb.toString();
    }

    //•	Method getPerson(String name, String hometown) –
    // returns the people with the given name and hometown or null if there is no such person.

    public Person getPerson(String name, String hometown) {
        return roster.stream().
                filter(person -> person.getName().equals(name)
                        && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);

    }
}
