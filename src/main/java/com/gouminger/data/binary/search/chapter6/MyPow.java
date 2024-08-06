package com.gouminger.data.binary.search.chapter6;

//Pow(x, n)
public class MyPow {

    /**
     * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。
     */
    public static void main(String[] args) {
        System.out.println(-2147483648%2);
        System.out.println(myPow(2D, 10));

        System.out.println(myPow(2.1D, 3));

        System.out.println(myPow(2D, -2));

        System.out.println(myPow(2D, 0));

        System.out.println(myPow(2D, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0 ) {
            return 1D;
        }
        if (x == 1) {
            return 1D;
        }
        if (x == -1) {
            return n%2 == 0 ? 1D : -1D;
        }
        boolean flag = n > 0;
        if (!flag) {
            n = -n;
        }
        if (n == Integer.MIN_VALUE) {
            if (x > 1D) {
                return 0D;
            }
            n = Integer.MAX_VALUE;
        }
        double result = x;
        int n1 = 1;
        while (n1 <= n>>2) {
            result = result*result;
            n1 = n1<<1;
        }
        while (n1 < n) {
            result = result*x;
            n1++;
        }
        if (!flag) {
            result = 1/result;
        }
        return result;
    }
}
