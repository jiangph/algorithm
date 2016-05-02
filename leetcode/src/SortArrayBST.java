/**
 * Created by jiangph on 16-5-2.
 */

/**
 *Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Thoughts

 Straightforward! Recursively do the job. 
 */
public class SortArrayBST {

    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val)
        {
            this.val=val;
        }
    }

    public class Solution{

        public  TreeNode sortedArrayToBST(int[]num)
        {
            if (num==null) return null;
            else
                return sortedArrayToBST(num,0,num.length-1);
        }

        public TreeNode sortedArrayToBST(int[]num,int start,int end)
        {
            if (start>end) return null;

            int mid=(start+end)/2;
            TreeNode root=new TreeNode(num[mid]);
            root.left=sortedArrayToBST(num,0,mid);
            root.right=sortedArrayToBST(num,mid+1,end);

            return root;
        }

    }

}
