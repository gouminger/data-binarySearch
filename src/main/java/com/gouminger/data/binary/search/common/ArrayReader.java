package com.gouminger.data.binary.search.common;

public class ArrayReader {

    private int[] nums;

    public ArrayReader(int[] nums) {
        this.nums = nums;
    }

    public int get(int index) {
        if (index >= nums.length) {
            return -10001;
        }
        return nums[index];
    }

}
