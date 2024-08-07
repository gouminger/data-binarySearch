package com.gouminger.data.binary.search.chapter7;

import java.util.Arrays;

//两个数组的交集 II
public class Intersect {

    /**
     * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
     * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

        nums1 = new int[]{4, 9 ,5};
        nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{1, 1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] shortNums, longNums;
        if (nums1.length < nums2.length) {
            shortNums = nums1;
            longNums = nums2;
        } else {
            shortNums = nums2;
            longNums = nums1;
        }

        int[] standards = new int[1001];
        for (int num : longNums) {
            standards[num]++;
        }
        int len = 0;
        for (int num : shortNums) {
            if (standards[num] > 0) {
                standards[num]--;
                len++;
            }
        }
        for (int num : longNums) {
            standards[num]++;
        }
        int[] result = new int[len];
        int idx = 0;
        for (int num : shortNums) {
            if (standards[num] > 0) {
                standards[num]--;
                result[idx++] = num;
            }
        }
        return result;
    }
}
