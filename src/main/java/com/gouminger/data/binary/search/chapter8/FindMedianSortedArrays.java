package com.gouminger.data.binary.search.chapter8;

//寻找两个正序数组的中位数
public class FindMedianSortedArrays {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen == 0) {
            return 0;
        }
        int idx1 = 0, idx2 = 0;
        int target1=0, target2=0;
        while (true) {
            if (idx1+idx2 == totalLen/2-1) {
                if (idx1<nums1.length && idx2< nums2.length) {
                    if (nums1[idx1] < nums2[idx2]) {
                        target1 = nums1[idx1];
                    } else {
                        target1 = nums2[idx2];
                    }
                } else if (idx1<nums1.length) {
                    target1 = nums1[idx1];
                } else {
                    target1 = nums2[idx2];
                }
            }
            if (idx1+idx2 == totalLen/2) {
                if (idx1<nums1.length && idx2< nums2.length) {
                    if (nums1[idx1] < nums2[idx2]) {
                        target2 = nums1[idx1];
                    } else {
                        target2 = nums2[idx2];
                    }
                } else if (idx1<nums1.length) {
                    target2 = nums1[idx1];
                } else {
                    target2 = nums2[idx2];
                }
                break;
            }
            if (idx1<nums1.length && idx2< nums2.length) {
                if (nums1[idx1] < nums2[idx2]) {
                    idx1++;
                } else {
                    idx2++;
                }
            } else if (idx1<nums1.length) {
                idx1++;
            } else {
                idx2++;
            }
        }
        if (totalLen%2 == 0) {
            return ((double)(target1+target2))/2;
        } else {
            return target2;
        }
    }
}
