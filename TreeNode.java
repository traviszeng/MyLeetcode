/**
 * Created by Travis Zeng  on 2017/7/14.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * binary tree node abstract class
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     *  Given two binary trees and imagine that when you put one of them to cover the other,
     *  some nodes of the two trees are overlapped while the others are not.
     You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     then sum node values up as the new value of the merged node.
     Otherwise, the NOT null node will be used as the node of new tree.
     *
     *
     * */

    /**
     * Input:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * Output:
     * Merged tree:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);

        return newNode;
    }


    /**
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    /**
     * Invert a binary tree.
     * <p>
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * <p>
     * to
     * <p>
     * 4
     * /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) return root;
        else {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }

    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     Example:
     Input: The root of a Binary Search Tree like this:
     5
     /   \
     2     13
     Output: The root of a Greater Tree like this:
     18
     /   \
     20     13
     *
     * */

    /**
     * 中序遍历
     */

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode node) {
        convert(node.right);
        node.val += sum;
        sum = node.val;
        convert(node.left);
    }


    /**
     * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
     * <p>
     * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
     * <p>
     * Example 1:
     * <p>
     * Input: Binary tree: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * <p>
     * Output: "1(2(4))(3)"
     * <p>
     * Explanation: Originallay it needs to be "1(2(4)())(3()())",
     * but you need to omit all the unnecessary empty parenthesis pairs.
     * And it will be "1(2(4))(3)".
     * <p>
     * Example 2:
     * <p>
     * Input: Binary tree: [1,2,3,null,4]
     * 1
     * /   \
     * 2     3
     * \
     * 4
     * <p>
     * Output: "1(2()(4))(3)"
     * <p>
     * Explanation: Almost the same as the first example,
     * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output
     */
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return t.val + "";
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    public String tree2strII(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        build(t, sb);
        return sb.toString();
    }

    public void build(TreeNode t, StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left != null || t.right != null) {
            sb.append("(");
            build(t.left, sb);
            sb.append(")");
            if (t.right != null) {
                sb.append("(");
                build(t.right, sb);
                sb.append(")");
            }
        }
    }

    /**
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     * Example 1:
     * Input:
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * Output: [3, 14.5, 11]
     * Explanation:
     * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
     * Note:
     * The range of node's value is in the range of 32-bit signed integer.
     */
    public class AverageOfLevelsInBinaryTree {
        //使用bfs遍历访问节点
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            //用LinkedList的方式实现队列
            Queue<TreeNode> q = new LinkedList<>();

            if (root == null) return result;
            q.add(root);
            while (!q.isEmpty()) { //只要队列中非空
                int n = q.size();
                double sum = 0.0;
                for (int i = 0; i < n; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }

                }

                result.add(sum / n);
            }
            return result;
        }

    }
}
