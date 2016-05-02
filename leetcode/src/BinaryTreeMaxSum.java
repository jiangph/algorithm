/**
 * Created by jiangph on 16-5-2.
 */


/**
 *  Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 */

public class BinaryTreeMaxSum {

    /**
     *递归
     * 分清楚情况来考虑
     * 1,root最大
     * 2,root加左子树最大
     * 3,root加右子树最大
     * 4,root+left+right
     */

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(TreeNode left,TreeNode right,int val)
        {
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
    public class Solution{
        public int maxresult=Integer.MAX_VALUE;
        public int MaxSumPath(TreeNode root){
            if (root==null) return 0;
            else
                maxresult=maxSum(root);
            return maxresult;
        }
        public int maxSum(TreeNode root)
        {
            if (root==null) return 0;
            //recursion for left child tree and right tree
            int left=maxSum(root.left);
            int right=maxSum(root.right);
            //
            int currResult=root.val;
            if (left>0) currResult+=left;
            if (right>0) currResult+=right;

            if (currResult>maxresult) maxresult=currResult;

            //recur for result(important)
            return Math.max(root.val,Math.max(root.val+left,root.val+right));
        }

    }




}
