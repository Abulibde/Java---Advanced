package _6_DefiningClasses.ex_6_PokemonTrainer;

/*
You wanna be the very best pokemon trainer, like no one ever was, so you set out to catch pokemons.
Define a class Trainer and a class Pokemon. The trainer has a name, a number of badges,
and a collection of pokemon. Pokemon has a name, an element, and health, all values are mandatory.
Every Trainer starts with 0 badges.
From the console you will receive an unknown number of lines until you receive the command "Tournament",
each line will carry information about a pokemon and the trainer who caught it in the format
"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}" where TrainerName is the name of
the Trainer who caught the pokemon, names are unique there cannot be 2 trainers with the same name.
After receiving the command "Tournament" an unknown number of lines containing one of
three elements "Fire", "Water", and "Electricity" will follow until the command "End" is received.
For every command you must check if a trainer has at least 1 pokemon with the given element,
if he does he receives 1 badge, otherwise, all his pokemon lose 10 health, if a pokemon falls
to 0 or less health he dies and must be deleted from the trainer’s collection.
After the command "End" is received you should print all trainers sorted by the amount of badges they have
in descending order (if two trainers have the same amount of badges they should be sorted by order of appearance
in the input) in the format "{TrainerName} {Badges} {NumberOfPokemon}".


Examples
Input	                                                            Output
Peter Charizard Fire 100
George Squirtle Water 38
Peter Pikachu Electricity 10
Tournament
Fire
Electricity
End	                                                                Peter 2 2
                                                                    George 0 1

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        List<Pokemon> pokemons = new ArrayList<>();

        String[] line = scanner.nextLine().split("\\s+");
        while (!line[0].equals("Tournament")) {

            String currentTrainerName = line[0];
            String currentPokemonName = line[1];
            String currentPokemonElement = line[2];
            int pokemonHealth = Integer.parseInt(line[3]);

            Pokemon pokemon = new Pokemon(currentPokemonName, currentPokemonElement, pokemonHealth);
            trainers.putIfAbsent(currentTrainerName, new Trainer(currentTrainerName, new ArrayList<>()));
            trainers.get(currentTrainerName).getPokemons().add(pokemon);


            line = scanner.nextLine().split(" ");
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String currentElement = command;
            trainers.values().forEach(t -> t.handleTournament(currentElement));

            command = scanner.nextLine();
        }


        trainers.values().stream().sorted(Comparator.comparing(Trainer::getNumOfBadges).reversed()).forEach(System.out::println);
    }
}
