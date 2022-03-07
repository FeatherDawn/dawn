package org.ycx.lesson.leetcode.array;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public static void main(String[] args) throws UnsupportedEncodingException {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList = threeSum2(nums);
        System.out.println(resultList);
    }


    /**
     * 解法一: 暴力循环
     * 时间复杂度T(n) = O(n³)  空间复杂度为 O(n)
     *
     * @param nums
     * @return : List<List<Integer>>
     * @author : guowc
     * @date : 2021/10/20 18:40
     **/
    public static List<List<Integer>> threeSum1(Integer[] nums) {

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


    /**
     * 排序 + 双指针
     *
     * @param nums
     * @return : List<List<Integer>>
     * @author : guowc
     * @date : 2021/11/2 18:54
     **/
    public static List<List<Integer>> threeSum2(int[] nums) {

        //定义存放结果的集合
        List<List<Integer>> resultList = new ArrayList();

        //入参校验【长度小于3,或者为空】
        if (nums == null || nums.length < 3) {
            return null;
        }

        //数组不为空,且长度足够
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //因为已经排序 第一个数及最小数 最小数大于0 三数相加不可能为0
            if (nums[i] > 0) {
                break;
            }

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //定义双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
            }
        }
        return resultList;
    }
}
