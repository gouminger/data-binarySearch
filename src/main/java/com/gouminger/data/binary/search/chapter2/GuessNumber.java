package com.gouminger.data.binary.search.chapter2;

import com.gouminger.data.binary.search.Main;

//猜数字大小
public class GuessNumber {

    private static int num;

    /**
     * 我们正在玩猜数字游戏。猜数字游戏的规则如下：
     * 我会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，我选出的数字比你猜测的数字大了还是小了。
     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有三种可能的情况：
     * -1：你猜的数字比我选出的数字大 （即num > pick）。
     * 1：你猜的数字比我选出的数字小（即num <pick）。
     * 0：你猜的数字与我选出的数字相等。（即num== pick）。
     * 返回我选出的数字。
     */
    public static void main(String[] args) {
        num = 6;
        System.out.println(guessNumber(10));

        num = 1;
        System.out.println(guessNumber(1));

        num = 1;
        System.out.println(guessNumber(2));

        num = 1702766719;
        System.out.println(guessNumber(2126753390));
    }

    public static int guessNumber(int n) {
        int left = 0, right = n, middle = (left+right)/2, t;
        while (left <= right) {
            t = guess(middle);
            if (t == 0) {
                return middle;
            } else if (t == -1) {
                right = middle - 1;
                middle = left+((right-left)/2);
            } else if (t == 1) {
                left = middle + 1;
                middle = left+((right-left)/2);
            }
        }
        return -1;
    }

    public static int guess(int num) {
        if (num == GuessNumber.num) {
            return 0;
        }
        return num > GuessNumber.num ? -1 : 1;
    }
}
