/**
 * Created by Travis Zeng  on 2017/7/14.
 */

import java.util.*;

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


    /**
     * solved on 2017/9/20
     * */

    /**
     *  Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

     Example 1:
     Given tree s:

     3
     / \
     4   5
     / \
     1   2

     Given tree t:

     4
     / \
     1   2

     Return true, because t has the same structure and node values with a subtree of s.

     Example 2:
     Given tree s:

     3
     / \
     4   5
     / \
     1   2
     /
     0

     Given tree t:

     4
     / \
     1   2

     Return false.
     * */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s,true);
        String tree2 = preorder(t,true);

        return tree1.indexOf(tree2)>=0;
    }

    public String preorder(TreeNode t,boolean isLeft){
        if(t==null){
            if(isLeft)
                return "lnull";
            else
                return "rnull";
        }

        return "#"+t.val+" "+preorder(t.left,true)+" "+preorder(t.right,false);
    }


    /**
     * walk through tree and project its location and val to hashmap
     * hashmap<location,val>
     * start param:root node of the tree
     * position=0
     *
     * @return the max position
     */


    int maxNodePosition = 0;
    public int treeToHashmap(TreeNode root,int position,Map<Integer,Integer> positionMap){


        if(root==null) return maxNodePosition;
        if(root.left!=null) {
            positionMap.put(2*position+1,root.left.val);
            if(2*position+1>maxNodePosition) maxNodePosition = 2*position+1;
            treeToHashmap(root.left,2*position+1,positionMap);
        }

        if(root.right!=null){
            positionMap.put(2*position+2,root.right.val);
            if(2*position+2>maxNodePosition) maxNodePosition = 2*position+2;
            treeToHashmap(root.right,2*position+2,positionMap);
        }

        return maxNodePosition;
    }

    /**
     * get tree node position list
     * init params root node and root node's position 0
     *
     * */


    public void getPositionList(TreeNode root,int position,List<Integer> positionList){
        if(root == null) return;
        if(root.left !=null)
            positionList.add(position*2+1);
        if(root.right !=null)
            positionList.add(position*2+2);
    }


    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).

     For example:
     Given binary tree [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7

     return its bottom-up level order traversal as:

     [
     [15,7],
     [9,20],
     [3]
     ]

     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> listArray = new ArrayList<>();
        if(root==null){
            return listArray;
        }

        int h = getHeightOfTree(root);
        for(int i=0;i<h;i++){
            listArray.add(new ArrayList<>());
        }

        inorder(listArray,root,0,h);
        return listArray;
    }


    /**
     * inorder traverse
     * */
    public void inorder(List<List<Integer>> listArray,TreeNode root,int h,int size){
        if(root==null){
            return;
        }

        listArray.get(size-h-1).add(root.val);
        inorder(listArray,root.left,h+1,size);
        inorder(listArray,root.right,h+1,size);
    }

    /**
     * get binary tree height
     * */
    public int getHeightOfTree(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(getHeightOfTree(root.left),getHeightOfTree(root.right));

    }



    /**
     * DFS solution
     * */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }


    /**
     * Path sum III
     * You are given a binary tree in which each node contains an integer value.

     Find the number of paths that sum to a given value.

     The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

     The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

     Example:

     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

     10
     /  \
     5   -3
     / \    \
     3   2   11
     / \   \
     3  -2   1

     Return 3. The paths that sum to 8 are:

     1.  5 -> 3
     2.  5 -> 2 -> 1
     3. -3 -> 11

     * */

    /**
     * DFS solution
     * */
    public int pathSum(TreeNode root, int sum) {
       if(root == null) return 0;
       return pathSumFrom(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private int pathSumFrom(TreeNode node,int sum){
        if(node == null) return 0;
        return (node.val ==sum?1:0) +pathSumFrom(node.left,sum-node.val)+pathSumFrom(node.right,sum-node.val);
    }



    public static void main(String[] args){
        /**
         * Test case:
         *         3
         *        / \
         *       4   5
         *      /\   \
         *     1  2   6
         *         \   \
         *          9  7
         * */
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right=new TreeNode(5);

        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.right = new TreeNode(9);

        s.right.right  = new TreeNode(6);
        s.right.right.right  = new TreeNode(7);

        TreeNode t =new TreeNode(4);
        t.left =new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(s.pathSum(s,9));




    }
}
