package com.pglc1026.geekbang.minorclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TwoSum
 * leetcode-1: https://leetcode-cn.com/problems/two-sum
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Liu Chang
 * @date 2020/1/13
 */
public class TwoSum {

    /**
     * 暴力循环
     * 时间复杂度：O(n ^ 2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void solution1() {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        int[] ret = twoSum1(nums, target);
        List<Integer> list = new ArrayList<>();
        for (int num : ret) {
            list.add(num);
        }
        System.out.println(list);
    }

    /**
     * hash表循环两次
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 构建hash表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != nums[i]) {
                return new int[] {i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void solution2() {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        int[] ret = twoSum2(nums, target);
        List<Integer> list = new ArrayList<>();
        for (int num : ret) {
            list.add(num);
        }
        System.out.println(list);
    }

    /**
     * 哈希表一次遍历，构建的同时查找
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != nums[i]) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void solution3() {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        int[] ret = twoSum3(nums, target);
        List<Integer> list = new ArrayList<>();
        for (int num : ret) {
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
