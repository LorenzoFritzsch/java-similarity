package com.lorenzofritzsch.similarity.levenshtein;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevenshteinDistanceTest {

    @Test
    void itShouldCalculateDistance() {
        // Given
        String a = "kitten";
        String b = "sitting";

        // When
        int distance = LevenshteinDistance.compute(a, b);

        // Then
        assertEquals(3, distance);
    }

    @Test
    void itShouldCalculateDistanceWithEmptyString() {
        // Given
        String a = "kitten";
        String b = "";

        // When
        int distance = LevenshteinDistance.compute(a, b);

        // Then
        assertEquals(a.length(), distance);
    }
}
