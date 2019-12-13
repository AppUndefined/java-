package com.exercises.java;

import com.exercises.java.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class 重建二叉树 {
    /**
     * 题目描述：
     *根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * preorder(前序):3,9,20,15,7
     * inorder(中序): 9,3,15,20,7
     */
    @Test
    void contextLoads() {
        // 缓存中序遍历数组每个值对应的索引
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        treeNode.afterorder(treeNode);


    }

    /**
     *解题思路
     前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
     然后分别对左右子树递归地求解。
     * @return
     */
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     *
     * @param pre
     * @param preL
     * @param preR
     * @param inL 已经使用过的中序下标
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if(preL>preR)return null;
        TreeNode treeNode = new TreeNode();
        treeNode.setData(pre[preL]);
        int index = indexForInOrders.get(pre[preL]);
        int leftSize = index - inL;
        treeNode.left = reConstructBinaryTree(pre,preL+1,preL+leftSize,inL);
        treeNode.right = reConstructBinaryTree(pre,preL+leftSize+1,preR,inL+leftSize+1);
        return treeNode;
    }
}
