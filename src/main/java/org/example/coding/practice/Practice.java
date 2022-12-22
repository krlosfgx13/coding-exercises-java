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
        for(String s : str){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }else{
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
    public boolean checkIfSentenceIsPangram(String input){
        String pattern = "[^a-zA-Z0-9]";
        input = input.replaceAll(pattern, "");
        input = input.toLowerCase();
        Set<Character> set = new HashSet<>();
        char[] chars = input.toCharArray();
        for(char c : chars){
            set.add(c);
        }
        return set.size() == 26;
    }

    public boolean isPalindrome(String input){
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, "");
        StringBuffer sb = new StringBuffer();
        for(int i = input.length() - 1; i>=0; i--){
            sb.append(input.charAt(i));
        }
        return sb.toString().equals(input);
    }
}
