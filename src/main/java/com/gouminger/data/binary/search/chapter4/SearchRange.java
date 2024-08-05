package com.gouminger.data.binary.search.chapter4;

import java.util.Arrays;

//在排序数组中查找元素的第一个和最后一个位置
public class SearchRange {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));

        nums = new int[]{};
        target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1, middle = left + (right - left) / 2;
        while (left + 1 < right) {
            if (nums[middle] == target) {
                return findRound(nums, target, middle);
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
            middle = left + (right - left) / 2;
        }
        if (nums[left] == target) {
            return findRound(nums, target, left);
        }
        if (nums[right] == target) {
            return findRound(nums, target, right);
        }
        return new int[]{-1, -1};
    }

    private static int[] findRound (int[] nums, int target, int idx) {
        int min = idx, max = idx;
        while (min > 0) {
            if (nums[min-1] == target) {
                min--;
            } else {
                break;
            }
        }
        while (max < nums.length-1) {
            if (nums[max+1] == target) {
                max++;
            } else {
                break;
            }
        }
        return new int[]{min, max};
    }
}
