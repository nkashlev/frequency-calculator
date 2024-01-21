package ru.nkashlev.frequencycalculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FrequencyService {
    private final Logger LOGGER = LoggerFactory.getLogger(FrequencyService.class);
    public Map<Character, Integer> calculateFrequency(String requestString) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : requestString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedFrequencyList = new ArrayList<>(frequencyMap.entrySet());
        sortedFrequencyList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<Character, Integer> result = new LinkedHashMap<>();

        for (Map.Entry<Character, Integer> entry : sortedFrequencyList) {
            result.put(entry.getKey(), entry.getValue());
        }
        LOGGER.info("Returned map {} ", result);
        return result;
    }
}
