package com.pglc1026.geekbang.minorclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode-88: https://leetcode-cn.com/problems/merge-sorted-array/
 * MergeTwoSortedArray
 *
 * @author Liu Chang
 * @date 2020/1/13
 */
public class MergeTwoSortedArray {

    /**
     * 先合并，再排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void solution1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge1(nums1, 3, nums2, 3);
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }
        System.out.println(list);
    }

    /**
     * 双指针，从前向后
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0;
        int p2 = 0;

        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = nums1Copy[p1] > nums2[p2] ? nums2[p2++] : nums1Copy[p1++];
        }

        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

    }

    public static void solution2() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge2(nums1, 3, nums2, 3);
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }
        System.out.println(list);
    }

    /**
     * 双指针，从后往前
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        // 如果nums2还有剩余元素，表示nums2中剩余元素都比较小，可以直接排到前面去
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

    public static void solution3() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge3(nums1, 3, nums2, 3);
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
//        solution1();
//        solution2();
        solution3();
    }
}
