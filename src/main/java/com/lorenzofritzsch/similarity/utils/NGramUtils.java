package com.lorenzofritzsch.similarity.utils;

import com.lorenzofritzsch.similarity.exception.NGramValueException;

import java.util.ArrayList;
import java.util.List;

public abstract class NGramUtils {

    public static List<String> nGram(String term, int n) {
        if (n < 0) {
            throw new NGramValueException("Invalid n-gram value: n must be >= 0, but is " + n);
        } else if (n == 0) {
            return List.of(term.split(" "));
        } else if (n > term.length()) {
            throw new NGramValueException("N-gram value cannot be larger than the term's length");
        }

        int nGramSize = term.length() - n + 1;
        List<String> nGram = new ArrayList<>(nGramSize);
        for (int i = 0; i < nGramSize; i++) {
            nGram.add(term.substring(i, i + n));
        }
        return nGram;
    }
}
