package com.gouminger.data.binary.search.chapter2;

//x 的平方根
public class MySqrt {

    /**
     * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     */
    public static void main(String[] args) {
        System.out.println(mySqrt(4));

        System.out.println(mySqrt(8));

        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int left = 0, right = 46340, middle = (left+right)/2, result = right;
        while (left <= right) {
            if (middle*middle == x) {
                return middle;
            } else if (middle*middle < x) {
                result = middle;
                left = middle+1;
                middle = (left+right)/2;
            } else if (middle*middle > x) {
                right = middle-1;
                middle = (left+right)/2;
            }
        }
        return result;
    }
}
