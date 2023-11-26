package com.lorenzofritzsch.similarity.utils;

import com.lorenzofritzsch.similarity.exception.AlgebraicException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlgebraUtilsTest {

    @Test
    void itShouldComputeEuclideanNorm() {
        // Given
        List<Integer> vector = List.of(5, 3, 9, 12, 0, 1, 0);

        // When
        double norm = AlgebraUtils.computeEuclideanNorm(vector);

        // Then
        double expectedNorm = Math.sqrt(260);
        assertEquals(expectedNorm, norm);
    }

    @Test
    void itShouldPerformColumnAndRowMultiplication() {
        // Given
        List<Integer> column = List.of(7, 4, 2, 15);
        List<Integer> row = List.of(12, 5, 3, 8);

        // When
        long result = AlgebraUtils.columnAndRowMultiplication(column, row);

        // Then
        long expected = 230;
        assertEquals(expected, result);
    }

    @Test
    void itShouldThrowAlgebraicException() {
        // Given
        List<Integer> column = List.of(2, 3, 5);
        List<Integer> row = List.of(2, 3);

        // When - a multiplication is performed

        // Then
        assertThrows(AlgebraicException.class, () -> AlgebraUtils.columnAndRowMultiplication(column, row));
    }
}
