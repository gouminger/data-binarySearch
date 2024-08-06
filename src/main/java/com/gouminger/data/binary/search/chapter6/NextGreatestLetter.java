package com.gouminger.data.binary.search.chapter6;

//寻找比目标字母大的最小字母
public class NextGreatestLetter {

    /**
     * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters里至少有两个不同的字符。
     * 返回letters中大于 target 的最小的字符。如果不存在这样的字符，则返回letters 的第一个字符。
     */
    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));

        letters = new char[]{'c', 'f', 'j'};
        target = 'c';
        System.out.println(nextGreatestLetter(letters, target));

        letters = new char[]{'x', 'x', 'y', 'y'};
        target = 'z';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length-1, middle = left+(right-left)/2;
        char t = letters[0];
        while (left<=right){
            if (letters[middle] > target) {
                t = letters[middle];
                right = middle-1;
                middle = left+(right-left)/2;
            } else {
                left = middle+1;
                middle = left+(right-left)/2;
            }
        }
        return t;
    }
}
