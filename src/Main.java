import models.CsvReader;
import models.Pokemon;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String filePath = new File("").getAbsolutePath().concat("/pokemon.csv");
        List<Pokemon> pokedex = CsvReader.readCsvFile(filePath);

        // Total number of pokemons
        System.out.println("1) Number of pokemons: " + pokedex.size());

        // Total number of legendary pokemons
        System.out.println("2) Total of legendary pokemons: " + pokedex.stream().filter(Pokemon::isLegendary).count());

        // All fire pokemons
        System.out.println("3) All fire pokemons: " + pokedex.stream().filter((pokemon -> pokemon.getType1().equals("Fire"))).count());

        // Pokemon with the highest HP
        System.out.println("4) Pokemon with the highest HP: " + pokedex.stream().max(Comparator.comparingInt(Pokemon::getHP)).get());

        // Pokemon with the lowest attack
        System.out.println("5) Pokemon with the lowest attack: " + pokedex.stream().min(Comparator.comparingInt(Pokemon::getAttack)).get());

        // List of all dragon pokemons from generation 4
        System.out.println("6) List of all dragon pokemons from generation 4: " + pokedex.stream().filter((pokemon -> pokemon.getGeneration() == 4 && pokemon.getType1().equals("Dragon"))).toList());

        // Sum of speed of all flying pokemons
        Stream<Pokemon> flyingPokemons = pokedex.stream().filter((pokemon -> pokemon.getType1().equals("Flying")));
        System.out.println("7) Sum of speed of all flying pokemons: " + flyingPokemons.reduce(0, (acc, pokemon) -> acc + pokemon.getSpeed(), Integer::sum));

        // Random normal pokemon
        System.out.println("8) Random normal pokemon: " + pokedex.stream().filter(pokemon -> pokemon.getType1().equals("Normal")).findAny().get());

        // Is there a pokemon with the name 'Mega' in its name?
        System.out.println("9) Is there a pokemon with the name 'Mega' in its name? " + pokedex.stream().anyMatch(pokemon -> pokemon.getName().contains("Mega")));

        // Distinct pokemon types
        System.out.println("10) Distinct pokemon types: " + pokedex.stream().map(Pokemon::getType1).distinct().toList());

        // Sorted list of pokemons with less than 20 points of defense
        System.out.println("11) Sorted pokedex of pokemons with less defense: " + pokedex.stream().filter(pokemon -> pokemon.getDefense() < 20).sorted(Comparator.comparing(Pokemon::getName)).toList());

        // Number of pokemons in each generation
        System.out.println("12) Group by generation: " + pokedex.stream().collect(Collectors.groupingBy(Pokemon::getGeneration, Collectors.counting())));

        // Number of pokemons that don`t have type 2
        System.out.println("13)Number of pokemons that don`t have type 2: " + pokedex.stream().filter(pokemon -> pokemon.getType2() == null).count());

        // Upper case pokemon names that starts with 'Z'
        System.out.println("14) Upper case pokemon names that starts with 'Z': " + pokedex.stream().map(Pokemon::getName).filter(name -> name.startsWith("Z")).map(String::toUpperCase).toList());

        // Number of pokemons grouped by their type 1
        System.out.println("15) Number of pokemons grouped by their type 1: " + pokedex.stream().collect(Collectors.groupingBy(Pokemon::getType1, Collectors.counting())));

        // List of all fairy pokemons with type 2
        System.out.println("16)");

        pokedex.stream().filter(pokemon -> pokemon.getType1().equals("Fairy"))
                .peek(pokemon -> System.out.println("Type 2 is null"))
                .filter(pokemon -> pokemon.getType2() != null)
                .forEach(pokemon -> System.out.println(pokemon.getName() + " is a " + pokemon.getType1() + "-" + pokemon.getType2() + " pokemon!"));

    }
}