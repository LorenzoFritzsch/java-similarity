package com.lorenzofritzsch.similarity.cosine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TermFrequencyVectorGenerator {

    /**
     * Generates a term-frequency vector, representing the frequency of terms in the provided text.
     */
    public static List<Integer> generate(List<String> terms, List<String> text) {
        List<Integer> termFrequencyVector = new ArrayList<>(terms.size());
        for (String term : terms) {
            if (text.contains(term)) {
                termFrequencyVector.addLast(Collections.frequency(text, term));
            } else {
                termFrequencyVector.addLast(0);
            }
        }
        return termFrequencyVector;
    }
}
