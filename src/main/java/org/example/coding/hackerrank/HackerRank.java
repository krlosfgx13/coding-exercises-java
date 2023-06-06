package org.example.coding.hackerrank;

import java.util.*;

public class HackerRank {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float greater=0;
        float less=0;
        float zero=0;
        for(int i : arr){
            if(i > 0){
                greater++;
            }else if(i < 0){
                less++;
            }else if(i == 0){
                zero++;
            }
        }
        //float result = greater/arr.size();
        System.out.printf("%.6f \n", greater/arr.size());
        System.out.printf("%.6f \n", less/arr.size());
        System.out.printf("%.6f \n", zero/arr.size());
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        int index = 0;
        for (int i = 0; i < arr.size(); i++) {
            for(int j=0; j<arr.size(); j++){
                if (index != j) {
                    sum += arr.get(j);
                }
            }
            if(sum < min){
                min = sum;
            }
            if(sum > max){
                max = sum;
            }
            sum = 0;
            index++;
        }
        System.out.println(min + " " + max);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int noOfCandles = 0;
        int tallest = 0;
        for (int val : candles) {
            if (val > tallest) {
                tallest = val;
            }
        }

        for (Integer candle : candles) {
            if (candle == tallest) {
                noOfCandles++;
            }
        }
        return noOfCandles;
    }

    public static String timeConversion(String s) {
        // Write your code here
        String val = s.substring(0, 2);
        String newVal = "";
        if (s.contains("PM")) {
            switch (val) {
                case "12":
                    newVal = "12";
                    break;

                case "01":
                    newVal = "13";
                    break;

                case "02":
                    newVal = "14";
                    break;

                case "03":
                    newVal = "15";
                    break;

                case "04":
                    newVal = "16";
                    break;

                case "05":
                    newVal = "17";
                    break;

                case "06":
                    newVal = "18";
                    break;

                case "07":
                    newVal = "19";
                    break;

                case "08":
                    newVal = "20";
                    break;

                case "09":
                    newVal = "21";
                    break;

                case "10":
                    newVal = "22";
                    break;

                case "11":
                    newVal = "23";
                    break;
            }
        } else if (s.contains("AM")) {
            if ("12".equals(val)) {
                newVal = "00";
            }
        }

        s = !newVal.equals("") ? s.replace(val, newVal) : s;
        return s.substring(0, 8);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (int val : grades) {
            if (val < 38) {
                list.add(val);
            } else if ((val + 1) % 5 == 0) {
                list.add(val + 1);
            } else if ((val + 2) % 5 == 0) {
                list.add((val + 2));
            } else {
                list.add(val);
            }
        }
        return list;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int val : ar) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairs += entry.getValue() / 2;
        }
        return pairs;
    }

    public static String superReducedString(String s) {
        // Write your code here
        //Character[] c = chars;
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == chars.get(i + 1)) {
                chars.remove(chars.get(i));
                chars.remove(chars.get(i + 1));
            }
        }
        return chars.toString();
    }

    //This one!
    public static String superReducedStringStack(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) return "Empty String";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static int camelcase(String s) {
        // Write your code here
        String pattern = "[A-Z]";
        int counter = 1;
        for (Character c : s.toCharArray()) {
            if (c.toString().matches(pattern)) {
                counter++;
            }
        }
        return counter;
    }

    public static int camelCase2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'Z')
                count++;
        }
        return count + 1;
    }

    public static String pangrams(String s) {
        String pattern = "";
        s = s.toLowerCase();
        s = s.replace(" ", "");
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26 ? "pangram" : "not pangram";
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String lowerCase = "(.*[a-z].*)";
        String upperCase = "(.*[A-Z].*)";
        String numbers = "(.*[0-9].*)";
        String specialCharacters = "(.*[!@#$%^&*()[-]+].*)";
        int count = 0;

        if (!password.matches(lowerCase)) {
            count++;
        }
        if (!password.matches(upperCase)) {
            count++;
        }
        if (!password.matches(numbers)) {
            count++;
        }
        if (!password.matches(specialCharacters)) {
            count++;
        }
        if (password.length() + count < 6) {
            count += 6 - (password.length() + count);
        }
        return count;
    }

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        char c = '\0';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;

                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return "NO";
                    break;

                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return "NO";
                    break;

                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        return "NO";
                    break;
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean matchingParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        char c = '\0';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;

                case ')':
                    if (!stack.isEmpty() && stack.pop() != '(')
                        return false;
                    break;

                case ']':
                    if (!stack.isEmpty() && stack.pop() != '[')
                        return false;
                    break;

                case '}':
                    if (!stack.isEmpty() && stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    private static Map<String, Integer> mostRepeatedWord(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        //String pattern = "[^a-zA-Z0-9\\s]";
        String pattern = "[^a-zA-Z0-9\\s]";
        sentence = sentence.replaceAll("\\s+", " ");
        sentence = sentence.replaceAll(pattern, "");
        System.out.println(sentence);
        String[] strings = sentence.split(" ");
        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }
        return map;
    }

    private static Map<String, Integer> mostRepeatedWordsSorted(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        String pattern = "[^a-zA-Z0-9\\s]";
        sentence = sentence.replaceAll("\\s+", " ");
        sentence = sentence.replaceAll(pattern, "");
        System.out.println(sentence);
        String[] strings = sentence.split(" ");
        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }

        //Sort the results.
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry);
        }

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        for(Map.Entry<String, Integer> val : list){
            sortedMap.put(val.getKey(), val.getValue());
        }

        return sortedMap;
    }

    private static boolean checkIfPalindrome(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll("\\s+", "");
        input = input.replaceAll(pattern, "");
        input = input.toLowerCase();
        char[] c = new char[input.length()];
        int index = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            c[index] = input.charAt(i);
            index++;
        }
        return Arrays.equals(c, input.toCharArray());
    }

    public boolean isPalindrome(String input) {
        String pattern = "[^a-zA-Z0-9]";
        input = input.replaceAll(pattern, "");
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString().equals(input);
    }

    private static boolean checkIfPalindrome2(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        //input.re
        return false;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            }
        }
        return map.isEmpty();
    }

    private static boolean isAnagram2(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        ;
        return Arrays.equals(c1, c2);
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int output = 0;
        //Populate stacks.
        for (int i = h1.size() - 1; i >= 0; i--) {
            stack1.push(h1.get(i));
            sum1 += h1.get(i);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            stack2.push(h2.get(i));
            sum2 += h2.get(i);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            stack3.push(h3.get(i));
            sum3 += h3.get(i);
        }

        //Start popping.
        int min = 0;
        while (sum1 != sum2 || sum2 != sum3) {
            min = Math.min(sum1, Math.min(sum2, sum3));
            if (sum1 > min) {
                sum1 -= stack1.pop();
            }
            if (sum2 > min) {
                sum2 -= stack2.pop();
            }
            if (sum3 > min) {
                sum3 -= stack3.pop();
            }
        }
        return sum1;
    }

    public static int equalStacks2(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            s1.push(h1.get(i));
            sum1 += h1.get(i);

        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            s2.push(h2.get(i));
            sum2 += h2.get(i);

        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            s3.push(h3.get(i));
            sum3 += h3.get(i);
        }
        int min = Integer.MIN_VALUE;
        while (sum1 != sum2 || sum2 != sum3) {
            min = Math.min(sum1, Math.min(sum2, sum3));
            if (sum1 > min) {
                sum1 = sum1 - s1.pop();
            }
            if (sum2 > min) {
                sum2 = sum2 - s2.pop();
            }
            if (sum3 > min) {
                sum3 = sum3 - s3.pop();
            }
        }
        return sum1;
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = a.size() - 1; i >= 0; i--) {
            stack1.push(a.get(i));
        }

        for (int i = b.size() - 1; i >= 0; i--) {
            stack2.push(b.get(i));
        }

        int sum = 0;
        int max = 10;
        int selection;
        Random random = new Random();
        int turns = 0;
        //stack
        while (sum < max - 1) {
            selection = random.nextInt(3);
            if (selection == 1) {
                if (sum + stack1.peek() < max) {
                    sum += stack1.pop();
                    turns++;
                }
            } else if (selection == 2) {
                if (sum + stack2.peek() < max) {
                    sum += stack2.pop();
                    turns++;
                }
            }
        }
        return turns;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here


        return 0;
    }

    //-----------------------------------------------------------------------------------------------------------------
    /*
     * Practice from sample coding problems.
     * */

    //Print duplicate characters from a String
    //Time: O(n+m)
    //Space: (O(n) since I'm using other data structures to save values.
    private static List<Character> printDuplicateCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> chars = new ArrayList<>();
        String regex = "^a-zA-Z0-9\\s";
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                chars.add(entry.getKey());
            }
        }
        return chars;
    }

    //Check if two words are anagrams of each other.
    //Time: O(n+m)
    //Space: (O(n) since I'm using other data structures to save values.
    private static boolean areWordsAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        if (s1.length() != s2.length()) {
            return false;
        }
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (Character c : s1.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Character c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return map.isEmpty();
    }

    //Print the first non-repeated character from String
    //Time Complexity: O(n) since there are two for loops but traverse independently, so o(n+m) = O(n).
    //Space Complexity: O(n) since there are more than one data structure and either map or list can grow, not are fixed size.
    private static char firstNonRepeatedCharacter(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '\0';
    }

    //Reverse a string recursively
    public static String reverseRecursively(String str) {
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //Check if a string contains only digits.
    private static boolean onlyDigits(String s) {
        String regex = "\\d+";
        return s.matches(regex);
    }

    private static void vowelsAndConsonants(String s) {
        String regex = "[aeiou]";
        int countVowels = 0;
        int countConsonants = 0;
        for (Character c : s.toCharArray()) {
            if (c.toString().matches(regex))
                countVowels++;
            else
                countConsonants++;
        }
        System.out.println("Vowels: " + countVowels);
        System.out.println("Consonants: " + countConsonants);
    }

    private static int countCharOccurrences(String str, char c) {
        str = str.toLowerCase();
        int counter = 0;
        for (Character ch : str.toCharArray()) {
            if (ch == c) {
                counter++;
            }
        }
        return counter;
    }

    private static String reverseWords(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static boolean checkRotatation(String original, String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }

        String concatenated = original + original;

        return concatenated.contains(rotation);
        /*
        Output
        Please enter original String
        IndiaVsAustralia
        Please enter rotation of String
        AustraliaVsIndia
        Sorry, they are not the rotation of another

        Please enter original String
        IndiaVsEngland
        Please enter rotation of String
        EnglandIndiaVs
        IndiaVsEngland and EnglandIndiaVs are rotation of each other
        * */
    }

    public static String checkIfPalindromeRecursion(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        return input.charAt(input.length() - 1)
                + checkIfPalindromeRecursion(input.substring(0, input.length() - 1));
    }

    private static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    counter++;
                } else {
                    sb.append(str.charAt(i));
                    sb.append(counter + 1);
                    counter = 0;
                }
            } else {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    counter++;
                } else {
                    counter = 1;
                }
                sb.append(str.charAt(i));
                sb.append(counter);
            }
        }
        return sb.toString();
    }

    private static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> values = new HashMap<>();
        StringBuilder value = new StringBuilder();
        List<String> test = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), i + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            value = new StringBuilder();
            value.append(s.charAt(i));

            if (i + 1 != s.length()) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    value.append(s.charAt(i + 1));
                }
            }
            test.add(value.toString());
        }
        System.out.println(test);
        return null;
    }

    public static List<String> weightedUniformStrings2(String s, List<Integer> queries) {
        Set<Integer> weights = new HashSet<>();
        int count = 1;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            weights.add(count * ((int) s.charAt(i) - 96));
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                count = 1;
            }
        }
        for (Integer query : queries) {
            if (weights.contains(query)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;
    }

    private static List<Integer> missingNumber(int[] arr) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                if (arr[i] + 1 != arr[i + 1]) {
                    output.add(arr[i] + 1);
                }
            }
        }
        return output;
    }

    public static int countEqualStrings(String a, String b) {
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


    public static void main(String[] args) throws InterruptedException {
//        for(int i=0; i<3; i++){
//            MultiThreadExample t1 = new MultiThreadExample(i);
//            Thread myThread = new Thread(t1);
//            myThread.start();
//            myThread.join();//Waits for this thread to die.
//        }

        testMethod();
    }

    private static void testMethod() {
//        System.out.println(countEqualStrings("ab", "abcbcb")); //-> 1
//        System.out.println(countEqualStrings("abc", "abccba")); //-> 2
//        System.out.println(countEqualStrings("peers", "foreerspersep")); //-> 2
//        System.out.println(countEqualStrings("abc", "jkloa")); //-> 0
//        System.out.println(countEqualStrings("mary", "army")); //-> 1
        System.out.println(countEqualStrings("geeks", "geksforgks")); //0
//        System.out.println(missingNumber(new int[]{1, 2, 3, 4, 6}));
//        System.out.println(missingNumber(new int[]{1,2,3,4,6,7,9,8,10}));
//        System.out.println(missingNumber(new int[]{1,2,3,4,6,9,8}));
//        System.out.println(missingNumber(new int[]{1,2,3,4,9,8}));
        //        ArrayList<Integer> queries = new ArrayList<>() {
//            {
//                add(4);
//                add(2);
//                add(4);
//                add(6);
//                add(1);
//            }
//        };
//        weightedUniformStrings2("abbcccdddd", queries);
//        System.out.println(compressString("aabcccccaaa"));
//        System.out.println(compressString("aabbcccd"));
//        System.out.println(compressString("abbbbbbbbbbbb"));
        //System.out.println(reverseWords("Hello how are you"));
        //System.out.println(countCharOccurrences("holaholaaaa", 'h'));
        //vowelsAndConsonants("abcdefghijklmnopqrstuvwxyz");
//        System.out.println(onlyDigits("abc123"));
//        System.out.println(onlyDigits("123"));
//        System.out.println(onlyDigits("123123123"));
//        System.out.println(onlyDigits("123123"));
//        System.out.println(onlyDigits("1a1a"));
//        System.out.println(onlyDigits("1"));
        //System.out.println(reverseString("Hello how are you"));
        //System.out.println(printDuplicateCharacters("The Netherlands is a beautiful country"));
//        ArrayList<Integer> a = new ArrayList<>() {
//            {
//                add(4);
//                add(2);
//                add(4);
//                add(6);
//                add(1);
//            }
//        };
//
//        ArrayList<Integer> b = new ArrayList<>() {
//            {
//                add(2);
//                add(1);
//                add(8);
//                add(5);
//            }
//        };
//        System.out.println(twoStacks(10, a, b));
//        ArrayList<Integer> h1 = new ArrayList<>() {
//            {
//                add(1);
//                add(3);
//                add(5);
//                add(1); //10
//                add(4);
//                add(8);
//                add(3);
//                add(5);
//                add(3);
//                add(2);
//                add(4);
//            }
//        };
//
//        ArrayList<Integer> h2 = new ArrayList<>() {
//            {
//                add(1);
//                add(1);
//                add(1);
//                add(4);
//                add(2);
//                add(1); //10
//                add(6);
//                add(2);
//            }
//        };
//
//        ArrayList<Integer> h3 = new ArrayList<>() {
//            {
//                add(6);
//                add(2);
//                add(2); //10
//                add(8);
//                add(8);
//                add(8);
//                add(4);
//                add(3);
//                add(1);
//                add(3);
//                add(4);
//                add(4);
//                add(2);
//            }
//        };

        //System.out.println(equalStacks2(h1, h2, h3));
        //System.out.println(equalStacks(h1, h2, h3));
        //int[] arr = {3,3};
        //System.out.println(Arrays.toString(twoSum(arr, 6)));
//        System.out.println(checkIfPalindrome("Don't nod"));
//        System.out.println(checkIfPalindrome("Evil olive"));
//        System.out.println(checkIfPalindrome("Amore, Roma"));
//        System.out.println(checkIfPalindrome("Yo, banana boy!"));
//        System.out.println(checkIfPalindrome("Dammit, I'm mad!"));
        //System.out.println(mostRepeatedWordsSorted("Hello, my name          is Carlos. Carlos is           my name and work as a developer. Carlos is a developer."));
        //System.out.println(isBalanced("{(([])[])[]]}"));
        //System.out.println(matchingParentheses("{(])}"));
//        System.out.println(matchingParentheses("{[(])}"));
        //System.out.println(matchingParentheses("{{[[(())]]}}"));
        //System.out.println(minimumNumber(3, "Ab1"));
        //System.out.println(minimumNumber(4, "4700`"));
        //System.out.println(minimumNumber(7, "AUzs-nV"));
        //System.out.println(timeConversion("06:40:03AM"));
//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(73);
//        list.add(67);
//        list.add(38);
//        list.add(33);
//        System.out.println(gradingStudents(list));
        //System.out.println(superReducedString("abba"));
        //System.out.println(superReducedStringStack("aaabccddd"));
//        Stack<Character> stack = new Stack<>();
//        stack.push('H');
//        stack.push('O');
//        stack.push('L');
//        stack.push('A');
//        System.out.println(stack);
//        System.out.println(stack.peek());
        //System.out.println(camelcase("HiThereHowAreYou"));
    }
}
