package com.gouminger.data.binary.search.chapter6;

//有效的完全平方数
public class IsPerfectSquare {

    /**
     * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     * 不能使用任何内置的库函数，如 sqrt 。
     */
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));

        System.out.println(isPerfectSquare(14));
    }

    public static boolean isPerfectSquare(int num) {
        int left = 0, right = 46341, middle = left+(right-left)/2;
        long t;
        while (left<=right){
            t = middle*middle;
            if (t == num) {
                return true;
            } else if (t > num) {
                right = middle-1;
                middle = left+(right-left)/2;
            } else {
                left = middle+1;
                middle = left+(right-left)/2;
            }
        }
        return false;
    }
}
