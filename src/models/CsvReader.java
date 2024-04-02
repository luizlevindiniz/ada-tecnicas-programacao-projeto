package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public static void printCsvFile(String pathname) {
        String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(pathname))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Pokemon> readCsvFile(String pathname) {
        List<Pokemon> pokedex = null;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(pathname))) {
            pokedex = br.lines().skip(1).map(CsvReader::createPokemon).toList();

        } catch (Exception e) {
            System.out.println(e);
        }
        return pokedex;
    }

    public static Pokemon createPokemon(String line) {
        String[] fields = line.split(",");

        int pokedexNumber = Integer.parseInt(fields[0]);
        String name = fields[1];
        String type1 = fields[2];
        String type2 = fields[3];
        int total = Integer.parseInt(fields[4]);
        int HP = Integer.parseInt(fields[5]);
        int attack = Integer.parseInt(fields[6]);
        int defense = Integer.parseInt(fields[7]);
        int spAtk = Integer.parseInt(fields[8]);
        int spDef = Integer.parseInt(fields[9]);
        int speed = Integer.parseInt(fields[10]);
        int generation = Integer.parseInt(fields[11]);
        boolean isLegendary = Boolean.parseBoolean(fields[12]);

        type2 = type2.isEmpty() ? null : type2; // pokemon type 2 is not mandatory

        return new PokemonBuilder().pokedexNumber(pokedexNumber).name(name).type1(type1).type2(type2)
                .total(total).hp(HP).attack(attack).defense(defense).spAtk(spAtk)
                .spDef(spDef).speed(speed).generation(generation).legendary(isLegendary).build();
    }


}
