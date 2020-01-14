package com.pglc1026.geekbang.minorclass;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode-189: https://leetcode-cn.com/problems/rotate-array/
 * RotateArray
 *
 * @author Liu Chang
 * @date 2020/1/13
 */
public class RotateArray {

    /**
     * 临时数组
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int[] tmpNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmpNums[i] = nums[(nums.length - (k % nums.length) + i) % nums.length];
        }
        System.arraycopy(tmpNums, 0, nums, 0, tmpNums.length);
    }

    /**
     * 临时数组2
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        // 先把后面的换出来
        int actualMove = k % nums.length;
        int[] tmpNums = new int[actualMove];
        for (int i = 0; i < actualMove; i++) {
            tmpNums[tmpNums.length - 1 - i] = nums[nums.length - 1 - i];
        }

        // nums的元素都向后移动
        for (int i = 1; i <= nums.length - actualMove; i++) {
            nums[nums.length - i] = nums[nums.length - actualMove - i];
        }
        for (int i = 0; i < actualMove; i++) {
            System.arraycopy(tmpNums, 0, nums, 0, tmpNums.length);
        }

    }

    /**
     * 环状替换
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 使用反转，先整体反转，然后反转前k个元素，最后反转后n-k个元素
     *
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }

    public static void solution1() {
        System.out.println(">>>>>>>>>> 解法1 <<<<<<<<<<");

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate1(nums, 3);

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);

        int[] nums2 = {-1,-100,3,99};
        rotate1(nums2, 2);

        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            list2.add(num);
        }
        System.out.println(list2);

        System.out.println(">>>>>>>>>> 解法1 <<<<<<<<<<");
        System.out.println();
    }

    public static void solution2() {
        System.out.println(">>>>>>>>>> 解法2 <<<<<<<<<<");

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 3);

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);

        int[] nums2 = {-1,-100,3,99};
        rotate2(nums2, 2);

        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            list2.add(num);
        }
        System.out.println(list2);

        System.out.println(">>>>>>>>>> 解法2 <<<<<<<<<<");
        System.out.println();
    }

    public static void solution3() {
        System.out.println(">>>>>>>>>> 解法3 <<<<<<<<<<");

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);

        int[] nums2 = {-1,-100,3,99};
        rotate3(nums2, 2);

        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            list2.add(num);
        }
        System.out.println(list2);

        System.out.println(">>>>>>>>>> 解法3 <<<<<<<<<<");
        System.out.println();
    }


    public static void solution4() {
        System.out.println(">>>>>>>>>> 解法4 <<<<<<<<<<");

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate4(nums, 3);

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);

        int[] nums2 = {-1,-100,3,99};
        rotate4(nums2, 2);

        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            list2.add(num);
        }
        System.out.println(list2);

        System.out.println(">>>>>>>>>> 解法4 <<<<<<<<<<");
        System.out.println();
    }

    public static void main(String[] args) {
//        solution1();
//        solution2();
//        solution3();
        solution4();

    }

}
