package com.exercises.java.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;
    public TreeNode parent;//当前的节点的父节点
//    数据域
    private Object data;
    //    存节点
    public List<TreeNode> datas;
 
    public TreeNode(TreeNode left, TreeNode right, Object data){
        this.left=left;
        this.right=right;
        this.data=data;
    }
//    将初始的左右孩子值为空
    public TreeNode(Object data){
        this(null,null,data);
    }
 
    public TreeNode() {
 
    }
 
    public void creat(Object[] objs){
        datas=new ArrayList<TreeNode>();
        //        将一个数组的值依次转换为Node节点
        for(Object o:objs){
            datas.add(new TreeNode(o));
        }
//        第一个数为根节点
        root=datas.get(0);
//        建立二叉树
        for (int i = 0; i <objs.length/2; i++) {
//            左孩子
            datas.get(i).left=datas.get(i*2+1);
//            右孩子
            if(i*2+2<datas.size()){//避免偶数的时候 下标越界
                datas.get(i).right=datas.get(i*2+2);
            }
        }
    }
//先序遍历
public void preorder(TreeNode root){
    if(root!=null){
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
}
//中序遍历
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
//    后序遍历
    public void afterorder(TreeNode root){
        if(root!=null){
            afterorder(root.left);
            afterorder(root.right);
            System.out.println(root.data);
        }
    }
    public static void main(String[] args) {
        TreeNode bintree=new TreeNode();
        Object []a={2,4,5,7,1,6,12,32,51,22};
        bintree.creat(a);
        bintree.preorder(bintree.root);
    }
}
