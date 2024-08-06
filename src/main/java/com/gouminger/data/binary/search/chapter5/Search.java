package com.gouminger.data.binary.search.chapter5;

import com.gouminger.data.binary.search.common.ArrayReader;

//搜索长度未知的有序数组
public class Search {

    /**
     * 这是一个交互问题。
     * 您有一个升序整数数组，其长度未知。您没有访问数组的权限，但是可以使用ArrayReader接口访问它。你可以调用ArrayReader.get(i):
     * 返回数组第ith个索引(0-indexed)处的值(即secret[i])，或者
     * 如果i 超出了数组的边界，则返回231- 1
     * 你也会得到一个整数 target。
     * 如果存在secret[k] == target，请返回索引k的值；否则返回-1
     * 你必须写一个时间复杂度为O(log n)的算法。
     */
    public static void main(String[] args) {
        int[] secret = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(new ArrayReader(secret), target));

        secret = new int[]{-1,0,3,5,9,12};
        target = 2;
        System.out.println(search(new ArrayReader(secret), target));
    }

    public static int search(ArrayReader reader, int target) {
        int left = 0, right = 10000, middle = left+(right-left)/2;
        while (left <= right) {
            if (reader.get(middle) == target) {
                return middle;
            } else if (reader.get(middle) < -10000) {
                right = middle-1;
                middle = left+(right-left)/2;
            } else if (reader.get(middle) < target) {
                left = middle+1;
                middle = left+(right-left)/2;
            } else {
                right = middle-1;
                middle = left+(right-left)/2;
            }
        }
        return -1;
    }
}
