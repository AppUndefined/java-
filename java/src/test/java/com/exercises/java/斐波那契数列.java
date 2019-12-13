package com.exercises.java;

import com.exercises.java.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class 斐波那契数列 {
    /**
     * 题目描述：
        求斐波那契数列的第 n 项，n <= 39。

             {0               n = 0
        f(n)={1               n = 1
             {f(n-1)+f(n-1)   n > 1

     */
    /**
     *解题思路
     递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把***子问题的解缓存起来****，从而避免重复求解子问题。
     * @return
     */
    private static Long[] farr = new Long[40];
    static{
        farr[0] = 0L;
        farr[1] = 1L;
        for (int i = 2; i < farr.length; i++){
            farr[i] = farr[i-1]+ farr[i-2];
        }
    }
    @Test
    void contextLoads() {
        System.out.println(Arrays.toString(farr));

    }



}
