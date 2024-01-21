package ru.nkashlev.frequencycalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@SpringBootTest
class FrequencyServiceTest {

    FrequencyService frequencyService = new FrequencyService();

    @Test
    public void testSingleCharacter() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        Assertions.assertEquals(map, frequencyService.calculateFrequency("a"));
    }

    @Test
    public void testMultipleCharacters() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 3);
        map.put('b', 3);
        map.put('c', 1);
        Assertions.assertEquals(map, frequencyService.calculateFrequency("aabbbac"));
    }

    @Test
    public void testAllCharactersUnique() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 1);
        Assertions.assertEquals(map, frequencyService.calculateFrequency("abc"));
    }

    @Test
    public void testAllCharactersSame() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        Assertions.assertEquals(map, frequencyService.calculateFrequency("aaaaa"));
    }

    @Test
    public void testDifferentCharacters() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 2);
        Map<Character, Integer> actual = frequencyService.calculateFrequency("aabb");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testOrderDesc() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('c', 3);
        expected.put('b', 2);
        expected.put('a', 2);
        Map<Character, Integer> actual = frequencyService.calculateFrequency("ccabcab");
        Assertions.assertEquals(expected, actual);
    }

}