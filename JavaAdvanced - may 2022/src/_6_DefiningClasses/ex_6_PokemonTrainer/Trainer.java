package _6_DefiningClasses.ex_6_PokemonTrainer;

import java.util.List;


public class Trainer {
    private String name;
    private int numOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.numOfBadges = 0;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public boolean elementCheck(String element) {
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }


    public void handleTournament(String element) {
        if (elementCheck(element)) {
            this.numOfBadges++;
        } else {
            this.pokemons.forEach(Pokemon::takeDmg);
            this.pokemons.removeIf(Pokemon::deathCheck);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public void setNumOfBadges(int numOfBadges) {
        this.numOfBadges = numOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.name,this.numOfBadges,this.pokemons.size());
    }
}
