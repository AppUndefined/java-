package com.exercises.java;

import com.exercises.java.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class 二叉树的下一个结点 {
    /**
     * 题目描述：
     给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    @Test
    void contextLoads() {
        // 缓存中序遍历数组每个值对应的索引
        Integer[] pre = {3,9,20,15,7};
        TreeNode treeNode = new TreeNode();
        treeNode.creat(pre);
        treeNode.preorder(treeNode.root);
        treeNode.inorder(treeNode.root);
    }

    /**
     *解题思路
     我们先来回顾一下中序遍历的过程：先遍历树的左子树，再遍历根节点，最后再遍历右子树。所以最左节点是中序遍历的第一个节点。
         ① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
         ② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
     * @return
     */
    public TreeNode GetNext(TreeNode pNode) {
        if (pNode.right != null) {
            TreeNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.parent != null) {
                TreeNode parent = pNode.parent;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.parent;
            }
        }
        return null;
    }
}
