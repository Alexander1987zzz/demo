package com.task.algoritms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentWord {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>(freq.keySet());
        Collections.sort(result, (a, b) -> freq.get(b).compareTo(freq.get(a)) == 0 ? a.compareTo(b) : freq.get(b).compareTo(freq.get(a)));

        return result.subList(0, k);
    }

    public static void main(String[] args) {

    }
}
