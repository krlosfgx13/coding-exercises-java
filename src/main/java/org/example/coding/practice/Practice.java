package org.example.coding.practice;

import java.util.*;

public class Practice {

    //Time Complexity: O(n^2) since there are two nested for loops.
    //Space Complexity: O(1) since there is no an additional data structure used.
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    //Time Complexity: O(n) since there are just one for loop.
    /*
    Space Complexity: O(n) since there is an additional data structure, in this case a hashmap, so the extra space
    required depends on the number of items stored in the hashmap, which stores n elements.
    */
    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    //Time Complexity: O(n^2) since there are two nested for loops and loop is traversed for each one of the numbers.
    //Space Complexity: O(1) constant space is used wince there are just one data structure.
    public int[] findErrorNumbers(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                dup = i;
            else if (count == 0)
                missing = i;
        }
        return new int[]{dup, missing};
    }

    public int[] findErrorNumbersV2(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                dup = i;
            else if (count == 0)
                missing = i;
        }
        return new int[]{dup, missing};
    }

    //Time Complexity: O(n) since there are two for loops but traverse independently, so o(n+m) = O(n).
    //Space Complexity: O(n) since there are more than one data structure and either map or list can grow, not are fixed size.
    public int[] findDuplicates(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            } else {
                map.put(input[i], 1);
            }
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return !duplicates.isEmpty() ? duplicates.stream().mapToInt(i -> i).toArray() : new int[]{};
    }

    //Remove duplicates from the array.
    //Time Complexity: O(n) since there are two for loops but traverse independently, so o(n+m) = O(n).
    //Space Complexity: O(n) since there are more than one data structure and either map or list can grow, not are fixed size.
    public int[] filterDuplicates(int[] input) {
        //input   5,8,4,2,4,1,8
        //output: 5,8,4,2,1
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        int[] array = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    public int countNoDuplicates(int[] input) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        int[] array = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }
        return array.length;
    }

    public int[] filterDuplicates2(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            } else {
                map.put(input[i], 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return !result.isEmpty() ? result.stream().mapToInt(i -> i).toArray() : new int[]{};
    }

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int countWordsArray(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, ""); //immutability.
        input = input.replaceAll("\\s+", " "); //immutability.
        String[] str = input.split(" ");
        return str.length;
    }

    //Count occurrence of every word in a sentence.
    //Time complexity: O(n)
    //Space conplexity: O(n)
    public Map<String, Integer> countWordOccurrences(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, "");
        input = input.replaceAll("\\s+", " ");
        String[] str = input.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : str) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    public Map<String, Integer> countWordOccurrencesSorted(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, "");
        input = input.replaceAll("\\s+", " ");
        String[] str = input.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        return map;
    }

    //Time Complexity: O(n)
    //Space complexity: O(1) at most there are 26 chars, no more.
    public boolean checkIfSentenceIsPangram(String input) {
        String pattern = "[^a-zA-Z0-9]";
        input = input.replaceAll(pattern, "");
        input = input.toLowerCase();
        Set<Character> set = new HashSet<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        return set.size() == 26;
    }

    //Time complexity: O(n).
    //Space complexity: O(n) since we need additional space to store the reversed string.
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

    public boolean isPalindromeV2(String input) {
        String pattern = "[^a-zA-Z0-9]";
        input = input.replaceAll(pattern, "").toLowerCase();
        StringBuilder sb = new StringBuilder(input).reverse();
        return sb.toString().equals(input);
    }

    //Given a string s, return true if the s can be palindrome after deleting at most one character from it.
    public boolean isPalindromeString(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Given a string s, return true if the s can be palindrome after deleting at most one character from it.
    public boolean validPalindromeWord(String s) {
        //ex: abc d cba -> true
        //ex: abc de cba -> true
        //ex: abc def cba -> false
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return isPalindromeString(left + 1, right, s) || isPalindromeString(left, right - 1, s);
    }

    public boolean validParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '[':
                case '(':
                case '{':
                    stack.push(input.charAt(i));
                    break;

                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
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

    public boolean validParentheses2(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;

                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                    break;

                case ']':
                    if(!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    break;

                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
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

    //Time complexity: O(logn)
    //Space complexity: O(1)
    public boolean isAnagramV2(String s, String t){
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static int seatingStudents(int[] arr) {
        int totalDesks = arr[0]; //defines the number of desks.
        Set<Integer> occupiedDesks = new HashSet<>(); //store occupied desks..
        for (int i = 1; i < arr.length; i++) {
            occupiedDesks.add(arr[i]); //occupy desks.
        }
        System.out.println("totalDesks: " + totalDesks);
        System.out.println("occupiedDesks: " + occupiedDesks);
        int count = 0;
        for (int currentDesk = 1; currentDesk < totalDesks; currentDesk++) {
            if (isOccupied(currentDesk, occupiedDesks, totalDesks)) {
                continue;
            }
            if (currentDesk % 2 != 0) {
                int sideDesk = currentDesk + 1;
                if (!isOccupied(sideDesk, occupiedDesks, totalDesks)) {
                    count++;
                }
            }
            int belowDesk = currentDesk + 2;
            if (!isOccupied(belowDesk, occupiedDesks, totalDesks)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isOccupied(int desk, Set<Integer> occupiedDesks, int totalDesks) {
        return desk > totalDesks || occupiedDesks.contains(desk);
    }

    //Prime checker exercise:
    public static int PrimeChecker(int num) {
        List<Integer> perms = getPermutations("", String.valueOf(num), new ArrayList<Integer>());
        for (int perm : perms) {
            if (isPrime(perm)) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean isPrime(int num) {
        if (num %2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static List<Integer> getPermutations(String begStr, String endStr, List<Integer> perms) {
        if (endStr.length() <= 1) {
            perms.add(Integer.parseInt(begStr + endStr));
        } else {
            for (int i = 0; i < endStr.length(); i++) {
                String newString = endStr.substring(0, i) + endStr.substring(i + 1);
                getPermutations(begStr + endStr.charAt(i), newString, perms);
            }
        }
        return perms;
    }

    public char firstNonRepeatedCharacter(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '\0';
    }
}
