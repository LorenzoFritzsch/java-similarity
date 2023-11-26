package com.lorenzofritzsch.similarity.utils;

import com.lorenzofritzsch.similarity.exception.AlgebraicException;

import java.util.List;

public abstract class AlgebraUtils {

    public static double computeEuclideanNorm(List<Integer> vector) {
        long quadraticForm = 0;
        for (int i : vector) {
            quadraticForm += (long) Math.pow(i, 2);
        }
        return Math.sqrt(quadraticForm);
    }

    public static long columnAndRowMultiplication(List<Integer> column, List<Integer> row) {
        if (column.size() != row.size()) {
            throw new AlgebraicException("Sizes of column and row do not match");
        }

        long result = 0;
        for (int i = 0; i < column.size(); i++) {
            result += (long) column.get(i) * row.get(i);
        }
        return result;
    }
}
