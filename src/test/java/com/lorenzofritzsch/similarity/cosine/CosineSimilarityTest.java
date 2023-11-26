package com.lorenzofritzsch.similarity.cosine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CosineSimilarityTest {

    @Test
    void itShouldComputeCosineSimilarity() {
        // Given
        String text0 = "This is a test";
        String text1 = "But this is a test";

        // When
        double cosineSimilarity = CosineSimilarity.compute(text0, text1, 3);

        // Then - as text0 and text1 are very similar, the similarity should be >= 0.9
        assertTrue(cosineSimilarity >= 0.9);
    }
}
