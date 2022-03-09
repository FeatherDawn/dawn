package org.ycx.lesson.leetcode.array;

import java.util.Arrays;

/**
 * 0001. 盛最多水的容器
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2
 * <p>
 * 题目大意：
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author :     guowc
 * @version :    1.0
     * @package :    org.ycx.lesson.leetcode.array
     * @date :       2022/3/8 10:15
 * @copyright :  wpwl
 */
public class ContainerWithMostWater {

    /**
     * 结果以及效率测试
     *
     * @param args
     * @return : void
     * @author : guowc
     * @date : 2021/10/20 9:37
     **/
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //int[] nums = {1,1};
        System.out.println(maxArea1(nums));
    }


    /**
     * 解法1 : 暴力双循环【不剪枝超时】
     *
     * @param
     * @return : int
     * @author : guowc
     * @date : 2022/3/8 10:20
     **/
    public static int maxArea1(int[] height) {

        int max = 0;

        //如果数组为空，或者长度小于二无法框出面积
        if (height == null || height.length < 2) {
            return 0;
        }

        for (int i = 0; i < height.length - 1; i++) {
            //如果高度为0 跳至下一次循环【因为0乘0任何数都为0】
            if (height[i] == 0) {
                continue;
            }
            if (height[i] > max / (height.length - 1 - i)) {
                for (int j = i + 1; j < height.length; j++) {
                    int result = (j - i) * Math.min(height[i], height[j]);
                    if (result > max) {
                        max = result;
                    }
                }
            }

        }
        return max;
    }
}

