package com.skwqy.study.leetcode.common;

import java.util.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-04 14:03
 */
public class TreeUtils {

    public static TreeNode createBTreeByArray(int[] array, int index) {
        TreeNode result = null;
        if (index < array.length) {
            int value = array[index];
            result = new TreeNode(value);
            result.left = createBTreeByArray(array, 2 * index + 1);
            result.right = createBTreeByArray(array, 2 * index + 2);
        }
        return result;
    }

    public static TreeNode createBTreeByArray(Integer[] array, int index) {
        TreeNode result = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            result = new TreeNode(value);
            result.left = createBTreeByArray(array, 2 * index + 1);
            result.right = createBTreeByArray(array, 2 * index + 2);
        }
        return result;
    }

    public static Integer[] toArrayByBfs(TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> result = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode tmpNode = deque.remove();
            result.add(tmpNode.val);
            if(tmpNode.left != null){
                deque.add(tmpNode.left);
            }

            if(tmpNode.right != null){
                deque.add(tmpNode.right);
            }

        }
        return result.toArray(new Integer[0]);
    }

    public static Integer[] toArrayByDfs(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode tmpNode = stack.pop();
            result.add(tmpNode.val);
            if(tmpNode.left != null){
                stack.push(tmpNode.left);
            }

            if(tmpNode.right != null){
                stack.push(tmpNode.right);
            }

        }
        return result.toArray(new Integer[0]);
    }
}
