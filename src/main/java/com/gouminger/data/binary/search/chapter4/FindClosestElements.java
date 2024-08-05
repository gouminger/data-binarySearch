package com.gouminger.data.binary.search.chapter4;

import com.alibaba.fastjson2.JSON;

import java.util.LinkedList;
import java.util.List;

//找到 K 个最接近的元素
public class FindClosestElements {

    /**
     * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *
     * 整数 a 比整数 b 更接近 x 需要满足：
     *
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println(JSON.toJSON(findClosestElements(arr, k, x)));

        arr = new int[]{1, 2, 3, 4, 5};
        k = 4;
        x = -1;
        System.out.println(JSON.toJSON(findClosestElements(arr, k, x)));

        arr = new int[]{10, 20, 30, 40, 50};
        k = 4;
        x = 34;
        System.out.println(JSON.toJSON(findClosestElements(arr, k, x)));

        arr = new int[]{-2,-1,1,2,3,4,5};
        k = 7;
        x = 3;
        System.out.println(JSON.toJSON(findClosestElements(arr, k, x)));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1, start = -1, end = -1;
        while (left <= right) {
            int middle = left + (right-left)/2;
            if (arr[middle] == x) {
                start = middle;
                end = middle;
                break;
            }
            if (arr[middle] > x) {
                end = middle;
                right = middle-1;
            } else {
                start = middle;
                left = middle+1;
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while (k>0){
            if (start == -1) {
                result.addLast(arr[end++]);
            } else if (end == -1 || end == arr.length) {
                result.addFirst(arr[start--]);
            } else if (start == end) {
                result.addFirst(arr[start--]);
                end++;
            } else if (x-arr[start] == arr[end]-x) {
                result.addFirst(arr[start--]);
            } else if (x-arr[start] > arr[end]-x) {
                result.addLast(arr[end++]);
            } else if (x-arr[start] < arr[end]-x) {
                result.addFirst(arr[start--]);
            }
            k--;
        }
        return result;
    }
}
