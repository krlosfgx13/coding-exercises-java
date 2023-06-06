package org.example.coding.math;

import java.util.ArrayList;
import java.util.List;

public class MathExercises {

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return x == reversed;
    }

    public int firstFactorial(int num) {
        int result = num;
        for (int i = num; i > 1; i--) {
            result = result * (i - 1);
        }
        return result;
    }

    public int FirstFactorial(int num) {
        if (num != 1) {
            return num * FirstFactorial(num - 1);
        }
        return num;
    }


    public int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    public int pairSum(int a, int b) {
        return a + b;
    }

    public static boolean isPrime(int num) {
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime2(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> returnPrimes(int n) {
        List<Integer> listOfPrimes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime2(i)) {
                listOfPrimes.add(i);
            }
        }
        return listOfPrimes;
    }

    private static void permutation(String str) {
        permutation(str, "");
    }

    private static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    private static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //1. Compute the product of a and b. Runtime is O(n) since there are iteratinos through b in a for loop.
    private static int product(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += b;
        }
        return sum;
    }

    //2. Compute a raised b. Runtime is O(n) since recurse calls are performed through b.
    private static int power(int a, int b) {
        if (b < 0) {
            return 0;
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }

    //3. Compute a % b. O(1) since it does a constant amount of work.
    private static int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    //4. Compute a / b.
    private static int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(returnPrimes(100));
        //permutation("ABC");
        //String str = "Hello my name is Antonio";
        //System.out.println(str.substring(7)); //Starts at specified index position.
        //String Str = new String("Welcome to geeksforgeeks");
        //System.out.println(Str.substring(10));
        //String hello = "Hello world";
        //System.out.println(hello.substring(6, 11));
        //System.out.println(hello.substring(0, 0));
        //System.out.println(fibonacci(4));
        //System.out.println(div(6,3));
        List<Integer> list = new ArrayList<>();
        list.add(256741038);
        list.add(623958417);
        list.add(467905213);
        list.add(714532089);
        list.add(938071625);
        //plusMinus(list);
        //staircase(6);
        miniMaxSum(list);
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

    public static void staircase(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            printStairs(i);
        }
    }

    public static void printStairs(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public static void staircase2(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            int b = n - i;
            for (int j = 1; j <= n; j++) {
                System.out.print((j > b) ? "#" : " ");
            }
            System.out.print("\n");
        }
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            res1 += arr.get(i).get(i);
        }

        int counter = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            res2 += arr.get(i).get(counter);
            counter--;
        }

        int result = Math.abs(res1 - res2);
        return result;
    }

    public static int diagonalDifference2(List<List<Integer>> arr) {
        // Write your code here
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            res1 += arr.get(i).get(i);
            res2 += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(res1 - res2);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float greater = 0;
        float less = 0;
        float zero = 0;
        for (int i : arr) {
            if (i > 0) {
                greater++;
            } else if (i < 0) {
                less++;
            } else if (i == 0) {
                zero++;
            }
        }
        //float result = greater/arr.size();
        System.out.printf("%.6f \n", greater / arr.size());
        System.out.printf("%.6f \n", less / arr.size());
        System.out.printf("%.6f \n", zero / arr.size());
    }
}
