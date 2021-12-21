package org.ycx.lesson.leetcode.array;


import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 0001. 两数之和
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice
 *
 * 题目大意： 在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标。
 *
 * 示例:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.lesson.leetcode.easy
 * @date :       2021/10/14 10:19
 * @copyright :  wpwl
 */
public class SumOfTwoNumbers {

    /**
     * 结果以及效率测试
     *
     * @param args
     * @return : void
     * @author : guowc
     * @date : 2021/10/20 9:37
     **/
    public static void main(String[] args) {
        Integer[] nums = {2, 7, 11, 15};
        int target = 26;

        long st = System.currentTimeMillis();
        Integer[] resultArray = sumOfTwoNumbers1(nums, target);
        String result = resultArray.length > 0 ? Arrays.toString(resultArray) : "Sorry no result!!!";
        System.out.println(result);
        System.out.println("方法1消耗时间：" + (System.currentTimeMillis() - st) + "ms");

        st = System.currentTimeMillis();
        Integer[] resultArray2 = sumOfTwoNumbers2(nums, target);
        String result2 = resultArray2.length > 0 ? Arrays.toString(resultArray) : "Sorry no result!!!";
        System.out.println(result2);
        System.out.println("方法2消耗时间：" + (System.currentTimeMillis() - st) + "ms");


        st = System.currentTimeMillis();
        Integer[] resultArray3 = sumOfTwoNumbers3(nums, target);
        String result3 = resultArray3.length > 0 ? Arrays.toString(resultArray) : "Sorry no result!!!";
        System.out.println(result3);
        System.out.println("方法2消耗时间：" + (System.currentTimeMillis() - st) + "ms");
    }

    /**
     * 解法1 暴力循环
     * 时间复杂度T(n) = O(f(n²))  空间复杂度为 O(n)
     *
     * @param nums
     * @param target
     * @return : Integer
     * @author : guowc
     * @date : 2021/10/20 9:06
     **/
    public static Integer[] sumOfTwoNumbers1(Integer[] nums, Integer target) {

        Integer[] resultArray = new Integer[2];

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == result) {
                    resultArray[0] = i;
                    resultArray[1] = j;
                }
            }
        }
        return resultArray;
    }


    /**
     * 解法2 用map解决 (参考他人思路,非独自思考)
     * key:target-num[i]  value:数组索引
     * 时间复杂度T(n) = O(f(n))  空间复杂度为 O(n)
     *
     * @param nums
     * @param target
     * @return : Integer
     * @author : guowc
     * @date : 2021/10/20 9:53
     **/
    public static Integer[] sumOfTwoNumbers2(Integer[] nums, Integer target) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if ((map.get(target - nums[i])) != null) {
                return new Integer[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }

        return new Integer[2];
    }

    /**
     * 解法三 ：双指针
     * 首先将数组排序,计算nums[low]+nums[high] 如果小于target 代表左边的数太小，指针右移，如果大于target代表右边的数太大指针左移
     * 时间复杂度T(n) = O(f(n))  空间复杂度为 O(n)
     * @author : guowc
     * @date   : 2021/10/20 18:10
     * @param    nums
     * @param    target
     * @return : Integer
     **/
    public static Integer[] sumOfTwoNumbers3(Integer[] nums, Integer target){
        int low = 0;
        int high = nums.length-1;
        Arrays.sort(nums);
        while (low < high) {
            if (nums[low]+nums[high]<target) {
                low++;
            }else if (nums[low]+nums[high]>target){
                high--;
            }else {
                return new Integer[]{low,high};
            }
        }
        return new Integer[2];
    }
}

