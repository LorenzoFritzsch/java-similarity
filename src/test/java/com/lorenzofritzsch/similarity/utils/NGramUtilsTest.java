package com.lorenzofritzsch.similarity.utils;

import com.lorenzofritzsch.similarity.exception.NGramValueException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NGramUtilsTest {

    @Test
    void itShouldSplitInNGrams() {
        // Given
        String term = "This is a test";
        int n = 3;

        // When
        List<String> nGrams = NGramUtils.nGram(term, n);

        // Then
        List<String> expected = List.of("Thi", "his", "is ", "s i", " is", "is ", "s a", " a ", "a t", " te", "tes", "est");
        assertEquals(expected, nGrams);
    }

    @Test
    void itShouldSplitInWords() {
        // Given
        String term = "This is a test";
        int n = 0;

        // When
        List<String> nGrams = NGramUtils.nGram(term, n);

        // Then
        List<String> expected = List.of("This", "is", "a", "test");
        assertEquals(expected, nGrams);
    }

    @Test
    void itShouldThrowNGramValueException() {
        // Given
        String term = "test";
        int n = 5;

        // When - n is larger than the term's length

        // Then
        assertThrows(NGramValueException.class, () -> NGramUtils.nGram(term, n));
    }
}
