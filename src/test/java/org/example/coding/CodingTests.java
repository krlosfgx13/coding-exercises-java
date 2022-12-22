package org.example.coding;

import org.example.coding.practice.Practice;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.collection.IsMapContaining;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CodingTests {

    Practice practice = new Practice();

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{0, 1}, practice.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, practice.twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertArrayEquals(new int[]{0, 1}, practice.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void testFindErrorNums() {
        Assert.assertArrayEquals(new int[]{2, 1}, practice.findErrorNumbers(new int[]{3, 2, 2}));
        Assert.assertArrayEquals(new int[]{2, 1}, practice.findErrorNumbers(new int[]{2, 2}));
        Assert.assertArrayEquals(new int[]{2, 3}, practice.findErrorNumbers(new int[]{1, 2, 2, 4}));
        Assert.assertArrayEquals(new int[]{1, 2}, practice.findErrorNumbers(new int[]{1, 1}));
    }

    @Test
    public void testFindDuplicates() {
        Assert.assertArrayEquals(new int[]{0}, practice.findDuplicates(new int[]{0, 0, 0, 1}));
        Assert.assertArrayEquals(new int[]{}, practice.findDuplicates(new int[]{1, 2, 3, 4, 5}));
        Assert.assertArrayEquals(new int[]{2, 4, 8}, practice.findDuplicates(new int[]{2, 2, 800, 4, 8, 8, 1, 8, 4, 0}));
        Assert.assertArrayEquals(new int[]{1}, practice.findDuplicates(new int[]{1, 1, 1, 1, 1, 11, 0}));
    }

    @Test
    public void testCountWordsArray() {
        Assert.assertEquals(5, practice.countWordsArray("Hola como estas tu hoy"));
        Assert.assertEquals(0, practice.countWordsArray("           "));
        Assert.assertEquals(2, practice.countWordsArray("Hola           mundo"));
        Assert.assertEquals(0, practice.countWordsArray("!@#$#@$@$@#$@#$@#$@@#$@#$      "));
    }

    @Test
    public void testAssertMap() {
        Map<String, String> map = new HashMap<>();
        map.put("j", "java");
        map.put("c", "c++");
        map.put("p", "python");
        map.put("n", "node");

        Map<String, String> expected = new HashMap<>();
        expected.put("n", "node");
        expected.put("c", "c++");
        expected.put("j", "java");
        expected.put("p", "python");

        //All passed / true
        //1. Test equal, ignore order
        assertThat(map, is(expected));

        //2. Test size
        assertThat(map.size(), is(4));

        //3. Test map entry, best!
        assertThat(map, IsMapContaining.hasEntry("n", "node"));

        assertThat(map, not(IsMapContaining.hasEntry("r", "ruby")));

        //4. Test map key
        assertThat(map, IsMapContaining.hasKey("j"));

        //5. Test map value
        assertThat(map, IsMapContaining.hasValue("node"));
    }

    @Test
    public void testCountWordOccurrences() {
        String input = "Sunjay works at TELUS. TELUS is a telco company. TELUS is a good place to work.";
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Sunjay", 1);
        map.put("works", 1);
        map.put("at", 1);
        map.put("TELUS", 3);
        map.put("is", 2);
        map.put("a", 2);
        map.put("good", 1);
        map.put("place", 1);
        map.put("to", 1);
        map.put("work", 1);
        map.put("telco", 1);
        map.put("company", 1);

        Assert.assertEquals(map, practice.countWordOccurrences(input));
    }

    @Test
    public void testCheckIfSentenceIsPangram() {
        Assert.assertTrue(practice.checkIfSentenceIsPangram("thequickbrownfoxjumpsoverthelazydog"));
        Assert.assertFalse(practice.checkIfSentenceIsPangram("thequickbrownfoxjumpsoverthelazydo"));
        Assert.assertTrue(practice.checkIfSentenceIsPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(practice.isPalindromeV2("A man, a plan, a canal: Panama"));
        Assert.assertFalse(practice.isPalindromeV2("race a car"));
        Assert.assertTrue(practice.isPalindromeV2(" "));
        Assert.assertTrue(practice.isPalindromeV2("Mr. Owl ate my metal worm"));
        Assert.assertTrue(practice.isPalindromeV2("Was it a car or a cat I saw"));
    }

    @Test
    public void testValidPalindrome() {
        Assert.assertTrue(practice.validPalindromeWord("abccba"));
        Assert.assertTrue(practice.validPalindromeWord("abcdcba"));
        Assert.assertTrue(practice.validPalindromeWord("abcdecba"));
        Assert.assertTrue(practice.validPalindromeWord("cbbcc"));
        Assert.assertTrue(practice.validPalindromeWord("ccbbc"));
    }

    @Test
    public void testValidParentheses() {
        Assert.assertTrue(practice.validParentheses("{[[()]]}"));
        Assert.assertFalse(practice.validParentheses("{"));
        Assert.assertTrue(practice.validParentheses("{[]}"));
        Assert.assertTrue(practice.validParentheses("{[()]}"));
        Assert.assertFalse(practice.validParentheses("{[}]"));
        Assert.assertFalse(practice.validParentheses("{]"));
    }

    @Test
    public void testIsAnagram(){
        Assert.assertTrue(practice.isAnagram("anagram", "nagaram"));

    }
}
