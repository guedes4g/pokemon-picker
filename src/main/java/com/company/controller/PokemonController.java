package com.company.controller;


import com.company.exception.IllegalDirectionInputException;
import com.company.service.PokemonPicker;

import java.util.Scanner;

public class PokemonController {
    PokemonPicker pokemonPicker;

    public PokemonController() {
        this.pokemonPicker = new PokemonPicker();
    }

    public void pickPokemon() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide Ash's path:");
        String path = scanner.nextLine();
        try {
            System.out.println(pokemonPicker.pickPokemons(path));
        } catch (IllegalDirectionInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
