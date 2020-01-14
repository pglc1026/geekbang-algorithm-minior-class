package com.pglc1026.geekbang.minorclass;

import java.util.ArrayList;
import java.util.List;

/**
 * MoveZeros
 * leetcode-283: https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *  必须在原数组上操作，不能拷贝额外的数组。
 *  尽量减少操作次数。
 *
 * @author Liu Chang
 * @date 2020/1/13
 */
public class MoveZeros {

    /**
     * 暴力
     *
     * @param nums
     */
    public static void moveZeros1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 寻找下一个非0元素，进行互换
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        continue;
                    }
                    nums[i] ^= nums[j];
                    nums[j] ^= nums[i];
                    nums[i] ^= nums[j];
                    break;
                }
            }
        }
    }

    public static void solution1() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros1(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);
    }

    /**
     * 双指针
     * 1. 用非0元素覆盖数组前的元素
     * 2. 覆盖完成后，将非0元素后的元素全部设为0
     *
     * @param nums
     */
    public static void moveZeros2(int[] nums) {
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastIndex++] = nums[i];
            }
        }

        for (;lastIndex < nums.length; lastIndex++) {
            nums[lastIndex] = 0;
        }
    }

    public static void solution2() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros2(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);
    }

    /**
     * 优化：
     *  双指针，一次遍历，交换非0与0的数值，保证非0索引前全部非0，非0索引与当前索引之间全部为0，避免重复的赋值。
     * @param nums
     */
    public static void moveZeros3(int[] nums) {
        for (int lastIndex = 0, current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                // swap
                int temp = nums[current];
                nums[current] = nums[lastIndex];
                nums[lastIndex++] = temp;
            }
        }
    }

    public static void solution3() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros3(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
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
