package com.lorenzofritzsch.similarity.cosine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TermFrequencyVectorGeneratorTest {

    @Test
    void itShouldGenerateTermFrequencyVector() {
        // Given
        List<String> terms = List.of("a", "b", "c", " d", "e", "f and g");
        List<String> text = List.of("a", "b", "d", "f", "e", "z", "a", "c", "e");

        // When
        List<Integer> termFrequencyVector = TermFrequencyVectorGenerator.generate(terms, text);

        // Then
        List<Integer> expectedTFV = List.of(2, 1, 1, 0, 2, 0);
        assertEquals(expectedTFV, termFrequencyVector);
    }
}
