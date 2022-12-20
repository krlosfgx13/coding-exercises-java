package org.example.coding.arrays;

import java.util.*;

public class ArrayExercises {

    public int[] twoSum(int[] nums, int target) throws Exception {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public boolean isIntPalindrome(int x) {
        String value = String.valueOf(x);
        char[] arr = new char[value.length()];
        char[] chars = value.toCharArray();
        int counter = 0;
        if (x >= 0 && x <= Integer.MAX_VALUE) {
            for (int i = value.length() - 1; i >= 0; i--) {
                arr[counter] = chars[i];
                counter++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != arr[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isIntPalindrome2(int x) {
        Integer number = new Integer(x);
        String str = number.toString();
        char charInt[] = str.toCharArray();
        char palindrome[] = new char[charInt.length];
        int aux = 0;
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return false;
        }
        for (int i = charInt.length - 1; i >= 0; i--) {
            palindrome[aux] = charInt[i];
            aux++;
        }
        return Arrays.equals(palindrome, charInt);
    }

    public int[] findErrorNums(int[] nums) {
        //input: 1,2,2,4
        //output: 2,3
        int[] output = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            if (i + 1 != nums[i]) {
                output[0] = nums[i];
                output[1] = i + 1;
            }
        }
        return output;
    }

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

    public int[] findErrorNumbersSorting(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

    public int[] findDuplicates(int[] input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j])
                    list.add(input[j]);
            }
        }
        int[] output = new int[list.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = list.get(i);
        }
        return output;
    }

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

    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            // We skip to next index if we see a duplicate element
            if (nums[i - 1] != nums[i]) {
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public int countWordsArray(String input) {
        String pattern = "[^a-zA-Z0-9\\s]";
        input = input.replaceAll(pattern, "");
        input = input.replaceAll("\\s+", " ");
        String[] str = input.split(" ");
        return str.length;
    }


}
