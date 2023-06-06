package org.example.coding.strings;

import java.util.*;

public class StringExercises {

    public HashMap<String, Integer> countWords2(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, "");
        input = input.replaceAll("\\s+", " ");
        String[] str = input.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : str) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        return map;
    }

    public HashMap<String, Integer> countWords(String input) {
        //input: Sunjay works at TELUS. TELUS is a telco company. (It is a good place to work.)
        String regex = "[^a-zA-Z0-9\\s]";
        int counter = 1;
        input = input.replaceAll(regex, "");
        String[] arr = input.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].equals(arr[j]))
                        counter++;
                }
                System.out.println(arr[i] + " " + counter);
                map.put(arr[i], counter);
                counter = 1;
            }
        }
        return map;
    }

    public Map<Character, Integer> findDuplicateCharacters3(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }
        return map;
    }

    public Map<Character, Integer> findDuplicateCharacters2(String input) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        count++;
                    }
                }
                map.put(chars[i], count);
                count = 1;
            }
        }
        return map;
    }

    public boolean checkIfPangram(String sentence) {
        sentence = sentence.trim();
        sentence = sentence.replace(" ", "");
        char[] chars = sentence.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        if (sentence.length() < 26) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], true);
            }
        }
        return map.size() == 26;
    }

    public boolean checkIfPangram2(String sentence) {
        sentence = sentence.trim();
        sentence = sentence.replace(" ", "");
        char[] chars = sentence.toCharArray();
        List<Character> list = new ArrayList<>();
        if (sentence.length() < 26) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (!list.contains(chars[i])) {
                list.add(chars[i]);
            }
        }
        return list.size() == 26;
    }

    public boolean checkIfPangram3(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0]; //prefix is the whole first letter.
        for (int i = 1; i < strs.length; i++)  //iterates three times over the array of strings.
            while (strs[i].indexOf(prefix) != 0) { //if word.indexOf(prefix) is 0 it means it is the same prefix for both words.
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public boolean validParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(input.charAt(i));
                    break;

                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public boolean validParentheses(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public int romanToInteger2(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                total -= map.get(s.charAt(i));
            } else {
                total += map.get(s.charAt(i));
            }
        }
        total += map.get(s.charAt(s.length() - 1));
        return total;
    }

    public int romanToInteger(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int counter = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ((i + 1 < chars.length) && (chars[i] == 'I' || chars[i] == 'X' || chars[i] == 'C')) {
                switch (chars[i]) {
                    case 'I':
                        if (chars[i + 1] == 'V') {
                            counter += 4;
                            if (i + 1 < chars.length) i++;
                        } else if (chars[i + 1] == 'X') {
                            counter += 9;
                            if (i + 1 < chars.length) i++;
                        } else {
                            counter += map.get(chars[i]);
                        }
                        break;

                    case 'X':
                        if (chars[i + 1] == 'L') {
                            counter += 40;
                            if (i + 1 < chars.length) i++;
                        } else if (chars[i + 1] == 'C') {
                            counter += 90;
                            if (i + 1 < chars.length) i++;
                        } else {
                            counter += map.get(chars[i]);
                        }
                        break;

                    case 'C':
                        if (chars[i + 1] == 'D') {
                            counter += 400;
                            if (i + 1 < chars.length) i++;
                        } else if (chars[i + 1] == 'M') {
                            counter += 900;
                            if (i + 1 < chars.length) i++;
                        } else {
                            counter += map.get(chars[i]);
                        }
                        break;
                }
            } else {
                counter += map.get(chars[i]);
            }
        }
        return counter;
    }

    public int countWords(String input, String word) {
        int count = 0;
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word))
                count++;
        }
        return count;
    }

    public long countSpecificWordsStream(String input, String word) {
        if ((Objects.nonNull(word) && !(" ").equals(word)) && (Objects.nonNull(input) && !(" ").equals(input))) {
            String[] sArray = input.split(" ");
            long l = Arrays.stream(sArray).filter(d -> d.equals(word)).count();
            System.out.println(word + " occur " + l + " times");
            return l;
        } else {
            System.out.println("Invalid string");
            return 0;
        }
    }

    public int countWordsWNoMethod(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, "");
        input = input.replaceAll("\\s+", " ");
        char[] chars = input.toCharArray();
        int counter = 1;

        for (char aChar : chars) {
            if (!Character.isLetter(aChar)) {
                counter++;
            }
        }
        return counter;
    }

    public int countWordsWNoMethod2(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        //sentence = "Hello              :,!!!!!  this is a sentence. Because I want to test this method.";
        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = input.length() - 1;
        char[] characters = input.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                isWord = false;
                wordCount++;
            } else if (Character.isLetter(characters[i]) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }


    public List<Character> findDuplicateChars(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() > 1)
                list.add(m.getKey());
        }
        return list;
//        char[] output = new char[list.size()];
//        for(int i=0; i<list.size(); i++){
//            output[i] = list.get(i);
//        }
//        return output;
    }

    public int countSubStr(String str, String substr) {
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        int i, mn = Integer.MAX_VALUE;
        int l1 = str.length();
        int l2 = substr.length();

        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (freq1.containsKey(c)) {

                freq1.put(c, freq1.get(c) + 1);
            } else {

                freq1.put(c, 1);
            }
        }

        for (int idx = 0; idx < substr.length(); idx++) {
            char c = substr.charAt(idx);
            if (freq2.containsKey(c)) {

                freq2.put(c, freq2.get(c) + 1);
            } else {

                freq2.put(c, 1);
            }
        }

        for (Map.Entry mapElement : freq2.entrySet()) {
            char first = (char) mapElement.getKey();
            int second = (int) mapElement.getValue();
            int second_f1 = freq1.get(first);
            mn = Math.min(mn, second_f1 / second);
        }

        return mn;
    }

    int findNumberOfTimes(String str1, String str2) {
        int freq[] = new int[26];
        int freq2[] = new int[26];

        int l1 = str1.length();

        // iterate and mark the frequencies of
        // all characters in str1
        for (int i = 0; i < l1; i++) {
            freq[str1.charAt(i) - 'a'] += 1;
        }
        int l2 = str2.length();
        for (int i = 0; i < l2; i++) {
            freq2[str2.charAt(i) - 'a'] += 1;
        }


        int count = Integer.MAX_VALUE;

        // find the minimum frequency of
        // every character in str1
        for (int i = 0; i < l2; i++) {
            if (freq2[str2.charAt(i) - 'a'] != 0)
                count = Math.min(count,
                        freq[str2.charAt(i) - 'a'] / freq2[str2.charAt(i) - 'a']);
        }

        return count;
    }

    static boolean canMakeStr2(String str1, String str2)
    {
        // Create a count array and count frequencies
        // characters in str1.
        int[] count = new int[Integer.MAX_VALUE];
        char []str3 = str1.toCharArray();
        for (int i = 0; i < str3.length; i++)
            count[str3[i]]++;

        // Now traverse through str2 to check
        // if every character has enough counts

        char []str4 = str2.toCharArray();
        for (int i = 0; i < str4.length; i++) {
            if (count[str4[i]] == 0)
                return false;
            count[str4[i]]--;
        }
        return true;
    }

    public int countEqualStrings(String a, String b) {
        // Java program to print the number of times
        // str2 can be formed from str1 using the
        // characters of str1 only once
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int charsNumber = 0;
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i), map.get(b.charAt(i)) + 1);
            } else {
                map.put(b.charAt(i), 1);
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                charsNumber++;
                if (count == 0 || map.get(a.charAt(i)) < count) {
                    count = map.get(a.charAt(i));
                    if (map.get(a.charAt(i)) > 1) {
                        map.put(a.charAt(i), map.get(a.charAt(i)) - 1);
                    } else {
                        map.remove(a.charAt(i));
                    }
                }
            }
        }
        return charsNumber == a.length() ? count : 0;
    }

    public int firstUniqChar(String input) {
        ///dddccdbba
        //more memoty than below's solutions due to linkedhashmap.
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return input.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public int firstUniqueChar(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if (map.get(input.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    public char findFirstNonRepeatedChar(String input) {
        //O(2*n)
        //O(n^2)
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
        }

        //map.g
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '\u0000';
    }

    public char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) == 0) {
                    map.remove(t.charAt(i));
                }
            } else {
                return false;
            }
        }
        return map.size()==0;
    }

    public boolean iAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);

        return Arrays.equals(charFromWord, charFromAnagram);
    }
}
