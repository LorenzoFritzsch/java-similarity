package com.lorenzofritzsch.similarity.levenshtein;

import static com.lorenzofritzsch.similarity.utils.StringUtils.head;
import static com.lorenzofritzsch.similarity.utils.StringUtils.tail;

public class LevenshteinDistance {

    public static int compute(String a, String b) {
        if (a.isEmpty()) {
            return b.length();
        }
        if (b.isEmpty()) {
            return a.length();
        }
        if (head(a).equals(head(b))) {
            return compute(tail(a), tail(b));
        } else {
            return 1 + Math.min(
                    compute(tail(a), b),
                    Math.min(
                            compute(a, tail(b)),
                            compute(tail(a), tail(b))
                    )
            );
        }
    }
}
