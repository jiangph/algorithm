/**
 * Created by jiangph on 16-5-1.
 */


/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 前序遍历，注意保存中间变量。
 */
public class FlatBinary {

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
        public  void flatBinaryTree(TreeNode root)
        {
            helper(root,null);
        }

        void helper(TreeNode root,TreeNode pre)
        {
            if (root==null) return;
            //restore the current node
            if (pre!=null)
            {
                pre.left=null;
                pre.right=root;
            }
            pre=root;
            //recur the left node and right node
            TreeNode left=root.left;
            TreeNode right=root.right;
            if (left!=null) helper(left,pre);
            if (right!=null) helper(right,pre);

        }
    }

}
