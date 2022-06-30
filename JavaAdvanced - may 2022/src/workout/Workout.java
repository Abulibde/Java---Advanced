package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    //•	Method addExercise(Exercise exercise) –
    // adds an entity to the exercises If there is still space on the workout sheet (exerciseCount).
    public void addExercise(Exercise exercise) {
        if (exerciseCount > exercises.size()) {
            exercises.add(exercise);
        }
    }

    //•	Method removeExercise(String name, String muscle) –
    // removes the exercise by given name and muscle, if such exists, and returns boolean.
    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name) &&
                exercise.getMuscle().equals(muscle));
    }

    //•	Method getExercise(String name, String muscle) –
    // returns the exercise with the given name and muscle or null if there is no such exercise.
    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().
                filter(exercise -> exercise.getName().equals(name)
                        && exercise.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    //•	Method getMostBurnedCaloriesExercise() –
    // returns the exercise which is burned the most calories or null if there are no exercises.
    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream()
                .max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElse(null);
    }

    //•	Getter getExerciseCount() – returns the number of exercises.
    public int getExerciseCount() {
        return exercises.size();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"Workout type: {workout type}
    //Exercise: {Exercise1}
    //Exercise: {Exercise2}
    //(…)"
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", type));

        for (Exercise exercise : exercises) {
            sb.append(String.format("%s%n", exercise.toString()));
        }

        return sb.toString().trim();
    }
}


