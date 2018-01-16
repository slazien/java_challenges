package com.slazien.series;

public class Series {

    public static long nSum(int n) {
        int total = 0;
        for (int j = 0; j <= n; j++) {
            total += j;
        }

        return total;
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
