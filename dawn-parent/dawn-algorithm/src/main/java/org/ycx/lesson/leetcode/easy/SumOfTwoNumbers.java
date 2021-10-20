package org.ycx.lesson.leetcode.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 0001. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
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
    }

    /**
     * 解法1
     * 暴力循环
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
     * 解法2
     * 用map解决 (参考他人思路,非独自思考)
     * key:target-num[i]  value:数组索引
     * 时间复杂度T(n) = O(f(n²))  空间复杂度为 O(n)
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


}
