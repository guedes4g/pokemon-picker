package com.company.service;

import com.company.exception.IllegalDirectionInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PokemonPickerIntegrationTest {
    private PokemonPicker pokemonPicker;

    @BeforeEach
    public void init() {
        pokemonPicker = new PokemonPicker();
    }

    private static Stream<Arguments> providePickPokemonsTestCases() {
        return Stream.of(
                Arguments.of("", 1),
                Arguments.of("E", 2),
                Arguments.of("NESO", 4),
                Arguments.of("NSNSNSNSNS", 2),
                Arguments.of("S".repeat(10000), 10001),
                Arguments.of("S".repeat(100000), 100001),
                Arguments.of("SN".repeat(10000), 2),
                Arguments.of("SN".repeat(100000), 2));
    }

    @ParameterizedTest
    @MethodSource("providePickPokemonsTestCases")
    void pickPokemonsShouldReturnOne(String input, int expected) {
        int actual = this.pokemonPicker.pickPokemons(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> providePickPokemonsInvalidTestCases() {
        return Stream.of(
                Arguments.of(null, NullPointerException.class),
                Arguments.of(" ", IllegalDirectionInputException.class),
                Arguments.of("ns1", IllegalDirectionInputException.class));
    }

    @ParameterizedTest
    @MethodSource("providePickPokemonsInvalidTestCases")
    void pickPokemonsShouldThrowException(String input, Class<? extends Throwable> exceptionClass) {
        assertThrows(exceptionClass, () -> this.pokemonPicker.pickPokemons(input));
    }
}