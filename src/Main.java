import models.CsvReader;
import models.Pokemon;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = new File("").getAbsolutePath().concat("/pokemon.csv");
        List<Pokemon> pokedex = CsvReader.readCsvFile(filePath);

        // Number of pokemons
        System.out.println("Number of pokemons: " + pokedex.size());

        // Total of legendary pokemons
        System.out.println("Total of legendary pokemons: " + pokedex.stream().filter(Pokemon::isLegendary).count());

        // Pokemon with the highest HP
        System.out.println("Pokemon with the highest HP: " + pokedex.stream().max(Comparator.comparingInt(Pokemon::getHP)).get());
    }
}