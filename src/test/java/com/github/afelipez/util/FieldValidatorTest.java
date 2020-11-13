package com.github.afelipez.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FieldValidatorTest {

    @Test
    public void shouldReturnString_whenCheckIsAllLetter() {
        assertEquals("Jean", FieldValidator.checkIsAllLetter("Jean"));
    }

    @Test
    public void shouldThrowIAE_whenCheckIsAllLetterContainsSpecialCaracter() {
        assertThrows(IllegalArgumentException.class,
                () -> FieldValidator.checkIsAllLetter("J{ea!n"));
    }

    @Test
    public void shouldThrowIAE_whenCheckIsAllLetterContainsNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> FieldValidator.checkIsAllLetter("J1e2an3"));
    }

}
