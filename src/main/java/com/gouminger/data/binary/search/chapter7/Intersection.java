package com.gouminger.data.binary.search.chapter7;

import java.util.Arrays;

//两个数组的交集
public class Intersection {

    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        nums1 = new int[]{4, 9 ,5};
        nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] standards = new int[1001];
        for (int num : nums1) {
            standards[num] = 1;
        }
        int len = 0;
        for (int num : nums2) {
            if (standards[num] == 1) {
                standards[num] = 2;
                len++;
            }
        }
        int[] result = new int[len];
        int idx = 0;
        for (int num : nums2) {
            if (standards[num] == 2) {
                standards[num] = 3;
                result[idx++] = num;
            }
        }
        return result;
    }
}
