package org.example.coding.math;

public class MathExercises {

    private static int firstFactorial(int num) {
        int result = num;
        for (int i = num; i > 1; i--) {
            result = result * (i - 1);
        }
        return result;
    }

    public static int FirstFactorial(int num) {
        if (num != 1) {
            return num*FirstFactorial(num - 1);
        }
        return num;
    }


    private static int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    private static int pairSum(int a, int b) {
        return a + b;
    }

    private static int countPrimes(int n) {
        int count = 1;
        boolean isNotPrime = false;
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return 0;

            // Check if number is 2
        else if (n == 2)
            return 0;

        // If not, then just check the odds
        for (int i = 3; i < n; i += 2) {
            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j != 0) {
                    count++;
                } else {
                    isNotPrime = true;
                }
            }
            if (!isNotPrime)
                count++;
        }
        return count;
    }
}
