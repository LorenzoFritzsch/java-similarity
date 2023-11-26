package com.lorenzofritzsch.similarity.cosine;

import com.lorenzofritzsch.similarity.utils.AlgebraUtils;
import com.lorenzofritzsch.similarity.utils.NGramUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CosineSimilarity {

    /**
     * Computes cosine similarity on two provided texts.
     *
     * @param text0
     * @param text1
     * @param nGram If set to 0, the n-gram optimization won't be used.
     * @return The cosine similarity value with range [0, 1].
     */
    public static double compute(String text0, String text1, int nGram) {
        List<String> text0NGrams = NGramUtils.nGram(text0, nGram);
        List<String> text1NGrams = NGramUtils.nGram(text1, nGram);

        List<Integer> text0TermFrequencyVector = TermFrequencyVectorGenerator.generate(text0NGrams, text0NGrams);
        List<Integer> text1TermFrequencyVector = TermFrequencyVectorGenerator.generate(text0NGrams, text1NGrams);

        double tfv0Norm = AlgebraUtils.computeEuclideanNorm(text0TermFrequencyVector);
        double tfv1Norm = AlgebraUtils.computeEuclideanNorm(text1TermFrequencyVector);

        return AlgebraUtils.columnAndRowMultiplication(text0TermFrequencyVector, text1TermFrequencyVector) /
                (tfv0Norm * tfv1Norm);
    }

    /**
     * Computes cosine similarity between the provided texts and terms.
     * <p>
     * Each similarity is calculated in a dedicated virtual thread and the similarity's value is stored as a <code>Future</code> in the returned <code>Map</code>,
     * where the key is the text and the value is the <code>Future</code>.
     * </p>
     *
     * @param terms
     * @param texts
     * @param nGram If set to 0, the n-gram optimization won't be used.
     * @return The future value of the cosine similarity of texts.
     */
    public static Map<String, Future<Double>> compute(String terms, List<String> texts, int nGram) {
        Map<String, Future<Double>> result = new HashMap<>(texts.size());
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String text : texts) {
                Future<Double> futureResult = executorService.submit(() -> compute(terms, text, nGram));
                result.put(text, futureResult);
            }
        }
        return result;
    }
}
