# java-similarity
A Java library offering similarity algorithms.

---

## Algorithms & usages
### <u>Cosine similarity</u>
It's possible to perform a cosine similarity on two texts using the `CosineSimilarity` class:

```java
import com.lorenzofritzsch.similarity.cosine.CosineSimilarity;

class Example {

    public void cosineSimilarityExample() {
        String text0 = "Some text";
        String text1 = "Some other text";
        int nGram = 3;

        double cosineSimilarity = CosineSimilarity.compute(text0, text1, nGram);
    }
}
```
Note that the `compute` method requires a `nGram` parameter. This parameter specifies the size of each [n-gram](https://en.wikipedia.org/wiki/N-gram), 
allowing for a more precise calculation of the similarity. 
For instance, the string "Some text" with `nGram` set to 3 will be split into the following list:
```
["Som", "ome", "me ", "e t", " te", "tex", "ext"]
```
allowing for a more granular check. However, you can set `nGram` to 0 and the cosine similarity will be performed word-for-word.

The `CosineSimilarity` class also offers a method for performing similarities on a large number of texts:

```java
import com.lorenzofritzsch.similarity.cosine.CosineSimilarity;

import java.util.List;
import java.util.concurrent.Future;

class Example {

    public void cosineSimilarityExample() {
        String terms = "Some text";
        String texts = List.of("...");
        int nGram = 3;

        Map<String, Future<Double>> similarities = CosineSimilarity.compute(terms, texts, nGram);
    }
}
```
Under the hood, the `CosineSimilarity#compute` method computes the similarity between each text in `texts` and `terms`
in a dedicated virtual thread, and stores the result in a `Future`, which is the value of the returned `Map`, while the 
key is the text the similarity was performed on.

### <u>Levenshtein distance</u>
Use the `LevenshteinDistance` class to calculate the Levenshtein distance between two string:

```java

import com.lorenzofritzsch.similarity.levenshtein.LevenshteinDistance;

class Example {

    public LevenshteinDistanceExample() {
        String a = "kitten";
        String b = "sitting";

        int levenshteinDistance = LevenshteinDistance.compute(a, b);
    }
}
```