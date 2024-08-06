package com.gouminger.data.binary.search.chapter5;

import com.gouminger.data.binary.search.common.TreeNode;

//最接近的二叉搜索树值
public class ClosestValue {

    /**
     * 给你二叉搜索树的根节点 root 和一个目标值 target ，请在该二叉搜索树中找到最接近目标值 target 的数值。如果有多个答案，返回最小的那个。
     */
    public static void main(String[] args) {
        TreeNode node1_1 = new TreeNode(4);
        TreeNode node1_2 = new TreeNode(2);
        TreeNode node1_3 = new TreeNode(5);
        TreeNode node1_4 = new TreeNode(1);
        TreeNode node1_5 = new TreeNode(3);
        node1_1.left = node1_2;
        node1_1.right = node1_3;
        node1_2.left = node1_4;
        node1_2.right = node1_5;
        System.out.println(closestValue(node1_1, 3.7D));
        System.out.println(closestValue(node1_1, 4.5D));

        TreeNode node2_1 = new TreeNode(1);
        System.out.println(closestValue(node2_1, 4.4D));
    }

    public static int closestValue(TreeNode root, double target) {
        double result = root.val - target;
        if (result == 0D) {
            return root.val;
        } else if (result < 0D) {
            if (root.right == null) {
                return root.val;
            } else {
                int r = closestValue(root.right, target);
                double abs = Math.abs(result) - Math.abs(r - target);
                if (abs == 0D) {
                    return Math.min(root.val, r);
                }
                return abs < 0 ? root.val : r;
            }
        } else {
            if (root.left == null) {
                return root.val;
            } else {
                int r = closestValue(root.left, target);
                double abs = Math.abs(result) - Math.abs(r - target);
                if (abs == 0D) {
                    return Math.min(root.val, r);
                }
                return abs < 0 ? root.val : r;
            }
        }
    }
}
