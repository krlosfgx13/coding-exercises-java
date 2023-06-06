package org.example.coding;

import org.example.coding.arrays.ArrayExercises;
import org.example.coding.examples.CodeExamples;
import org.example.coding.practice.Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String input = "the quick brown fox jumps over the lazy dog";
        Practice practice = new Practice();
        ArrayExercises arrayEx = new ArrayExercises();
        CodeExamples examples = new CodeExamples();
        System.out.println(practice.checkIfSentenceIsPangram(input));

//        System.out.println(countEqualStrings("ab", "abcbcb")); //-> 1
//        System.out.println(countEqualStrings("abc", "abccba")); //-> 2
//        System.out.println(countEqualStrings("peers", "foreerspersep")); //-> 2
//        System.out.println(countEqualStrings("abc", "jkloa")); //-> 0
//        System.out.println(countEqualStrings("mary", "army")); //-> 1
//        System.out.println(countEqualStrings("geeks", "geksforgks")); //0
        System.out.println(findNumberOfTimes("geeks", "foreeksgekseg")); //2
        System.out.println(findNumberOfTimes("rajput", "arajjhupoot")); //1
        System.out.println(findNumberOfTimes("zzz", "zzzzzzzzzzz")); //3
    }

    static int findNumberOfTimes(String str2, String str1)
    {
        int freq[] = new int[26];
        int freq2[] = new int[26];

        int l1 = str1.length();

        // iterate and mark the frequencies of
        // all characters in str1
        for (int i = 0; i < l1; i++)
        {
            freq[str1.charAt(i) - 'a'] += 1;
        }
        int l2 = str2.length();
        for (int i = 0; i < l2; i++)
        {
            freq2[str2.charAt(i) - 'a'] += 1;
        }


        int count = Integer.MAX_VALUE;

        // find the minimum frequency of
        // every character in str1
        for (int i = 0; i < l2; i++)
        {
            if(freq2[str2.charAt(i)-'a']!=0)
                count = Math.min(count,
                        freq[str2.charAt(i) - 'a']/freq2[str2.charAt(i)-'a']);
        }

        return count;
    }

    static boolean canMakeStr2(String str1, String str2)
    {
        // Create a count array and count frequencies
        // characters in str1.
        int[] count = new int[10000];
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

    public static int countSubStr(String str, String substr) {
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

//        int[] nums = {8, 6, 3, 5, 9, 1};
//        int target = 12;
//        int var = 12;
//        int var2 = 12 % 10;
//        System.out.println();
//
//        String str = "abfflow";
//        String prefix = "fl";
//        //System.out.println(str.indexOf(prefix));
//
//        String sentence = "Hello my name is Carlos";
//        String find = "Carlos";
//        System.out.println(sentence.toLowerCase().indexOf(find.toLowerCase()));
//
//        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
//        System.out.println(checkIfPangram3("thequickbrownfoxjumpsoverthelazydog"));
//        String[] strs = {"flower", "flow", "flight"};
//
//        //String[] strs = {"flower", "flow", "flight"};
//        //System.out.println(longestCommonPrefix(strs));
//        //System.out.println(romanToInteger("III"));
//        //System.out.println(romanToInteger("MCMXCIV"));
//        //System.out.println(romanToInteger2("DIC"));
//        //System.out.println(validParenthesis("{[[()]]}"));
//        //int input[] = { 5,8,4,2,4,1,8 };
//        //int input[] = { 1,2,3,3,5 };
//        //int input[] = { 3,2,2 };
//        //System.out.println(Arrays.toString(findErrorNumbers(input)));
//        //testIndexes();//
        //regex examples
        String oneLetterRegex = "[A-Za-z0-9]"; //H || 9 || h
        String wordRegex = "[A-Za-z]+"; //Hello
        String lowerCaseWordRegex = "[a-z]+";//hello
        String wordWithSpace = "[a-z]+[\\s]+";//hello_
        String wordsAndNumbersWSpace = "[^a-zA-Z0-9\\s]"; //hello how are you
        String cronExpressionDaily = "[0]+[\\s][0-5]?[0-9][\\s]([0-1]?[0-9]|2[0-3])+[\\s][\\?][\\s]([1-9]|1[012])[-]([1-9]|1[012])[\\s](MON|TUE|WED|THU|FRI)[-](MON|TUE|WED|THU|FRI)[\\s][\\*]";
        String cronExpressionWeekly = "[0]+[\\s][0-5]?[0-9][\\s]([0-1]?[0-9]|2[0-3])+[\\s][\\?][\\s]([1-9]|1[012])[-]([1-9]|1[012])[\\s](MON|TUE|WED|THU|FRI)[\\s][\\*]";
        String cronExpressionMonthly = "[0]+[\\s][0-5]?[0-9][\\s]([0-1]?[0-9]|2[0-3])+[\\s]([1-9]|[12]\\d|3[01])[\\s][\\*][\\s][\\?][\\s][\\*]";//
//        String inputDailyCronExp = "0 50 9 ? 1-2 MON-FRI *";
//        String inputWeeklyCronExp = "0 50 9 ? 1-2 TUE";
//        String inputMonthlyCronExp = "0 50 9 1 * ? *";
        String passwordPattern = "[a-zA-Z0-9!@#$%^&*()-+]+";
        String lowerCase = "[a-z]";
        String upperCase = "[A-Z]";
        String numbers = "[0-9]";
        String specialCharacters = "[!@#$%^&*()-+]";
//        //System.out.println(str.matches(lowerCaseWordRegex));
//        String regex = "[^a-zA-Z0-9\\s]";
//        String str1 = "hello, how are you?";
//        //System.out.println("Before removal: " + str);
//        str = str.replaceAll(regex, "");
//        //System.out.println("After removal: " + str);
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("Word", 1);
//        String input = "Sunjay works at TELUS. TELUS is a telco company. It is a good place to work.";
//        //System.out.println(countWords("hello this is a test hello hello", "hello"));
//        String sentence1 = "Hello              :,!!!!!  this is a sentence. Because I want to test this method.";
//        String text = "HelloWorldBye";
//        //System.out.println(findDuplicateCharacters(text));
//        //System.out.println(findDuplicateCharacters3(text));
//        //System.out.println(countWords2("Sunjay works at TELUS. TELUS is a telco company. It is a good place to work."));
//        //System.out.println(findDuplicateCharacters2(text));
//
//        String sentence11 = "Hello my name is Carlos";
//        String find1 = "Carlos";
//        //System.out.println(sentence.toLowerCase().indexOf(find.toLowerCase()));
//
//        String a = "abc";
//        String b = "abccba";
//        StringBuilder sb = new StringBuilder(a);
//        String a2 = sb.reverse().toString();
//
//        /*
//         * Given two strings a and b, both consisting only of lowercase English letters, your task is to calculate how
//         * many strings equal to a can be constructed using only letters from the string b? Each letter can be used only
//         * once and in one string only.
//         * */
//        System.out.println(countEqualStrings("ab", "abcbcb")); //-> 1
//        System.out.println(countEqualStrings("abc", "abccba")); //-> 2
//        System.out.println(countEqualStrings("peers", "foreerspersep")); //-> 2
//        System.out.println(countEqualStrings("abc", "jkloa")); //-> 0
//        System.out.println(countEqualStrings("mary", "army")); //-> 1
//        System.out.println(countEqualStrings("geeks", "geksforgks")); //0
//        System.out.println(countEqualStrings("geeks", "foreeksgekseg")); //2
//        System.out.println(countEqualStrings("rajput", "arajjhupoot")); //1
//        String str1_ = "geksforgks";
//        String str2 = "geeks";
//        System.out.println(countEqualStrings(str2, str1_));
//        System.out.println(findNumberOfTimes(str1_, str2));
//        System.out.println(countSubStr(str1_, str2));
//        System.out.println(findFirstNonRepeatedChar("swiss"));
}