package models;

public class PokemonBuilder {
    private final Pokemon pokemon = new Pokemon();

    public PokemonBuilder pokedexNumber(int pokedexNumber) {
        pokemon.setPokedexNumber(pokedexNumber);
        return this;
    }

    public PokemonBuilder name(String name) {
        pokemon.setName(name);
        return this;
    }

    public PokemonBuilder type1(String type1) {
        pokemon.setType1(type1);
        return this;
    }

    public PokemonBuilder type2(String type2) {
        pokemon.setType2(type2);
        return this;
    }

    public PokemonBuilder total(int total) {
        pokemon.setTotal(total);
        return this;
    }

    public PokemonBuilder hp(int hp) {
        pokemon.setHP(hp);
        return this;
    }

    public PokemonBuilder attack(int attack) {
        pokemon.setAttack(attack);
        return this;
    }

    public PokemonBuilder defense(int defense) {
        pokemon.setDefense(defense);
        return this;
    }

    public PokemonBuilder spAtk(int spAtk) {
        pokemon.setSpAtk(spAtk);
        return this;
    }

    public PokemonBuilder spDef(int spDef) {
        pokemon.setSpDef(spDef);
        return this;
    }

    public PokemonBuilder speed(int speed) {
        pokemon.setSpeed(speed);
        return this;
    }

    public PokemonBuilder generation(int generation) {
        pokemon.setGeneration(generation);
        return this;
    }

    public PokemonBuilder legendary(boolean legendary) {
        pokemon.setLegendary(legendary);
        return this;
    }

    public Pokemon build() {
        return pokemon;
    }

}
