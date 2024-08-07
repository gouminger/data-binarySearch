package com.gouminger.data.binary.search.chapter7;

//寻找旋转排序数组中的最小值 II
public class FindMin2 {

    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * 你必须尽可能减少整个过程的操作步骤。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        System.out.println(findMin(nums));

        nums = new int[]{2,2,2,0,1};
        System.out.println(findMin(nums));

        nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(findMin(nums));

        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));

        nums = new int[]{11,13,15,17};
        System.out.println(findMin(nums));

        nums = new int[]{2, 1};
        System.out.println(findMin(nums));

        nums = new int[]{3, 1, 2};
        System.out.println(findMin(nums));

        nums = new int[]{1, 1};
        System.out.println(findMin(nums));

        nums = new int[]{10, 1, 10, 10, 10};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[left] == nums[right]) {
            int repeat = nums[left];
            while (nums[left] == repeat && left < right) {
                left++;
            }
            while (nums[right] == repeat && right > left) {
                right--;
            }
            if (left > 0) {
                left--;
            }
        }
        int min = nums[left], middle = left+(right-left)/2;
        while (left<=right) {
            if (nums[left] <= nums[middle] && nums[middle] <= nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }
            if (nums[left] <= nums[middle]) {
                min = Math.min(min, nums[left]);
                left = middle+1;
                middle = left+(right-left)/2;
            } else {
                min = Math.min(min, nums[middle]);
                right = middle-1;
                middle = left+(right-left)/2;
            }
        }
        return min;
    }
}
