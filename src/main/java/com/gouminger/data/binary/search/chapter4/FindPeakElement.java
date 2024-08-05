package com.gouminger.data.binary.search.chapter4;

//寻找峰值
public class FindPeakElement {

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * 你可以假设nums[-1] = nums[n] = -∞ 。
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(nums));

        nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int i = 0;
        while (i < nums.length-1) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
            i++;
        }
        return i;
    }
}
