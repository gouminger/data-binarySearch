package com.gouminger.data.binary.search.chapter1;

//二分查找
public class Search {

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));

        nums = new int[]{-1,0,3,5,9,12};
        target = 2;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length-1, middle = (left+right)/2;
        while (true) {
            if (nums[middle] == target) {
                return middle;
            } else if (middle == left) {
                if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            } else if (nums[middle] > target) {
                right = middle;
                middle = (left+right)/2;
            } else if (nums[middle] < target) {
                left = middle;
                middle = (left+right)/2;
            }
        }
    }
}
