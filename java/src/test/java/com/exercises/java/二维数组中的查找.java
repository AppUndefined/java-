package com.exercises.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//@SpringBootTest
class 二维数组中的查找 {
    /**
     * 题目描述
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     *
     * Consider the following matrix:
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     *
     * Given target = 5, return true.
     * Given target = 20, return false.
     * 要求时间复杂度 O(M + N)，空间复杂度 O(1)
     */
    @Test
    void contextLoads() {
        String a = "aaaa a";
        int [][] arr = {{1,  4,  7,  11, 15},
                        {2,  5,  8,  12, 19},
                        {3,  6,  9,  16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        boolean key = findKey(18, arr);
        System.out.println(key);
    }

    /**
     *解题思路
     要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
     因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     * @return
     */
    boolean findKey(int key,int[][] arr) {
        if(arr==null||arr.length == 0|| arr[0].length == 0){
            return false;
        }
        int r = 0,c = arr[0].length-1;
        while (r < arr.length  && c >= 0 ){
            if(key == arr[r][c]){
                return true;
            }
            if(key > arr[r][c]){
                r++;
            }else {
                c--;
            }
            System.out.println(r+"::"+c);
        }
        return false;

    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
