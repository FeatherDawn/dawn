package org.ycx.lesson.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0015-3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note : The solution set must not contain duplicate triplets. (解决方案集不得包含重复的三元组。 )
 * [-1，-1，2] 和 [2, -1, -1]、[-1, 2, -1] 为重复解
 * <p>
 * 题目大意 : 给定一个数组，要求在这个数组中找出 3 个数之和为 0 的所有组合。
 * <p>
 * 示例 ：
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.lesson.leetcode.array
 * @date :       2021/10/20 17:49
 * @copyright :  wpwl
 */
public class ThreeSum {


    /**
     * 测试方法
     *
     * @param args
     * @return : void
     * @author : guowc
     * @date : 2021/10/20 18:34
     **/
    public static void main(String[] args) {

    }


    /**
     * 解法一: 暴力循环
     * 时间复杂度T(n) = O(f(n³))  空间复杂度为 O(n)
     *
     * @param nums
     * @return : List<List<Integer>>
     * @author : guowc
     * @date : 2021/10/20 18:40
     **/
    public static List<List<Integer>> threeSum(Integer[] nums) {

        ArrayList<List<Integer>> resultList = new ArrayList<>();
        int temp;

        if (nums.length < 3) {
            return resultList;
        }

        //最外层循环,确定第一个数
        for (int fir = 0; fir < nums.length; fir++) {
            //中间循环 第2个数与第3个数的和相加为0
            for (int sec = 1; sec < nums.length; sec++) {
                //最后一次循环，取到最后一个数
                for (int thr = 2; thr < nums.length; thr++) {
                    if (fir + sec + thr == 0) {
                        List<Integer> oneResultList = new ArrayList<>(Arrays.asList(fir, sec, thr));
                        resultList.add(oneResultList);
                    }
                }
            }
        }
        return resultList;
    }

}
